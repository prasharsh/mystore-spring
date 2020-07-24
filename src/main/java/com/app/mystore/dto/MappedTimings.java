package com.app.mystore.dto;

public class MappedTimings {
    private String userId;
    private long monShift;
    private long tueShift;
    private long wedShift;


    public String getUserId() {

        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public long getMonShift() {
        return monShift;
    }

    public void setMonShift(long monShift) {
        this.monShift = monShift;
    }

    public long getTueShift() {
        return tueShift;
    }

    public void setTueShift(long tueShift) {
        this.tueShift = tueShift;
    }

    public long getWedShift() {
        return wedShift;
    }

    public void setWedShift(long wedShift) {
        this.wedShift = wedShift;
    }

    public long getThursShift() {
        return thursShift;
    }

    public void setThursShift(long thursShift) {
        this.thursShift = thursShift;
    }

    public long getFriShift() {
        return friShift;
    }

    public void setFriShift(long friShift) {
        this.friShift = friShift;
    }

    public long getSatShift() {
        return satShift;
    }

    public void setSatShift(long satShift) {
        this.satShift = satShift;
    }

    public long getSunShift() {
        return sunShift;
    }

    public void setSunShift(long sunShift) {
        this.sunShift = sunShift;
    }

    private long thursShift;
    private long friShift;
    private long satShift;
    private long sunShift;
}
