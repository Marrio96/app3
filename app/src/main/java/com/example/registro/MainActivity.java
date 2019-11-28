package com.example.registro;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    /*Declaracion de variables*/
    private EditText cuenta,
                     nombre,
                     apellido;
    private RadioButton mujer,
                        hombre;
    private MediaPlayer button;
    private MediaPlayer listados;
    private ArrayList<Alumno> alumnos = new ArrayList<Alumno>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cuenta=findViewById(R.id.cuenta);
        nombre=findViewById(R.id.Nombre);
        apellido=findViewById(R.id.Apellido);
        mujer=findViewById(R.id.mujer);
        hombre=findViewById(R.id.hombre);
        button=MediaPlayer.create(this,R.raw.botton);
        listados= MediaPlayer.create(this,R.raw.list);
    }

    /*Funcion para validar campos*/
    public void validar(View view)
    {
        button.start();
        if(cuenta.length()==0 ){
            cuenta.setError(getResources().getString(R.string.Error3));
        }
        else if(cuenta.length()<9){
            cuenta.setError(getResources().getString(R.string.Error3));
        }
        if(nombre.length()==0){
            nombre.setError(getResources().getString(R.string.Error1));
        }
        if(apellido.length()==0){
            apellido.setError(getResources().getString(R.string.Error2));
        }
        if(mujer.isChecked()==false && hombre.isChecked()==false)
        {
            Toast.makeText(this,getResources().getString(R.string.Error4),Toast.LENGTH_SHORT).show();
        }
        if((mujer.isChecked()==true || hombre.isChecked()==true) && apellido.length()!=0 && nombre.length()!=0
        && cuenta.length()==9){
            registrar();
        }
    }
    /*Metodo para registrar akumnos*/
     public void registrar(){
         /*Creamos variables locales en funcion*/
         String  nombre_string,
                 apellido_string,
                 genero_string = null;
         int cuenta_int;
         /*Pasamos lo escrito en los view a variables locales*/
         nombre_string=nombre.getText().toString();
         apellido_string=apellido.getText().toString();
         cuenta_int=Integer.parseInt(cuenta.getText().toString());
         if(mujer.isChecked()==true){
             genero_string=getResources().getString(R.string.Mujer);
         }
         if(hombre.isChecked()==true){
             genero_string=getResources().getString(R.string.Hombre);
         }
         /*Borramos lo escrito en los campos*/
         nombre.setText(null);
         apellido.setText(null);
         cuenta.setText(null);
         mujer.setChecked(false);
         hombre.setChecked(false);
         /*Agregamos los campos a los arraylist */
         alumnos.add(new Alumno(nombre_string,apellido_string,genero_string,cuenta_int));
         Toast.makeText(this,getResources().getString(R.string.registro),Toast.LENGTH_SHORT).show();
     }
    //Metodo para pasar a ptra activity
     public void listar(View view){
        Intent siguiente = new Intent(this,Main2Activity.class);
        startActivity(siguiente);
        siguiente.putParcelableArrayListExtra("nombres",alumnos);
        listados.start();
        finish();
   }
}
