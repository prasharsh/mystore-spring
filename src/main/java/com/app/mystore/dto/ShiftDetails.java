package com.app.mystore.dto;
/*
* Author : Parth Panchal
* B00845025
* The model saves the number of shifts permutations obtained from database.
* */
public class ShiftDetails {
    private String start,end;

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    private int number;


}
