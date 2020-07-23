package com.example.enr_thelearningapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class verticalrecyclerviewadapter extends RecyclerView.Adapter<verticalrecyclerviewadapter.verticalRVviewholder> {
    Context context;
    ArrayList<Verticalcoursemodel> arrayList;

    public verticalrecyclerviewadapter(Context context, ArrayList<Verticalcoursemodel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public verticalRVviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_vertical,parent,false);
        return new verticalRVviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull verticalRVviewholder holder, int position) {
        final Verticalcoursemodel verticalcoursemodel=arrayList.get(position);
        String title=verticalcoursemodel.getTitle();
        ArrayList<Horizontalcoursemodel> singleItem=verticalcoursemodel.getArrayList();

        holder.textviewTitle.setText(title);

        HorizontalRecyclerViewAdapter horizontalRecyclerViewAdapter=new  HorizontalRecyclerViewAdapter(context,singleItem);

        holder.recyclerView.setHasFixedSize(true);
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));

        holder.recyclerView.setAdapter(horizontalRecyclerViewAdapter);

        holder.btnMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,verticalcoursemodel.getTitle(),Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class verticalRVviewholder extends RecyclerView.ViewHolder{
        RecyclerView recyclerView;
        TextView textviewTitle;
        Button btnMore;


        public verticalRVviewholder(@NonNull View itemView) {
            super(itemView);
            recyclerView=(RecyclerView)itemView.findViewById(R.id.Recyclerview1);
            textviewTitle=(TextView)itemView.findViewById(R.id.texttitle1);
            btnMore=(Button)itemView.findViewById(R.id.btnmore);

        }
    }
}
