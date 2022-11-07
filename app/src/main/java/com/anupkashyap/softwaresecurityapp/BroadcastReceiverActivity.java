package com.anupkashyap.softwaresecurityapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Timestamp;
import java.util.Date;

public class BroadcastReceiverActivity extends AppCompatActivity {

    Button invokeBtn;
    TextView timeTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast_receiver2);
        invokeBtn= findViewById(R.id.invokeReceiverBtn);
        timeTextView= findViewById(R.id.timeTextView);

        invokeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction("com.anupkashyap.CUSTOM_INTENT");
                sendBroadcast(intent);
            }
        });
        BroadcastReceiver broadcastReceiver= new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {

                timeTextView.setText(new Timestamp(System.currentTimeMillis()).toString());
                Toast.makeText(getApplicationContext(), "Received Action", Toast.LENGTH_SHORT).show();
            }
        };
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.anupkashyap.CUSTOM_INTENT");
        registerReceiver(broadcastReceiver,intentFilter);

    }



}