package com.app.mystore.dto;
/**
 * Author: Mitchell Moore
 * B00647455
 * Application object to store all application attributes.
 */
public class Application {
    private int applicationID;
    private int jobID;
    private int userID;
    private String firstName;
    private String lastName;
    private String email;
    private String date;
    private String address;
    private String phoneNumber;

    public Application() {
    }

    public Application(int applicationID, int jobID, int userID, String firstName, String lastName, String email, String date, String address, String phoneNumber) {
        this.applicationID = applicationID;
        this.jobID = jobID;
        this.userID = userID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.date = date;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public int getApplicationID() {
        return applicationID;
    }

    public void setApplicationID(int applicationID) {
        this.applicationID = applicationID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getJobID() {
        return jobID;
    }

    public void setJobID(int jobID) {
        this.jobID = jobID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
}

