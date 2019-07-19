package com.example.practicaexamengamer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    Button ButtonLogin;
    EditText Correo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButtonLogin=(Button)findViewById(R.id.ButtonLogin);
        Correo=(EditText) findViewById(R.id.Correo);

        ButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, PantallaLocaActivity.class);
                Bundle bundle=new Bundle();
                bundle.putString("Correo", Correo.getText().toString());
                intent.putExtras(bundle);
                startActivity(intent);
            }


        });



    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.v("CUARTO A - BEYOND", "OnStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v("CUARTO A - BEYOND", "OnResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v("CUARTO A - BEYOND", "OnPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v("CUARTO A - BEYOND", "OnStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.v("CUARTO A - BEYOND", "OnRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v("CUARTO A - BEYOND", "OnDestroy");
    }
}
