package com.example.practicaexamengamer;

import android.app.Activity;
import android.content.Context;
import android.hardware.camera2.params.OutputConfiguration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ActividadMemoriaInterna extends AppCompatActivity implements View.OnClickListener{

    EditText cajaCedula, cajaNombres, cajaApellidos;
    TextView cajaDatos;
    Button botonLeer, botonEscribir;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_memoria_interna);
        cajaCedula= findViewById(R.id.editTextcedula);
        cajaApellidos=findViewById(R.id.editTextapellidos);
        cajaNombres=findViewById(R.id.editTextnombres);
        cajaDatos=findViewById(R.id.editTextpersonaname);

        botonEscribir=(Button) findViewById(R.id.buttonescribir);
        botonLeer=(Button)findViewById(R.id.buttonleer);

        botonEscribir.setOnClickListener(this);
        botonLeer.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonescribir:
                try{
                    OutputStreamWriter escritor=new OutputStreamWriter(openFileOutput("archivo.txt", Activity.MODE_APPEND));
                    escritor.write(cajaCedula.getText().toString()+","+cajaApellidos.getText().toString()+","+cajaNombres.getText().toString()
                    + ";" );
                    escritor.flush();
                    escritor.close();
                    Toast.makeText(v.getContext(), "Datos guardados", Toast.LENGTH_SHORT).show();
                }catch (Exception ex){
                    Log.e("Archivo MI", "Error");

                }
                break;

            case R.id.buttonleer:
                try{
                    BufferedReader lector=new BufferedReader(new InputStreamReader(openFileInput("archivo.txt")));
                    String datos=lector.readLine();
                    String[] listaPersonas=datos.split(";");
                    cajaDatos.setText("");
                    for(int i=0;i<listaPersonas.length;i++){
                        cajaDatos.append(listaPersonas[i] + "\n");
                    }

                    lector.close();
                    Toast.makeText(v.getContext(), "Datos existentes...", Toast.LENGTH_SHORT).show();
                }catch (Exception ex){
                    Log.e("Archivo MI", "Error en la lectura del archivo"+ex.getMessage());
                }
                break;
        }
    }
}
