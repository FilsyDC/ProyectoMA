package com.example.aprendecontigrito;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Inicio extends AppCompatActivity {
    private Intent irRegistro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.interfaz_inicio);
    }
    public void irRegistrarse(View view){
        irRegistro = new Intent(this, RegistroConInicio.class);
        startActivity(irRegistro);
    }
}