package com.app.mystore.dto;

public class Interview {
    private int interviewID;
    private int applicationID;
    private String type;
    private String date;
    private String time;
    private String notify;

    public Interview() {
    }

    public Interview(int interviewID, int applicationID, String type, String date, String time, String notify) {
        this.interviewID = interviewID;
        this.applicationID = applicationID;
        this.type = type;
        this.date = date;
        this.time = time;
        this.notify = notify;
    }

    public int getInterviewID() {
        return interviewID;
    }

    public void setInterviewID(int interviewID) {
        this.interviewID = interviewID;
    }

    public int getApplicationID() {
        return applicationID;
    }

    public void setApplicationID(int applicationID) {
        this.applicationID = applicationID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getNotify() {
        return notify;
    }

    public void setNotify(String notify) {
        this.notify = notify;
    }
}
