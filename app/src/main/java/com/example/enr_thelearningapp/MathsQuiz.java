package com.example.enr_thelearningapp;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MathsQuiz extends AppCompatActivity {
    Button btn_start,btn_answer0,btn_answer1,btn_answer2,btn_answer3;
    TextView tv_score,tv_question,tv_bottommessage,tv_timer;
    ProgressBar prog_timer;

    Game g=new Game();
    int secondsRemaining=30;

    CountDownTimer timer=new CountDownTimer(30000,1000) {
        @Override
        public void onTick(long millisUntilFinished) {
           secondsRemaining--;
           tv_timer.setText(Integer.toString(secondsRemaining) + " Sec ");
           prog_timer.setProgress(30 - secondsRemaining);
        }

        @Override
        public void onFinish() {
            btn_answer0.setEnabled(false);
            btn_answer1.setEnabled(false);
            btn_answer2.setEnabled(false);
            btn_answer3.setEnabled(false);
            tv_bottommessage.setText(" TIME is Up !! " +"   " +g.getNumberCorrect() + " / " + (g.getTotalQuestion() -1 ));

            //handling the go button
            final Handler handler=new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    btn_start.setVisibility(View.VISIBLE);
                }
            },4000);


        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maths_quiz);

        btn_start=findViewById(R.id.btn_start);
        btn_answer0=findViewById(R.id.btn_answer0);
        btn_answer1=findViewById(R.id.btn_answer1);
        btn_answer2=findViewById(R.id.btn_answer2);
        btn_answer3=findViewById(R.id.btn_answer3);

        tv_score=findViewById(R.id.tv_score);
        tv_bottommessage=findViewById(R.id.tv_bottommessage);
        tv_question=findViewById(R.id.tv_question);
        tv_timer=findViewById(R.id.tv_timer);

        //progress bar

        prog_timer=findViewById(R.id.prog_timer);

        //initial text set
        tv_timer.setText("0sec");
        tv_question.setText("");
        tv_bottommessage.setText(" press Go");
        tv_score.setText("0pts");

        View.OnClickListener startButtonClickListener=new  View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Button start_button=(Button) v;

                start_button.setVisibility(View.INVISIBLE);
                secondsRemaining=30;
                g=new Game();
                nextTurn();
                timer.start();

            }
        };

        View.OnClickListener answerButtonClickListener=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button buttonClicked=(Button) v;

                int answerSelected= Integer.parseInt(buttonClicked.getText().toString());
                //Toast.makeText(MathsQuiz.this,"AnswerSelected="+ answerSelected,Toast.LENGTH_SHORT).show();
                g.checkAnswer(answerSelected);
                tv_score.setText(Integer.toString(g.getScore())+"  Pts");
                nextTurn();
            }
        };


        btn_start.setOnClickListener(startButtonClickListener);
        btn_answer0.setOnClickListener(answerButtonClickListener);
        btn_answer1.setOnClickListener(answerButtonClickListener);
        btn_answer2.setOnClickListener(answerButtonClickListener);
        btn_answer3.setOnClickListener(answerButtonClickListener);

    }

    private void nextTurn(){
        //create a new question.
        //set text on answer button.

        g.makeNewQuestion();
        int[] answer= g.getCurrentQuestion().getAnswerArray();

        btn_answer0.setText(Integer.toString(answer[0]));
        btn_answer1.setText(Integer.toString(answer[1]));
        btn_answer2.setText(Integer.toString(answer[2]));
        btn_answer3.setText(Integer.toString(answer[3]));

        btn_answer0.setEnabled(true);
        btn_answer1.setEnabled(true);
        btn_answer2.setEnabled(true);
        btn_answer3.setEnabled(true);

        tv_question.setText(g.getCurrentQuestion().getQuestionPhrase());

        //update bottom text
        tv_bottommessage.setText(g.getNumberCorrect() + " /" + (g.getTotalQuestion() -1));
    }
}