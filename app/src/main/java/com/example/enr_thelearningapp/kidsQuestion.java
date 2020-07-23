package com.example.enr_thelearningapp;

import java.util.Random;

public class kidsQuestion {
    private  int firstNumber;
    private  int secondNumber;

    private  int ans;
    private  int [] answerArray;
    private int answerPosition;
    private int upperLimit;
    //string output of the problem
    private String questionPhrase;

    //generate a new random question
    public kidsQuestion(int upperLimit)
    {
        this.upperLimit=upperLimit;
        Random randomNumberMaker=new Random();

        this.firstNumber=randomNumberMaker.nextInt(upperLimit);
        this.secondNumber=randomNumberMaker.nextInt(upperLimit);
        this.ans=this.firstNumber+this.secondNumber;
        this.questionPhrase=firstNumber + " + "+ secondNumber + " = ";

        this.answerPosition=randomNumberMaker.nextInt(4);
        this.answerArray=new int[] {0,1,2,3};

        this.answerArray[0]=ans+1;
        this.answerArray[1]=ans+10;
        this.answerArray[2]=ans-5;
        this.answerArray[3]=ans-2;

        this.answerArray=shuffleArray(this.answerArray);

        answerArray[answerPosition]=ans;

    }

    private  int[] shuffleArray(int[] array)
    {
        int index,temp;
        Random randomNumberGenerator=new Random();

        for (int i=array.length-1;i>0;i--){
            index=randomNumberGenerator.nextInt(i+1);
            temp=array[index];
            array[index]=array[i];
            array[i]=temp;
        }
        return array;
    }


    public int getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(int firstNumber) {
        this.firstNumber = firstNumber;
    }

    public int getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(int secondNumber) {
        this.secondNumber = secondNumber;
    }

    public int getAns() {
        return ans;
    }

    public void setAns(int ans) {
        this.ans = ans;
    }

    public int[] getAnswerArray() {
        return answerArray;
    }

    public void setAnswerArray(int[] answerArray) {
        this.answerArray = answerArray;
    }

    public int getAnswerPosition() {
        return answerPosition;
    }

    public void setAnswerPosition(int answerPosition) {
        this.answerPosition = answerPosition;
    }

    public int getUpperLimit() {
        return upperLimit;
    }

    public void setUpperLimit(int upperLimit) {
        this.upperLimit = upperLimit;
    }

    public String getQuestionPhrase() {
        return questionPhrase;
    }

    public void setQuestionPhrase(String questionPhrase) {
        this.questionPhrase = questionPhrase;
    }
}
