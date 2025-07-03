package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    Button sign, log;
    EditText email, pass;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getWindow().setStatusBarColor(ContextCompat.getColor(Login.this, R.color.red));
        email = findViewById(R.id.et_email);
        pass = findViewById(R.id.et_password);
        sign = findViewById(R.id.tv_signup);
        db = new DBHelper(this);
        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Login.this, SignUp.class);
                startActivity(i);
            }
        });
        log = findViewById(R.id.bt_signup);
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String em = email.getText().toString();
                String pw = pass.getText().toString();
                if (em.equals("") || pw.equals("")) {
                    Toast.makeText(Login.this, "Please enter email and password", Toast.LENGTH_SHORT).show();
                } else {
                    if (db.checkEmailPassword(em, pw)) {
                        Toast.makeText(Login.this, "Login Successful", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(Login.this, Home.class);
                        startActivity(i);
                    }
                    else{
                        Toast.makeText(Login.this, "Wrong email or password", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


    }
}