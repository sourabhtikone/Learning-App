package com.example.enr_thelearningapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    SliderView sliderView;
    List<ImageSliderModel>imageSliderModelList;
    public static List<String> catList=new ArrayList<>();
    private FirebaseFirestore firestore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageSliderModelList=new ArrayList<>();
        sliderView=(SliderView)findViewById(R.id.imageSlider);
        imageSliderModelList.add(new ImageSliderModel(R.drawable.abc));
        imageSliderModelList.add(new ImageSliderModel(R.drawable.prr));
        imageSliderModelList.add(new ImageSliderModel(R.drawable.xyz));
        sliderView.setSliderAdapter(new ImageSliderAdapter(MainActivity.this,imageSliderModelList));

        //firebase
        firestore=FirebaseFirestore.getInstance();

        loadData();

        BottomNavigationView bottomNavigationView=(BottomNavigationView)findViewById(R.id.navbar);
        bottomNavigationView.setSelectedItemId(R.id.nav_home);
        bottomNavigationView.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case  R.id.nav_home:

                    case R.id.nav_search:
                        startActivity(new Intent(getApplicationContext(),search.class));
                        finish();
                        overridePendingTransition(0,0);
                        return;



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
    private void loadData()
    {
        catList.clear();
        firestore.collection("QUIZ").document("Categories").get()
        .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {

                if (task.isSuccessful()){
                    DocumentSnapshot doc=task.getResult();

                    if (doc.exists())
                    {
                       long count=(long)doc.get("COUNT");

                       for (int i=1; i<=count;i++)
                       {
                           String catName=doc.getString("CAT" +String.valueOf(i));
                           catList.add(catName);
                       }

                    }
                    else
                    {
                        Toast.makeText(MainActivity.this,"No category document exist",Toast.LENGTH_LONG).show();
                        finish();
                    }

                }
                else
                {
                    Toast.makeText(MainActivity.this,task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}