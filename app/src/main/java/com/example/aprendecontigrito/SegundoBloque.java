package com.example.aprendecontigrito;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SegundoBloque extends AppCompatActivity {
    public EditText recibirRespuesta1, recibirRespuesta2, recibirRespuesta3;
    public int respuestasBuenas = 0;
    public TextView textoP1, textoP2, textoP3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.interfaz_segundobloque);

        recibirRespuesta1 = (EditText)findViewById(R.id.respuestaProblema1B2);
        recibirRespuesta2 = (EditText)findViewById(R.id.respuestaProblema2B2);
        recibirRespuesta3 = (EditText)findViewById(R.id.respuestaProblema3B2);

        textoP1 = (TextView)findViewById(R.id.tituloProblema1B2);
        textoP2 = (TextView)findViewById(R.id.tituloProblema2B2);
        textoP3 = (TextView)findViewById(R.id.tituloProblema3B2);

    }
    public void Revisar(View view){
        String respuesta1 = recibirRespuesta1.getText().toString();
        String respuesta2 = recibirRespuesta2.getText().toString();
        String respuesta3 = recibirRespuesta3.getText().toString();

        if(respuesta1.isEmpty() || respuesta2.isEmpty() || respuesta3.isEmpty()){
            Toast.makeText(this, "¿Qué pasó? ¡Termina de contestar todas!", Toast.LENGTH_SHORT).show();
            respuestasBuenas = 0;
        } else {
            if (respuesta1.equals("23")) {
                respuestasBuenas++;
            }
            if (respuesta2.equals("21")){
                respuestasBuenas++;
            }
            if (respuesta3.equals("12")){
                respuestasBuenas++;
            }

            if(respuestasBuenas == 0){
                Toast.makeText(this, "No tuviste ningún acierto... ¡Sigue intentando! Tú puedes.", Toast.LENGTH_SHORT).show();
                respuestasBuenas = 0;
            } else if(respuestasBuenas == 1){
                Toast.makeText(this, "Solo tuviste un acierto; tienes 3.3", Toast.LENGTH_SHORT).show();
                respuestasBuenas = 0;
            } else if(respuestasBuenas == 2){
                Toast.makeText(this, "Tuviste dos aciertos; tienes 6.", Toast.LENGTH_SHORT).show();
                respuestasBuenas = 0;
            } else if(respuestasBuenas == 3){
                Toast.makeText(this, "Tuviste tres aciertos; tienes 10... ¡Felicidades!", Toast.LENGTH_SHORT).show();
                respuestasBuenas = 0;
            }
        }
    }
}