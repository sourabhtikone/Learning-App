package com.example.enr_thelearningapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class mycourse extends AppCompatActivity {
    private GridView coursegrid;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mycourse);

        //gridview
        coursegrid=findViewById(R.id.courseGridview);

        List<String>courseList=new ArrayList<>();

        courseList.add("Programming");
        courseList.add("IT&Software");
        courseList.add("Business");
        courseList.add("Photography");

        Course_gridAdapter adapter=new Course_gridAdapter(courseList);
        coursegrid.setAdapter(adapter);






         

        BottomNavigationView bottomNavigationView=(BottomNavigationView)findViewById(R.id.navbar);
        bottomNavigationView.setSelectedItemId(R.id.nav_mycourse);
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
                        startActivity(new Intent(getApplicationContext(),search.class));
                        finish();
                        overridePendingTransition(0,0);
                        return;

                    case R.id.nav_mycourse:


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