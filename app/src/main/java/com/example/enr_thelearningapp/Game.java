package com.example.enr_thelearningapp;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<kidsQuestion> question;
    private int numberCorrect;
    private  int numberIncorrect;
    private  int totalQuestion;
    private int score;
    private kidsQuestion currentQuestion;


    public Game(){
        numberCorrect=0;
        numberIncorrect=0;
        totalQuestion=0;
        score=0;
        currentQuestion=new kidsQuestion(10);
        question=new ArrayList<kidsQuestion>();
    }
    public void makeNewQuestion(){
        currentQuestion=new kidsQuestion(totalQuestion * 2 + 5);
        totalQuestion++;
        question.add(currentQuestion);
    }
    public  boolean checkAnswer(int submittedAnswer){
        boolean isCorrect;
        if(currentQuestion.getAns()==submittedAnswer){
            numberCorrect++;
            isCorrect=true;
        }
        else
        {
            numberIncorrect++;
            isCorrect=false;
        }
        score=numberCorrect*10-numberIncorrect*30;
        return isCorrect;
    }

//Getters & setters
    public List<kidsQuestion> getQuestion() {
        return question;
    }

    public void setQuestion(List<kidsQuestion> question) {
        this.question = question;
    }

    public int getNumberCorrect() {
        return numberCorrect;
    }

    public void setNumberCorrect(int numberCorrect) {
        this.numberCorrect = numberCorrect;
    }

    public int getNumberIncorrect() {
        return numberIncorrect;
    }

    public void setNumberIncorrect(int numberIncorrect) {
        this.numberIncorrect = numberIncorrect;
    }

    public int getTotalQuestion() {
        return totalQuestion;
    }

    public void setTotalQuestion(int totalQuestion) {
        this.totalQuestion = totalQuestion;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public kidsQuestion getCurrentQuestion() {
        return currentQuestion;
    }

    public void setCurrentQuestion(kidsQuestion currentQuestion) {
        this.currentQuestion = currentQuestion;
    }

}
