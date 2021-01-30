package com.google.myapplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import java.util.Timer;
import java.util.TimerTask;

public class SScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_s_screen);



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                startActivity(new Intent(SScreen.this,MainActivity.class));
                overridePendingTransition(R.anim.fadein,R.anim.fadeout);
                finish();
            }
        },2000);

    }
}