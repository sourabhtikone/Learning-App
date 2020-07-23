package com.example.enr_thelearningapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class search extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        BottomNavigationView bottomNavigationView=(BottomNavigationView)findViewById(R.id.navbar);
        bottomNavigationView.setSelectedItemId(R.id.nav_search);
        bottomNavigationView.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case  R.id.nav_home:
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        finish();
                        overridePendingTransition(0,0);
                        return;

                    case R.id.nav_search:


                    case R.id.nav_mycourse:
                        startActivity(new Intent(getApplicationContext(),mycourse.class));
                        finish();
                        overridePendingTransition(0,0);
                        return;

                    case R.id.nav_quiz:
                        startActivity(new Intent(getApplicationContext(), quizactivity.class));
                        finish();
                        overridePendingTransition(0,0);
                        return;
                    case R.id.nav_account:
                        startActivity(new Intent(getApplicationContext(), Myaccount.class));
                        finish();
                        overridePendingTransition(0,0);
                        return;
                }
            }
        });
    }
}