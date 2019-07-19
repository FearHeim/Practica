package com.example.practicaexamengamer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class PantallaLocaActivity extends AppCompatActivity {

    TextView textView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_loca);
        textView3=(TextView) findViewById(R.id.textView3);
        Bundle bundle=this.getIntent().getExtras();
        textView3.setText("Su correo es:" +bundle.getString("Correo"));

    }

}
