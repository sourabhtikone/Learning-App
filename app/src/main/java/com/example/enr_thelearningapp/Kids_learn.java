package com.example.enr_thelearningapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Kids_learn extends AppCompatActivity {
     Button btn1,btn2,btn3,btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kids_learn);

        btn1=findViewById(R.id.color1);
        btn2=findViewById(R.id.poem);
        btn3=findViewById(R.id.alphabets);
        btn4=findViewById(R.id.spelling);



        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Kids_learn.this,Kids_color.class);
                startActivity(intent);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Kids_learn.this,Kids_poem.class);
                startActivity(intent);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Kids_learn.this,AlphabetsActivity.class);
                startActivity(intent);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Kids_learn.this,SpellingActivity.class);
                startActivity(intent);

            }
        });


        //bottomnavigationview
        BottomNavigationView bottomNavigationView=(BottomNavigationView)findViewById(R.id.kidsnavbar);
        bottomNavigationView.setSelectedItemId(R.id.action_learn);

        bottomNavigationView.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {
                switch (item.getItemId()){

                    case  R.id.action_features:
                        startActivity(new Intent(getApplicationContext(),Kids_Main.class));
                        finish();
                        overridePendingTransition(0,0);
                        return;

                    case R.id.action_learn:

                    case R.id.action_games:
                        startActivity(new Intent(getApplicationContext(),Kids_game.class));
                        finish();
                        overridePendingTransition(0,0);
                        return;
                }
            }
        });
    }
}