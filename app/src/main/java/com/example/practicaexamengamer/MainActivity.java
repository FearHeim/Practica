package com.example.practicaexamengamer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button login, memoria, datos, listaloca;
    Button parametros, lite;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        login=(Button)findViewById(R.id.login);
//        parametros=(Button)findViewById(R.id.parametro);
//        lite=(Button)findViewById(R.id.lite);
        memoria=(Button)findViewById(R.id.memoria);
        datos=(Button)findViewById(R.id.datos);
//        listaloca=findViewById(R.id.listaloca);

//        login.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(MainActivity.this, ImagenActivity.class);
//                startActivity(intent);
//            }
//        });

//        parametros.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(MainActivity.this, ParametroActivity.class);
//                startActivity(intent);
//            }
//        });

//        lite.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(MainActivity.this, LiteActivity.class);
//                startActivity(intent);
//            }
//        });
//
        memoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, ActividadMemoriaInterna.class);
                startActivity(intent);
            }
        });

        datos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, DatosActivity.class);
                startActivity(intent);
            }

        });

//        listaloca.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, ListaActivity.class);
//                startActivity(intent);
//
//
//            }
//        });





    }
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu){
//        MenuInflater inflater=getMenuInflater();
//        inflater.inflate(R.menu.main,menu);
//        return true;
//    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        Intent intent;
        switch (item.getItemId()){
            case R.id.opcionLogin:
                intent=new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.opcionBateria:
                intent=new Intent(MainActivity.this, ParametroActivity.class);
                startActivity(intent);
                break;
            case R.id.opcionLuz:
                intent=new Intent(MainActivity.this, LuzActivity.class);
                startActivity(intent);
                break;
            case R.id.Lista:
                intent=new Intent(MainActivity.this, RecycleActivity.class);
                startActivity(intent);
            case R.id.opcionProximidad:
                intent=new Intent(MainActivity.this, ActividadMemoriaInterna.class);
                startActivity(intent);


        }
        return true;
    }
}
