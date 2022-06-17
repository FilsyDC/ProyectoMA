package com.example.aprendecontigrito;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class InicioSesion extends AppCompatActivity {
    private Intent volverRegistrar, accesoAceptado;
    private EditText recibirUsuarioInicio, recibirContrasenaInicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciosesion);

        recibirUsuarioInicio = (EditText) findViewById(R.id.cajaUsuarioInicio);
        recibirContrasenaInicio = (EditText) findViewById(R.id.cajaContrasenaInicio);
    }

    public void Acceder(View view) {
        BaseDeDatos administrador = new BaseDeDatos(this, "administrar", null, 1);
        SQLiteDatabase BaseInicioUsuarios = administrador.getReadableDatabase();

        String buscarUsuario = recibirUsuarioInicio.getText().toString();
        String buscarContrasena = recibirContrasenaInicio.getText().toString();

        if(!buscarUsuario.isEmpty() && !buscarContrasena.isEmpty()) {
            Cursor fila = BaseInicioUsuarios.rawQuery("select contrasena, usuario from usuarios where usuario ='" + buscarUsuario + "' and contrasena ='" + buscarContrasena + "'", null);

                if(fila.moveToFirst()){
                    String compararContrasena = (fila.getString(0));
                    String compararUsuario = (fila.getString(1));

                    if(compararContrasena.matches(buscarContrasena) && compararUsuario.matches(buscarUsuario)){
                        accesoAceptado = new Intent(this, SalaDeEstar.class);
                        accesoAceptado.putExtra("usuarioActivo", buscarUsuario);
                        startActivity(accesoAceptado);

                        Toast.makeText(this, "¡Bienvenid@, " + buscarUsuario + "!", Toast.LENGTH_SHORT).show();
                    }
                } else{
                    Toast.makeText(this, "El usuario y/o la contraseña son incorrectos.", Toast.LENGTH_SHORT).show();
                }
        } else{
            Toast.makeText(this, "Por favor, ¡Llena todos los campos!", Toast.LENGTH_SHORT).show();
        }
    }

        public void RegresarRegistrar (View view){
            volverRegistrar = new Intent(this, RegistroConInicio.class);
            startActivity(volverRegistrar);
        }
}