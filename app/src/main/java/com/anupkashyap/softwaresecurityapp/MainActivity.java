package com.anupkashyap.softwaresecurityapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button broadcastReceiverBtn, serviceActivityBtn, contentProviderBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        broadcastReceiverBtn= findViewById(R.id.broadcastBtn);
        serviceActivityBtn= findViewById(R.id.serviceBtn);
        contentProviderBtn=findViewById(R.id.contentProviderBtn);

        broadcastReceiverBtn.setOnClickListener(this);
        serviceActivityBtn.setOnClickListener(this);
        contentProviderBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent=null;
        switch (view.getId()) {
            case (R.id.broadcastBtn):
                intent = new Intent(view.getContext(), BroadcastReceiverActivity.class);
                view.getContext().startActivity(intent);
                break;
            case (R.id.serviceBtn):
                intent = new Intent(view.getContext(),ServiceActivity.class);
                view.getContext().startActivity(intent);
                break;
            case (R.id.contentProviderBtn):
                intent= new Intent(view.getContext(),ContentProviderActivity.class);
                view.getContext().startActivity(intent);
                break;
        }



    }
}