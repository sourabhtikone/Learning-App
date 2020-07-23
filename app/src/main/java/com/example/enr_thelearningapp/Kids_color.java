package com.example.enr_thelearningapp;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Kids_color extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kids_color);

        Button Click1=findViewById(R.id.button1);
        Button Click2=findViewById(R.id.button2);
        Button Click3=findViewById(R.id.button3);
        Button Click4=findViewById(R.id.button4);
        Button Click5=findViewById(R.id.button5);
        Button Click6=findViewById(R.id.button6);
        Button Click7=findViewById(R.id.button7);
        Button Click8=findViewById(R.id.button8);


        //
        final MediaPlayer mp1=MediaPlayer.create(getApplicationContext(),R.raw.red);
        final MediaPlayer mp2=MediaPlayer.create(getApplicationContext(),R.raw.orange);
        final MediaPlayer mp3=MediaPlayer.create(getApplicationContext(),R.raw.yellow);
        final MediaPlayer mp4=MediaPlayer.create(getApplicationContext(),R.raw.green);
        final MediaPlayer mp5=MediaPlayer.create(getApplicationContext(),R.raw.blue);
        final MediaPlayer mp6=MediaPlayer.create(getApplicationContext(),R.raw.purple);
        final MediaPlayer mp7=MediaPlayer.create(getApplicationContext(),R.raw.pink);
        final MediaPlayer mp8=MediaPlayer.create(getApplicationContext(),R.raw.violet);

        View.OnClickListener elem=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.button1:
                        mp1.start();
                        break;

                    case R.id.button2:
                        mp2.start();
                        break;

                    case R.id.button3:
                        mp3.start();
                        break;

                    case R.id.button4:
                        mp4.start();
                        break;

                    case R.id.button5:
                        mp5.start();
                        break;

                    case R.id.button6:
                        mp6.start();
                        break;

                    case R.id.button7:
                        mp7.start();
                        break;

                    case R.id.button8:
                        mp8.start();
                        break;
                }
            }
        };
        Click1.setOnClickListener(elem);
        Click2.setOnClickListener(elem);
        Click3.setOnClickListener(elem);
        Click4.setOnClickListener(elem);
        Click5.setOnClickListener(elem);
        Click6.setOnClickListener(elem);
        Click7.setOnClickListener(elem);
        Click8.setOnClickListener(elem);

    }
}