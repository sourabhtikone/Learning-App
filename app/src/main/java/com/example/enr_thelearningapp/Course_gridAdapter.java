package com.example.enr_thelearningapp;

import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.Random;

public class Course_gridAdapter extends BaseAdapter {
    private List<String> courseList;

    public Course_gridAdapter(List<String> courseList) {
        this.courseList = courseList;
    }

    @Override
    public int getCount() {
        return courseList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {

         View view;
         if (convertView==null)
         {
             view= LayoutInflater.from(parent.getContext()).inflate(R.layout.course_grid_layout,parent,false);
         }
         else
         {
             view=convertView;
         }

         view.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent=new Intent(parent.getContext(),Coursenext.class);
                 intent.putExtra("COURSE",courseList.get(position));
                 parent.getContext().startActivity(intent);
             }
         });
         //get the text of course
        ((TextView)view.findViewById(R.id.coursename)).setText(courseList.get(position));

         //background color
        Random rnd=new Random();
        int color= Color.argb(255,rnd.nextInt(255),rnd.nextInt(255),rnd.nextInt(255));
        view.setBackgroundColor(color);

        return view;
    }
}
