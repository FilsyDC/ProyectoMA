package com.example.aprendecontigrito;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SalaDeEstar extends AppCompatActivity {
    private TextView usuarioOnline;
    private Intent irPrimerBloque, irSegundoBloque, irCierre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.interfaz_saladeestar);

        usuarioOnline = (TextView)findViewById(R.id.tituloUsuarioActivo);

        String usuarioConectado = getIntent().getStringExtra("usuarioActivo");
        usuarioOnline.setText(usuarioConectado+" se encuentra en línea.");
    }
    public void accederBloqueUno(View view){
        irPrimerBloque = new Intent(this, PrimerBloque.class);
        startActivity(irPrimerBloque);
    }
    public void accederBloqueDos(View view){
        irSegundoBloque = new Intent(this, SegundoBloque.class);
        startActivity(irSegundoBloque);
    }
    public void accederCierre(View view){
        irCierre = new Intent(this, Cierre.class);
        startActivity(irCierre);
    }
}