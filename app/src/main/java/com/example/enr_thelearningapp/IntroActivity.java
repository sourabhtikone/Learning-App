package com.example.enr_thelearningapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class IntroActivity extends AppCompatActivity {
    private ViewPager screenPager;
    IntroViewPagerAdapter introViewPagerAdapter;
    TabLayout tabIndicator;
    Button btnNext;
    int position=0;
    Button btnGetStarted;
    Animation btnAnim;
    TextView tvSkip;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //make the activity on full screen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //when this activity is about to be launch we need to check if its opened before or not
        if (restorePrefData()) {
            Intent intent=new Intent(IntroActivity.this,login.class);
            startActivity(intent);
            IntroActivity.this.finish();
        }

        setContentView(R.layout.activity_intro);
        //hide the action bar


        //ini views
        btnNext=(Button)findViewById(R.id.btn_next);
        btnGetStarted=(Button)findViewById(R.id.btn_get_Started);
        tabIndicator=findViewById(R.id.tab_indicator);
        btnAnim= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.button_animation);
        tvSkip=findViewById(R.id.tv_skip);

        //fill list screen

        final List<ScreenItem> mList =new ArrayList<>();
        mList.add(new  ScreenItem("Your Study Partner","",R.drawable.logo));
        mList.add(new ScreenItem("    With Best Teachers From     World!!","",R.drawable.teacher));
        mList.add(new ScreenItem(" Cover  All Courses ","",R.drawable.box));

        //setup viewpager
        screenPager=findViewById(R.id.screen_viewpager);
        introViewPagerAdapter=new IntroViewPagerAdapter(this,mList);
        screenPager.setAdapter(introViewPagerAdapter);

        //setup tablayout with viewpager
        tabIndicator.setupWithViewPager(screenPager);
        //next button click

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position=screenPager.getCurrentItem();
                if (position < mList.size()){

                    position++;
                    screenPager.setCurrentItem(position);
                }
                if (position == mList.size()-1){
                    //when we reach to last screen show the getstarted button amd hide the indicator and the next button
                    loaddLastScreen();
                }
            }
        });

        //tablayout add change listener
        tabIndicator.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition()==mList.size()-1){
                    loaddLastScreen();
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        //get started button click listener
        btnGetStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),login.class);
                startActivity(intent);
                savePrefData();
                IntroActivity.this.finish();;
            }
        });
        //skip button click

        tvSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screenPager.setCurrentItem(mList.size());
            }
        });
    }
    private boolean restorePrefData(){
        SharedPreferences pref=getApplicationContext().getSharedPreferences("mPrefs",MODE_PRIVATE);
        Boolean isIntroActivityOpenedBefore=pref.getBoolean("isIntroOpened",false);
        return isIntroActivityOpenedBefore;
    }

    private void savePrefData(){

        SharedPreferences pref=getApplicationContext().getSharedPreferences("myPrefs",MODE_PRIVATE);
        SharedPreferences.Editor editor=pref.edit();
        editor.putBoolean("isIntroOpened",true);
        editor.apply();
    }


    //show getstarted button and hide the indicator and the next button
    private void loaddLastScreen(){
        btnNext.setVisibility(View.INVISIBLE);
        btnGetStarted.setVisibility(View.VISIBLE);
        tvSkip.setVisibility(View.INVISIBLE);
        tabIndicator.setVisibility(View.INVISIBLE);
        //add animation the gesture button
        //setup animation
        btnGetStarted.setAnimation(btnAnim);
    }
}