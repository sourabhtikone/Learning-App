package com.example.enr_thelearningapp;

import java.util.ArrayList;

public class Verticalcoursemodel {
    String title;
    ArrayList<Horizontalcoursemodel>arrayList;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<Horizontalcoursemodel> getArrayList() {
        return arrayList;
    }

    public void setArrayList(ArrayList<Horizontalcoursemodel> arrayList) {
        this.arrayList = arrayList;
    }
}
