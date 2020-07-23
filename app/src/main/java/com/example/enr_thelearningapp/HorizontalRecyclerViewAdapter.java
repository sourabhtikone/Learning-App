package com.example.enr_thelearningapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HorizontalRecyclerViewAdapter extends RecyclerView.Adapter<HorizontalRecyclerViewAdapter.HorizontalRVviewHolder> {

    Context context;
    ArrayList<Horizontalcoursemodel>arrayList;

    public HorizontalRecyclerViewAdapter(Context context, ArrayList<Horizontalcoursemodel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }


    @NonNull
    @Override
    public HorizontalRVviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_horizontal,parent,false);
        return  new HorizontalRVviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HorizontalRVviewHolder holder, int position) {
        final Horizontalcoursemodel horizontalcoursemodel=arrayList.get(position);
        holder.textViewtitle.setText(horizontalcoursemodel.getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,horizontalcoursemodel.getName(),Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class HorizontalRVviewHolder extends  RecyclerView.ViewHolder
    {
        TextView textViewtitle;
        ImageView imageViewThumb;

        public HorizontalRVviewHolder(@NonNull View itemView) {
            super(itemView);
            textViewtitle=(TextView)itemView.findViewById(R.id.txtTitle2);
            imageViewThumb=(ImageView)itemView.findViewById(R.id.ivThumbhorizontal);
        }
    }

}
