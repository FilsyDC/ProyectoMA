package com.example.aprendecontigrito;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegistroConInicio extends AppCompatActivity {
    private Intent irInicioSesion;
    private EditText recibirUsuario, recibirContrasena, recibirConfirmarContrasena;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.interfaz_registroconinicio);

        recibirUsuario = (EditText)findViewById(R.id.cajaNombreUsuario);
        recibirContrasena = (EditText)findViewById(R.id.cajaContrasenaUsuario);
        recibirConfirmarContrasena = (EditText)findViewById(R.id.cajaConfirmarContrasena);

    }
    public void RegistrarUsuario(View view){
        BaseDeDatos administrador = new BaseDeDatos(this, "administrar", null, 1);
        SQLiteDatabase BaseUsuariosRegistrados = administrador.getWritableDatabase();

        String usuarioFinal = recibirUsuario.getText().toString();
        String contrasenaFinal = recibirContrasena.getText().toString();
        String confirmarContrasena = recibirConfirmarContrasena.getText().toString();

        if(!usuarioFinal.isEmpty() && contrasenaFinal.matches(confirmarContrasena) && !contrasenaFinal.isEmpty() && !confirmarContrasena.isEmpty()) {
            Cursor fila = BaseUsuariosRegistrados.rawQuery("select usuario from usuarios where usuario = '" + usuarioFinal + "'", null);

            if(fila.moveToFirst()) {
                Toast.makeText(this, "Este nombre de usuario ya se ha registrado, ¡utiliza otro!", Toast.LENGTH_SHORT).show();
            } else{
                ContentValues registrar = new ContentValues();

                registrar.put("usuario", usuarioFinal);
                registrar.put("contrasena", contrasenaFinal);

                BaseUsuariosRegistrados.insert("usuarios", null, registrar);
                BaseUsuariosRegistrados.close();

                recibirUsuario.setText("");
                recibirContrasena.setText("");
                recibirConfirmarContrasena.setText("");

                Toast.makeText(this, "¡Te has registrado exitosamente!", Toast.LENGTH_SHORT).show();
            }
            } else if(!usuarioFinal.isEmpty() && contrasenaFinal != confirmarContrasena) {
                Toast.makeText(this, "¡Tus contraseñas no coinciden o están vacías!", Toast.LENGTH_SHORT).show();
            } else if(usuarioFinal.isEmpty() && contrasenaFinal.matches(confirmarContrasena) && !contrasenaFinal.isEmpty() && !confirmarContrasena.isEmpty()) {
                Toast.makeText(this, "¡Escribe un nombre de usuario!", Toast.LENGTH_SHORT).show();
            } else{
                Toast.makeText(this, "No se pudo crear tu cuenta... ¡Revisa los campos y llénalos correctamente!", Toast.LENGTH_SHORT).show();
            }
    }
    public void IniciarSesion(View view){
        irInicioSesion = new Intent(this, InicioSesion.class);
        startActivity(irInicioSesion);
    }
}