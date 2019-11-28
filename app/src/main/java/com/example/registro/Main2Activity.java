package com.example.registro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class Main2Activity extends AppCompatActivity {

    private ArrayList<Alumno> alumnos2= (ArrayList<Alumno>) getIntent().getSerializableExtra("nombres");
   // private ArrayList<String> alumnos2=getIntent().getStringArrayListExtra("nombres");;

    private ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        lista=findViewById(R.id.lv1);

       // ArrayAdapter<String> adaptador= new ArrayAdapter(this,android.R.layout.activity_list_item,alumnos2);
        //lista.setAdapter(adaptador);
    }

    public void Regreso(View view){
        Intent atras = new Intent(this,MainActivity.class);
        startActivity(atras);
        finish();
    }
}
