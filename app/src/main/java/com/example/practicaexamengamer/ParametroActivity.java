package com.example.practicaexamengamer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ParametroActivity extends AppCompatActivity {

    private TextView textBateria;
    private ProgressBar ProgressBar2;
    private BroadcastReceiver mReceiver;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parametro);

        textBateria=(TextView) findViewById(R.id.textView);
        ProgressBar2=(ProgressBar) findViewById(R.id.progressBar2);

        mReceiver=new BatteryBroadcastReceiver();
        registerReceiver(mReceiver, new IntentFilter(
            Intent.ACTION_BATTERY_CHANGED));

    }

    private class BatteryBroadcastReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            int level=intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);
            textBateria.setText(level+""+getString(R.string.textBateria));
            ProgressBar2.setProgress(level);

        }
    }
    @Override
    protected void onStart() {
        super.onStart();

        registerReceiver(mReceiver,new IntentFilter(
                Intent.ACTION_BATTERY_CHANGED
        ));

        Log.v("CUARTO A - BEYOND", "OnStart");
    }

    @Override
    protected void onPause() {
        super.onPause();

        //if(isDestroyed()){

        //}

        Log.v("CUARTO A - BEYOND", "OnPause");
    }
}
