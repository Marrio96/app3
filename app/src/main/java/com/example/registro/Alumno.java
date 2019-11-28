package com.example.registro;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

@SuppressLint("ParcelCreator")

public class Alumno implements Parcelable {
    private String Nombre,
                   Apellido,
                   Genero;
    private int numero_cuenta;

    public Alumno(String nombre, String apellido, String genero, int numero_cuenta) {
        Nombre = nombre;
        Apellido = apellido;
        Genero = genero;
        this.numero_cuenta = numero_cuenta;
    }

    protected Alumno(Parcel in) {
        Nombre = in.readString();
        Apellido = in.readString();
        Genero = in.readString();
        numero_cuenta = in.readInt();
    }

    public static final Creator<Alumno> CREATOR = new Creator<Alumno>() {
        @Override
        public Alumno createFromParcel(Parcel in) {
            return new Alumno(in);
        }

        @Override
        public Alumno[] newArray(int size) {
            return new Alumno[size];
        }
    };

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String genero) {
        Genero = genero;

    }

    public int getNumero_cuenta() {
        return numero_cuenta;
    }

    public void setNumero_cuenta(int numero_cuenta) {
        this.numero_cuenta = numero_cuenta;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(Nombre);
        dest.writeString(Apellido);
        dest.writeString(Genero);
        dest.writeInt(numero_cuenta);
    }
}
