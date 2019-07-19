package com.example.practicaexamengamer;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class DatosActivity extends AppCompatActivity {
    CheckBox ch1, ch2, ch3, ch4;
    RadioGroup rad;
    EditText ed;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);

        assert getSupportActionBar() != null;

        getSupportActionBar().setTitle("Configuración");

        ch1 = findViewById(R.id.checkBox1);
        ch2 = findViewById(R.id.checkBox2);
        ch3 = findViewById(R.id.checkBox3);
        ch4 = findViewById(R.id.checkBox4);

        rad = findViewById(R.id.radio);
        ed = findViewById(R.id.edit1);
        btn = findViewById(R.id.buttonGuardarCambios);
        String[] archivos = fileList();

        if (existe(archivos, "config.txt")) {
            try {
                BufferedReader lector = new BufferedReader(new InputStreamReader(openFileInput("config.txt")));
                String datos = lector.readLine();
                String[] listaPersonas = datos.split(";");
                ed.setText("");
                for (int i = 0; i < listaPersonas.length; i++) {
                    if (listaPersonas[i].equals("Papyrus")) {
                        ch1.setChecked(true);
                    }
                    if (listaPersonas[i].equals("Sans")) {
                        ch2.setChecked(true);
                    }
                    if (listaPersonas[i].equals("Chiller")) {
                        ch3.setChecked(true);
                    }
                    if (listaPersonas[i].equals("Times New Roman")) {
                        ch4.setChecked(true);
                    }
                    if (listaPersonas[i].equals("R.id.rbtn1")) {
                        RadioButton r = findViewById(R.id.rbtn1);
                        r.setChecked(true);
                    }
                    if (listaPersonas[i].equals("R.id.rbtn2")) {
                        RadioButton r = findViewById(R.id.rbtn2);
                        r.setChecked(true);
                    }
                    if (listaPersonas[i].equals("R.id.rbtn3")) {
                        RadioButton r = findViewById(R.id.rbtn3);
                        r.setChecked(true);
                    }
                    if (listaPersonas[i].equals("R.id.rbtn4")) {
                        RadioButton r = findViewById(R.id.rbtn4);
                        r.setChecked(true);
                    }
                    if (listaPersonas[i+1].equals("AVER")) {
                        ed.setText(listaPersonas[i]);
                    }
                }
                lector.close();
            } catch (Exception ex) {
                ex.printStackTrace();
                Log.e("ARCHIVO MI", "ERROR " + ex.getMessage());
            }
        }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    deleteFile("config.txt");
                    OutputStreamWriter escritor = new OutputStreamWriter(openFileOutput("config.txt", Activity.MODE_APPEND));
                    if (ch1.isChecked()) {
                        escritor.write("Papyrus;");
                    }
                    if (ch2.isChecked()) {
                        escritor.write("Sans;");
                    }
                    if (ch3.isChecked()) {
                        escritor.write("Chiller;");
                    }
                    if (ch4.isChecked()) {
                        escritor.write("Times New Roman;");
                    }
                    switch (rad.getCheckedRadioButtonId()) {
                        case R.id.rbtn1:
                            escritor.write("R.id.rbtn1;");
                            break;
                        case R.id.rbtn2:
                            escritor.write("R.id.rbtn2;");
                            break;
                        case R.id.rbtn3:
                            escritor.write("R.id.rbtn3;");
                            break;
                        case R.id.rbtn4:
                            escritor.write("R.id.rbtn4;");
                            break;
                    }
                    escritor.write(ed.getText().toString() + ";");
                    escritor.write("AVER;");
                    escritor.flush();
                    escritor.close();
                    Toast.makeText(view.getContext(), "Los datos se grabaron con éxito", Toast.LENGTH_SHORT).show();
                } catch (Exception ex) {
                    ex.printStackTrace();
                    Log.e("ARCHIVO MI", "Error en el archivo de escritura");
                }
            }
        });
    }

    private boolean existe(String[] archivos, String archbusca) {
        for (int f = 0; f < archivos.length; f++)
            if (archbusca.equals(archivos[f]))
                return true;
        return false;
    }
    }

