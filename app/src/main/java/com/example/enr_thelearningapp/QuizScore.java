package com.example.enr_thelearningapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class QuizScore extends AppCompatActivity {
    private TextView sco;
    private Button done;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_score);

        sco=findViewById(R.id.sa_score);
        done=findViewById(R.id.sa_done);

        String sco_str=getIntent().getStringExtra("SCORE");
        sco.setText(sco_str);
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(QuizScore.this,QuizScore.class);
                QuizScore.this.startActivity(intent);
                QuizScore.this.finish();

            }
        });


    }

}