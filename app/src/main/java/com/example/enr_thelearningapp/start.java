package com.example.enr_thelearningapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class start extends AppCompatActivity {
   private Button kid;
   private Button professional;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        //kid button
        kid=findViewById(R.id.kid);

        kid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(start.this,Kids_Main.class);
                startActivity(intent);
            }
        });

        //professional button
        professional=findViewById(R.id.professional);
        professional.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(start.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}