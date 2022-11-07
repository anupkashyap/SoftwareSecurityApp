package com.anupkashyap.softwaresecurityapp;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import java.sql.Timestamp;

public class TimeService extends Service {

    public static final String
            ACTION_UPDATE_TIME = TimeService.class.getName() + "TimeBroadcast",
            EXTRA_TIME = "extra_time";
    boolean updateTime=false;
    public Context context = this;
    public Handler handler = null;
    public static Runnable runnable = null;
    @Nullable
    @Override

    public IBinder onBind(Intent intent) {
        return null;
    }
    @Override
    public int onStartCommand(Intent intent,int flags,int startId){
        Toast.makeText(getApplicationContext(), "Started service", Toast.LENGTH_SHORT).show();
        handler = new Handler();
        runnable = () -> {
            sendBroadcastMessage(new Timestamp(System.currentTimeMillis()).toString());
            handler.postDelayed(runnable, 5000);
        };
        handler.postDelayed(runnable, 1500);
        updateTime=true;
//
        return  START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(runnable);
    }

    private void sendBroadcastMessage(String time) {
        if (time != null) {
            Intent intent = new Intent();
            intent.setAction(ACTION_UPDATE_TIME);
            intent.putExtra(EXTRA_TIME, time);
            LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
        }
    }
}