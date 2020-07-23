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

public class QuizCatGridAdapter extends BaseAdapter {
    private List<String> catList;

    public QuizCatGridAdapter(List<String> catList) {
        this.catList = catList;
    }

    @Override
    public int getCount() {
        return catList.size();
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
        if (convertView== null){
            view= LayoutInflater.from(parent.getContext()).inflate(R.layout.quiz_cat_layout,parent,false);
        }
        else
        {
            view=convertView;
        }

        //goto sets activity
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(parent.getContext(),QuizSets.class);
                intent.putExtra("CATEGORY",catList.get(position));
                intent.putExtra("CATEGORY_ID",position +1);
                parent.getContext().startActivity(intent);
            }
        });


        ((TextView) view.findViewById(R.id.catName)).setText(catList.get(position));

        Random rnd=new Random();

        int color= Color.argb(255,rnd.nextInt(255),rnd.nextInt(255),rnd.nextInt(255));
        view.setBackgroundColor(color);

        return view;

    }
}
