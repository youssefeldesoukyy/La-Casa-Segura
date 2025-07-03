package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Add_Sensors extends AppCompatActivity {

    Button addM, removeM, addG, removeG, addF, removeF,addSens;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_sensors);
        getWindow().setStatusBarColor(ContextCompat.getColor(Add_Sensors.this,R.color.red));

        addM = findViewById(R.id.addM);
        addF = findViewById(R.id.addF);
        addG = findViewById(R.id.addG);
        removeF = findViewById(R.id.removeF);
        removeG = findViewById(R.id.removeG);
        removeM = findViewById(R.id.removeM);
        addSens=findViewById(R.id.addSens);
        addM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickAddM(v);
            }
        });
        addF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickAddF(v);
            }
        });
        addG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickAddG(v);
            }
        });
        removeG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickSubtractG(v);
            }
        });
        removeF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickSubtractF(v);
            }
        });
        removeM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickSubtractM(v);
            }
        });
        addSens.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView fire = (TextView) findViewById(R.id.firenum);
                TextView motion = (TextView) findViewById(R.id.motionNum);
                TextView gas = (TextView) findViewById(R.id.gasnum);
                Toast.makeText(Add_Sensors.this, "Sensors add successfully", Toast.LENGTH_SHORT).show();
                fire.setText("0");
                motion.setText("0");
                gas.setText("0");
            }
        });
    }

    public void onClickSubtractF(View view) {
        // Find the TextView element in the layout
        TextView textView = (TextView) findViewById(R.id.firenum);

        // Get the current value of the TextView as an integer
        int value = Integer.parseInt(textView.getText().toString());

        // Decrement the value by 1
        if (value != 0) {
            value -= 1;
        }


        // Set the new value of the TextView
        textView.setText(Integer.toString(value));
    }

    public void onClickSubtractM(View view) {
        // Find the TextView element in the layout
        TextView textView = (TextView) findViewById(R.id.motionNum);

        // Get the current value of the TextView as an integer
        int value = Integer.parseInt(textView.getText().toString());

        // Decrement the value by 1
        if (value != 0) {
            value -= 1;
        }

        // Set the new value of the TextView
        textView.setText(Integer.toString(value));
    }

    public void onClickSubtractG(View view) {
        // Find the TextView element in the layout
        TextView textView = (TextView) findViewById(R.id.gasnum);

        // Get the current value of the TextView as an integer
        int value = Integer.parseInt(textView.getText().toString());

        // Decrement the value by 1
        if (value != 0) {
            value -= 1;
        }


        // Set the new value of the TextView
        textView.setText(Integer.toString(value));
    }


    public void onClickAddM(View view) {
        // Find the TextView element in the layout
        TextView textView = (TextView) findViewById(R.id.motionNum);

        // Get the current value of the TextView as an integer
        int value = Integer.parseInt(textView.getText().toString());

        // Increment the value by 1
        value += 1;

        // Set the new value of the TextView
        textView.setText(Integer.toString(value));
    }

    public void onClickAddF(View view) {
        // Find the TextView element in the layout
        TextView textView = (TextView) findViewById(R.id.firenum);

        // Get the current value of the TextView as an integer
        int value = Integer.parseInt(textView.getText().toString());

        // Increment the value by 1
        value += 1;

        // Set the new value of the TextView
        textView.setText(Integer.toString(value));
    }

    public void onClickAddG(View view) {
        // Find the TextView element in the layout
        TextView textView = (TextView) findViewById(R.id.gasnum);

        // Get the current value of the TextView as an integer
        int value = Integer.parseInt(textView.getText().toString());

        // Increment the value by 1
        value += 1;

        // Set the new value of the TextView
        textView.setText(Integer.toString(value));
    }
}


