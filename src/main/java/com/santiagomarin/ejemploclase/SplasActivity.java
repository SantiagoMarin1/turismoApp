package com.santiagomarin.ejemploclase;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

import java.util.Timer;
import java.util.TimerTask;

public class SplasActivity extends AppCompatActivity {

    private static final long SPLASH_DELAY=3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splas);

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Intent i = new Intent().setClass(SplasActivity.this,LoginActivity.class);
                startActivity(i);
                finish();
            }
            };

        Timer timer =new Timer();
        timer.schedule(task, SPLASH_DELAY);
    }
}
