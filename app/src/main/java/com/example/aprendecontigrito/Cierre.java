package com.example.aprendecontigrito;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Cierre extends AppCompatActivity {
    public EditText recibirRespuesta1, recibirRespuesta2, recibirRespuesta3;
    public int respuestasBuenas = 0;
    public TextView textoP1, textoP2, textoP3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.interfaz_cierre);

        recibirRespuesta1 = (EditText)findViewById(R.id.respuestaProblema1B3);
        recibirRespuesta2 = (EditText)findViewById(R.id.respuestaProblema2B3);

    }
    public void Revisar(View view){
        String respuesta1 = recibirRespuesta1.getText().toString();
        String respuesta2 = recibirRespuesta2.getText().toString();

        if(respuesta1.isEmpty() || respuesta2.isEmpty()){
            Toast.makeText(this, "¿Qué pasó? ¡Termina de contestar todas!", Toast.LENGTH_SHORT).show();
            respuestasBuenas = 0;
        } else {
            if (respuesta1.equals("2.3")){
                respuestasBuenas++;
            }
            if (respuesta2.equals("4.28")){
                respuestasBuenas++;
            }

            if(respuestasBuenas == 0){
                Toast.makeText(this, "No tuviste ningún acierto... ¡Sigue intentando! Tú puedes.", Toast.LENGTH_SHORT).show();
                respuestasBuenas = 0;
            } else if(respuestasBuenas == 1){
                Toast.makeText(this, "Solo tuviste un acierto; tienes 5.", Toast.LENGTH_SHORT).show();
                respuestasBuenas = 0;
            } else if(respuestasBuenas == 2){
                Toast.makeText(this, "Tuviste dos aciertos; tienes 10", Toast.LENGTH_SHORT).show();
                respuestasBuenas = 0;
            }
        }
    }
}