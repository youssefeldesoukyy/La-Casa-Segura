package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {

    EditText email,pass,fname,lname,phone,repass;
    Button signup;
    DBHelper db=new DBHelper(this);
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        getWindow().setStatusBarColor(ContextCompat.getColor(SignUp.this, R.color.red));
        email=findViewById(R.id.reg_email);
        pass=(EditText) findViewById(R.id.reg_pass);
        fname=(EditText)findViewById(R.id.first_name);
        lname=(EditText)findViewById(R.id.last_name);
        phone=(EditText)findViewById(R.id.phone);
        repass=(EditText)findViewById(R.id.reg_confirm);
        signup = (Button)findViewById(R.id.bt_signup);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String em=email.getText().toString();
                String pw=pass.getText().toString();
                String fn=fname.getText().toString();
                String ln=lname.getText().toString();
                String ph=phone.getText().toString();
                String rpw=repass.getText().toString();
                if(em.equals("")||pw.equals("")||rpw.equals("")||ph.equals("")||fn.equals("")||ln.equals("")){
                    Toast.makeText(SignUp.this,"Please fill out all missing fields",Toast.LENGTH_SHORT).show();
                }
                else{
                    if(pw.equals(rpw)){
                        if(!db.checkUser(em)){
                            if(db.insertData(em,pw,fn,ln,ph)){
                                Toast.makeText(SignUp.this,"Registered Successfully",Toast.LENGTH_SHORT).show();
                                Intent i =new Intent(SignUp.this,Home.class);
                                startActivity(i);
                            }
                            else{
                                Toast.makeText(SignUp.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(SignUp.this, "User already exists", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(SignUp.this, "Passwords don't match"+"\np1=  "+pw+" p2= "+rpw, Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }
}