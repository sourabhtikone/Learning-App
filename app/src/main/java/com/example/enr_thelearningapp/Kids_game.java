package com.example.enr_thelearningapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Kids_game extends AppCompatActivity {
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kids_game);

        btn=findViewById(R.id.math_st);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Kids_game.this,MathsQuiz.class);
                startActivity(intent);
            }
        });

        //bottomnavigationview
        BottomNavigationView bottomNavigationView=(BottomNavigationView)findViewById(R.id.kidsnavbar);
        bottomNavigationView.setSelectedItemId(R.id.action_games);

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
                        startActivity(new Intent(getApplicationContext(),Kids_learn.class));
                        finish();
                        overridePendingTransition(0,0);
                        return;

                    case R.id.action_games:

                }
            }
        });
    }
}