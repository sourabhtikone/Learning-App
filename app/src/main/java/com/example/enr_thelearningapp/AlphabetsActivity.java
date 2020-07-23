package com.example.enr_thelearningapp;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import java.util.ArrayList;
import java.util.List;

public class AlphabetsActivity extends AppCompatActivity {
    private List<AlphabetItem> alphabetList;
    private RecyclerView alphabetRecycler;
    private AlphabetAdapter adapter;
    private CenterZoomLayoutManager centerZoomLayoutManager;
    private Button previous,play,next;
    private int counter=0;
    private int[] sounds;

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphabets);

        sounds = new int[]{R.raw.a, R.raw.b, R.raw.c, R.raw.d, R.raw.e, R.raw.f, R.raw.g, R.raw.h, R.raw.i, R.raw.j,
                R.raw.k, R.raw.l, R.raw.m, R.raw.n, R.raw.o, R.raw.p, R.raw.q, R.raw.r, R.raw.s, R.raw.t, R.raw.u, R.raw.v,
                R.raw.w, R.raw.x, R.raw.y, R.raw.z};

        alphabetList = new ArrayList<>();
        initList();

        adapter = new AlphabetAdapter(this, alphabetList);
        centerZoomLayoutManager = new CenterZoomLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        alphabetRecycler = findViewById(R.id.recycler_alphabets);
        previous = findViewById(R.id.previous_alphabets);
        play = findViewById(R.id.play_alphabets);
        next = findViewById(R.id.next_alphabets);


        alphabetRecycler.setLayoutManager(centerZoomLayoutManager);
        alphabetRecycler.setItemAnimator(new DefaultItemAnimator());
        alphabetRecycler.setAdapter(adapter);

        /*counter = Integer.MAX_VALUE / 2;*/

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter = centerZoomLayoutManager.findLastCompletelyVisibleItemPosition();
                counter--;
                alphabetRecycler.smoothScrollToPosition(counter);
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter = centerZoomLayoutManager.findLastCompletelyVisibleItemPosition();
                counter++;
                alphabetRecycler.smoothScrollToPosition(counter);
            }
        });

        alphabetRecycler.scrollToPosition(counter);
        SnapHelper snapHelper = new LinearSnapHelper();
        snapHelper.attachToRecyclerView(alphabetRecycler);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter = centerZoomLayoutManager.findLastCompletelyVisibleItemPosition();
                int pos = counter % alphabetList.size();
                if (mediaPlayer != null) {
                    mediaPlayer.release();
                }
                mediaPlayer = MediaPlayer.create(getApplicationContext(), sounds[pos]);
                mediaPlayer.start();
            }
        });
    }

    private void initList(){
        alphabetList.add(new AlphabetItem("A a"));
        alphabetList.add(new AlphabetItem("B b"));
        alphabetList.add(new AlphabetItem("C c"));
        alphabetList.add(new AlphabetItem("D d"));
        alphabetList.add(new AlphabetItem("E e"));
        alphabetList.add(new AlphabetItem("F f"));
        alphabetList.add(new AlphabetItem("G g"));
        alphabetList.add(new AlphabetItem("H h"));
        alphabetList.add(new AlphabetItem("I i"));
        alphabetList.add(new AlphabetItem("J j"));
        alphabetList.add(new AlphabetItem("K k"));
        alphabetList.add(new AlphabetItem("L l"));
        alphabetList.add(new AlphabetItem("M m"));
        alphabetList.add(new AlphabetItem("N n"));
        alphabetList.add(new AlphabetItem("O o"));
        alphabetList.add(new AlphabetItem("P p"));
        alphabetList.add(new AlphabetItem("Q q"));
        alphabetList.add(new AlphabetItem("R r"));
        alphabetList.add(new AlphabetItem("S s"));
        alphabetList.add(new AlphabetItem("T t"));
        alphabetList.add(new AlphabetItem("U u"));
        alphabetList.add(new AlphabetItem("V v"));
        alphabetList.add(new AlphabetItem("W w"));
        alphabetList.add(new AlphabetItem("X x"));
        alphabetList.add(new AlphabetItem("Y y"));
        alphabetList.add(new AlphabetItem("Z z"));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}