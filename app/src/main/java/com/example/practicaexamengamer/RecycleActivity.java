package com.example.practicaexamengamer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;



public class RecycleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle);


        RecyclerView recyclerView=findViewById(R.id.recycle);

        ArrayList<String> tareas=new ArrayList<>();

        for(int items=0; items<=10; items++){
            if(items==0){
                tareas.add("Top 10 juegos");
                continue;
            }
            tareas.add("Juego " +items);
        }

        TareasRecyclerViewAdapter adapter=new TareasRecyclerViewAdapter(this, tareas);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}
