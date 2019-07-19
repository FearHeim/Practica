package com.example.practicaexamengamer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListaActivity extends AppCompatActivity {

    ListView listViewLibros;
    EditText titulo, edicion;
    Button btnGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        listViewLibros=findViewById(R.id.lista);

        List<Book> books=Book.listAll(Book.class);
        List<String> lista=new ArrayList<>();
        //foreach
        for (Book libro: books){
            Log.e("Libro", libro.getTitle()+" "+libro.getEdition());
            lista.add(libro.getTitle()+" "+libro.getEdition());

        }

        ArrayAdapter<String> itemsAdapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,lista);
        listViewLibros.setAdapter(itemsAdapter);



    }


}
