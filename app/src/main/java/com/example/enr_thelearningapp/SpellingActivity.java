package com.example.enr_thelearningapp;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import java.util.ArrayList;
import java.util.List;

public class SpellingActivity extends AppCompatActivity {
    private RecyclerView spellingsRecycler;
    private List<AlphabetItem> alphabetItemList;
    private SpellingAdapter adapter;

    private CenterZoomLayoutManager centerZoomLayoutManager;


    private Button previous, play, next;
    private int counter = 0;


    private MediaPlayer mediaPlayer;
    private int[] sounds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Setting up the activity for full screen mode
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_spelling);


        sounds = new int[]{R.raw.all, R.raw.bat, R.raw.cat, R.raw.dad, R.raw.dog, R.raw.hen, R.raw.hello,
                R.raw.mom, R.raw.one, R.raw.papa, R.raw.pet, R.raw.rat, R.raw.sun, R.raw.toy, R.raw.yes};
        alphabetItemList = new ArrayList<>();
        initList();
        adapter = new SpellingAdapter(this, alphabetItemList);

        spellingsRecycler = (RecyclerView) findViewById(R.id.recycler_spelling);
        centerZoomLayoutManager = new CenterZoomLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        spellingsRecycler.setLayoutManager(centerZoomLayoutManager);
        spellingsRecycler.setItemAnimator(new DefaultItemAnimator());
        spellingsRecycler.setAdapter(adapter);

        previous = (Button) findViewById(R.id.previous_spelling);
        play = (Button) findViewById(R.id.play_spelling);
        next = (Button) findViewById(R.id.next_spelling);

        counter = Integer.MAX_VALUE / 2;

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter = centerZoomLayoutManager.findLastCompletelyVisibleItemPosition();
                counter--;
                spellingsRecycler.smoothScrollToPosition(counter);
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter = centerZoomLayoutManager.findLastCompletelyVisibleItemPosition();
                counter++;
                spellingsRecycler.smoothScrollToPosition(counter);
            }
        });
        spellingsRecycler.scrollToPosition(counter);
        SnapHelper snapHelper = new LinearSnapHelper();
        snapHelper.attachToRecyclerView(spellingsRecycler);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter = centerZoomLayoutManager.findLastCompletelyVisibleItemPosition();
                int pos = counter % alphabetItemList.size();
                if (mediaPlayer != null) {
                    mediaPlayer.release();
                }
                mediaPlayer = MediaPlayer.create(getApplicationContext(), sounds[pos]);
                mediaPlayer.start();

                adapter.notifyDataSetChanged();
            }
        });
    }

    private void initList() {
        alphabetItemList.add(new AlphabetItem("All"));
        alphabetItemList.add(new AlphabetItem("Bat"));
        alphabetItemList.add(new AlphabetItem("Cat"));
        alphabetItemList.add(new AlphabetItem("Dad"));
        alphabetItemList.add(new AlphabetItem("Dog"));
        alphabetItemList.add(new AlphabetItem("Hen"));
        alphabetItemList.add(new AlphabetItem("Hello"));
        alphabetItemList.add(new AlphabetItem("Mom"));
        alphabetItemList.add(new AlphabetItem("One"));
        alphabetItemList.add(new AlphabetItem("Papa"));
        alphabetItemList.add(new AlphabetItem("Pet"));
        alphabetItemList.add(new AlphabetItem("Rat"));
        alphabetItemList.add(new AlphabetItem("Sun"));
        alphabetItemList.add(new AlphabetItem("Toy"));
        alphabetItemList.add(new AlphabetItem("Yes"));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();


    }
}