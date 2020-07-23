package com.example.enr_thelearningapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Kids_poem extends AppCompatActivity {
    RecyclerView MrecyclerView;
    FirebaseDatabase database;
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kids_poem);

        MrecyclerView=findViewById(R.id.Recyclerviewpoem_video);
        MrecyclerView.setHasFixedSize(true);
        MrecyclerView.setLayoutManager(new LinearLayoutManager(this));
        database=FirebaseDatabase.getInstance();
        reference=database.getReference("video");


    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseRecyclerOptions<poemmember> options=
                new FirebaseRecyclerOptions.Builder<poemmember>().setQuery(reference,poemmember.class)
                .build();

        FirebaseRecyclerAdapter<poemmember,poemViewHolder> firebaseRecyclerAdapter=
                new FirebaseRecyclerAdapter<poemmember, poemViewHolder>(options) {
                    @Override
                    protected void onBindViewHolder(@NonNull poemViewHolder holder, int position, @NonNull poemmember model) {

                        holder.setVideo(getApplication(),model.getTitle(),model.getUrl());

                    }

                    @NonNull
                    @Override
                    public poemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.poemrow,parent,false);

                        return new poemViewHolder(view);
                    }
                };
        firebaseRecyclerAdapter.startListening();
        MrecyclerView.setAdapter(firebaseRecyclerAdapter);


    }
}