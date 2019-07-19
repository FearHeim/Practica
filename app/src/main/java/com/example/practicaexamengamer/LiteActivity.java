package com.example.practicaexamengamer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LiteActivity extends AppCompatActivity {

    Button buttontitulo, buttonedition, buttonsave, buttonmodificar, buttoneliminar;
    EditText titulo, edicion;
    TextView textdb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lite);
        buttoneliminar=findViewById(R.id.buttoneliminar);
        buttonmodificar=findViewById(R.id.buttonmodificar);
        buttonsave=findViewById(R.id.buttonsave);
        titulo=findViewById(R.id.buttontitulo);
        edicion=findViewById(R.id.buttonedition);


       // Book book=new Book("Title here", "2nd edition");
        //book.save();
        //Log.e("GUARDADO","Se guardo");

       // Book book = Book.findById(Book.class, 1);

        buttonsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Book book=new Book(titulo.getText().toString(), edicion.getText().toString());
                    book.save();
            }
        });
    }
}
