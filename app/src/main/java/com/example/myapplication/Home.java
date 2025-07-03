package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home extends AppCompatActivity {
    Button fire,motion,gas,contactus,add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        fire=findViewById(R.id.Fire);
        getWindow().setStatusBarColor(ContextCompat.getColor(Home.this,R.color.gray));
        motion=findViewById(R.id.Motion);
        gas=findViewById(R.id.Gas);
        contactus=findViewById(R.id.contactus);
        add=findViewById(R.id.add);
        motion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(Home.this,Motion.class);
                startActivity(i1);
            }
        });
        fire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(Home.this,Fire.class);
                startActivity(i1);
            }
        });
        gas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(Home.this,Gas.class);
                startActivity(i1);
            }
        });
        contactus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(Home.this,Contactus.class);
                startActivity(i1);
            }
    });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(Home.this,Add_Sensors.class);
                startActivity(i1);
            }
        });
    }}