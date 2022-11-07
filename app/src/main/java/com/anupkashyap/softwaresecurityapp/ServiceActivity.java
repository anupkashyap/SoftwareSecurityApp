package com.anupkashyap.softwaresecurityapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Timestamp;

public class ServiceActivity extends AppCompatActivity {

    public static TextView timeText;
    Button startbtn,stopBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        timeText=findViewById(R.id.serviceTime);

        startbtn= findViewById(R.id.serviceStartbtn);
        stopBtn=findViewById(R.id.stopServiceBtn);

        LocalBroadcastManager.getInstance(this).registerReceiver(
                new BroadcastReceiver() {
                    @Override
                    public void onReceive(Context context, Intent intent) {
                        String  time = intent.getStringExtra(TimeService.EXTRA_TIME);
                        timeText.setText("Time: " + time );
                    }
                }, new IntentFilter(TimeService.ACTION_UPDATE_TIME)
        );

        startbtn.setOnClickListener(view -> startService(new Intent(this,TimeService.class)));
        stopBtn.setOnClickListener(view ->{

            stopService(new Intent(this,TimeService.class));
            Toast.makeText(this, "Stopping service", Toast.LENGTH_SHORT).show();
        });



    }

}