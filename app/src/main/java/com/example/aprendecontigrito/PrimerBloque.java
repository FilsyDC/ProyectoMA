package com.example.aprendecontigrito;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PrimerBloque extends AppCompatActivity {
    public EditText recibirRespuesta1, recibirRespuesta2, recibirRespuesta3, recibirRespuesta4, recibirRespuesta5;
    public int respuestasBuenas = 0;
    public Button botonRegresar, botonSigue, botonRevision;
    public TextView textoP1, textoP2, textoP3, textoP4, textoP5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.interfaz_primerbloque);

        recibirRespuesta1 = (EditText)findViewById(R.id.respuestaProblema1);
        recibirRespuesta2 = (EditText)findViewById(R.id.respuestaProblema2);
        recibirRespuesta3 = (EditText)findViewById(R.id.respuestaProblema3);
        recibirRespuesta4 = (EditText)findViewById(R.id.respuestaProblema4);
        recibirRespuesta5 = (EditText)findViewById(R.id.respuestaProblema5);

        textoP1 = (TextView)findViewById(R.id.tituloProblema1);
        textoP2 = (TextView)findViewById(R.id.tituloProblema2);
        textoP3 = (TextView)findViewById(R.id.tituloProblema3);
        textoP4 = (TextView)findViewById(R.id.tituloProblema4);
        textoP5 = (TextView)findViewById(R.id.tituloProblema5);

        botonRegresar = (Button)findViewById(R.id.botonRegresar);
        botonRevision = (Button)findViewById(R.id.botonRevisar);

        recibirRespuesta4.setEnabled(false);
        recibirRespuesta5.setEnabled(false);

        botonRegresar.setEnabled(false);
        botonRegresar.setVisibility(View.INVISIBLE);

        botonRevision.setEnabled(false);
        botonRevision.setVisibility(View.INVISIBLE);

        botonSigue = (Button) findViewById(R.id.botonSiguiente);
    }
    public void siguientePagina(View view){
        recibirRespuesta1.setEnabled(false);
        recibirRespuesta1.setVisibility(View.INVISIBLE);

        recibirRespuesta2.setEnabled(false);
        recibirRespuesta2.setVisibility(View.INVISIBLE);

        recibirRespuesta3.setEnabled(false);
        recibirRespuesta3.setVisibility(View.INVISIBLE);

        textoP1.setVisibility(View.INVISIBLE);
        textoP2.setVisibility(View.INVISIBLE);
        textoP3.setVisibility(View.INVISIBLE);

        textoP4.setVisibility(View.VISIBLE);
        textoP5.setVisibility(View.VISIBLE);

        recibirRespuesta4.setEnabled(true);
        recibirRespuesta4.setVisibility(View.VISIBLE);

        recibirRespuesta5.setEnabled(true);
        recibirRespuesta5.setVisibility(View.VISIBLE);

        botonRegresar.setEnabled(true);
        botonRegresar.setVisibility(View.VISIBLE);

        botonRevision.setEnabled(true);
        botonRevision.setVisibility(View.VISIBLE);

        botonSigue.setEnabled(false);
        botonSigue.setVisibility(View.INVISIBLE);
    }
    public void volver(View view){
        recibirRespuesta1.setEnabled(true);
        recibirRespuesta1.setVisibility(View.VISIBLE);

        recibirRespuesta2.setEnabled(true);
        recibirRespuesta2.setVisibility(View.VISIBLE);

        recibirRespuesta3.setEnabled(true);
        recibirRespuesta3.setVisibility(View.VISIBLE);

        textoP1.setVisibility(View.VISIBLE);
        textoP2.setVisibility(View.VISIBLE);
        textoP3.setVisibility(View.VISIBLE);

        recibirRespuesta4.setEnabled(false);
        recibirRespuesta4.setVisibility(View.INVISIBLE);

        recibirRespuesta5.setEnabled(false);
        recibirRespuesta5.setVisibility(View.INVISIBLE);

        textoP4.setVisibility(View.INVISIBLE);
        textoP5.setVisibility(View.INVISIBLE);

        botonRegresar.setEnabled(false);
        botonRegresar.setVisibility(View.INVISIBLE);

        botonRevision.setEnabled(false);
        botonRevision.setVisibility(View.INVISIBLE);

        botonSigue.setEnabled(true);
        botonSigue.setVisibility(View.VISIBLE);
    }
    public void Revisar(View view){
        String respuesta1 = recibirRespuesta1.getText().toString();
        String respuesta2 = recibirRespuesta2.getText().toString();
        String respuesta3 = recibirRespuesta3.getText().toString();
        String respuesta4 = recibirRespuesta4.getText().toString();
        String respuesta5 = recibirRespuesta5.getText().toString();

        if(respuesta1.isEmpty() || respuesta2.isEmpty() || respuesta3.isEmpty() || respuesta4.isEmpty() || respuesta5.isEmpty()){
            Toast.makeText(this, "¿Qué pasó? ¡Termina de contestar todas!", Toast.LENGTH_SHORT).show();
            respuestasBuenas = 0;
        } else {
            if (respuesta1.equals("9.4")) {
                respuestasBuenas++;
            }
            if (respuesta2.equals("-24")){
                respuestasBuenas++;
            }
            if (respuesta3.equals("-12")){
                respuestasBuenas++;
            }
            if (respuesta4.equals("8")){
                respuestasBuenas++;
            }
            if (respuesta5.equals("25π") || respuesta5.equals("25pi")){
                respuestasBuenas++;
            }

            if(respuestasBuenas == 0){
                Toast.makeText(this, "No tuviste ningún acierto... ¡Sigue intentando! Tú puedes.", Toast.LENGTH_SHORT).show();
                respuestasBuenas = 0;
            } else if(respuestasBuenas == 1){
                Toast.makeText(this, "Solo tuviste un acierto; tienes 2.", Toast.LENGTH_SHORT).show();
                respuestasBuenas = 0;
            } else if(respuestasBuenas == 2){
                Toast.makeText(this, "Tuviste dos aciertos; tienes 4.", Toast.LENGTH_SHORT).show();
                respuestasBuenas = 0;
            } else if(respuestasBuenas == 3){
                Toast.makeText(this, "Tuviste tres aciertos; tienes 6.", Toast.LENGTH_SHORT).show();
                respuestasBuenas = 0;
            } else if(respuestasBuenas == 4){
                Toast.makeText(this, "Tuviste tres aciertos; tienes 8.", Toast.LENGTH_SHORT).show();
                respuestasBuenas = 0;
            } else if(respuestasBuenas == 5){
                Toast.makeText(this, "Tuviste tres aciertos; tienes 10... ¡Felicidades!", Toast.LENGTH_SHORT).show();
                respuestasBuenas = 0;
            }

        }
    }
}