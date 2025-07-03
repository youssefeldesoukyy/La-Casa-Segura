package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreen extends AppCompatActivity {
    Handler splash=new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        getWindow().setStatusBarColor(ContextCompat.getColor(SplashScreen.this,R.color.red));
        splash.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent sp=new Intent(SplashScreen.this, Login.class);
                startActivity(sp);
                finish();
            }
        },2000);
    }
}