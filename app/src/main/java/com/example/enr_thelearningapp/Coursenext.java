package com.example.enr_thelearningapp;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Coursenext extends AppCompatActivity {
    RecyclerView verticalrecyclerView;
    verticalrecyclerviewadapter adapter;
    ArrayList<Verticalcoursemodel> arrayListvertical;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coursenext);

        //set title bar

        Toolbar toolbar=findViewById(R.id.toolbarcourse);
        setSupportActionBar(toolbar);

        String title=getIntent().getStringExtra("COURSE");
        getSupportActionBar().setTitle(title);

        //back arrow
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        arrayListvertical=new ArrayList<>();

        //recyclerview
        verticalrecyclerView=findViewById(R.id.Recyclerview);

        verticalrecyclerView.setHasFixedSize(true);

        verticalrecyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        //make vertical adapter

        adapter=new verticalrecyclerviewadapter(this,arrayListvertical);

        verticalrecyclerView.setAdapter(adapter);

        setData();
    }
    public void setData()
    {   //change it to change the image
       for(int i=1;i<=5;i++){
           Verticalcoursemodel verticalcoursemodel=new Verticalcoursemodel();
           verticalcoursemodel.setTitle("Title" +i);

           ArrayList<Horizontalcoursemodel> arrayList=new ArrayList<>();

           for (int j=0;j<=5; j++)
           {
               Horizontalcoursemodel horizontalcoursemodel=new Horizontalcoursemodel();
               horizontalcoursemodel.setDescription("Description" +j);
               horizontalcoursemodel.setName("Name" +j);


               arrayList.add(horizontalcoursemodel);
           }

           verticalcoursemodel.setArrayList(arrayList);
           arrayListvertical.add(verticalcoursemodel);
       }
       adapter.notifyDataSetChanged();
    }

    //back button

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==android.R.id.home)
        {
            Coursenext.this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}