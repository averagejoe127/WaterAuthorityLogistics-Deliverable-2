package Model;

import Controller.Controller;

public class FlushModel {
    private Controller controller;
    private int hydrantID;
    private String flushDate;
    private int flushStartTime;
    private int flushEndTime;
    private int flushDuration;
    private double totalGallonsFlushed;

    public FlushModel(int hydrantID, String flushDate, int flushStartTime, int flushEndTime) {
        this.hydrantID = hydrantID;
        this.flushDate = flushDate;
        this.flushStartTime = flushStartTime;
        this.flushEndTime = flushEndTime;
        this.flushDuration = flushEndTime - flushStartTime;
        this.totalGallonsFlushed = flushDuration * 1089.56;
    }
    
    public int getHydrantID() {
        return hydrantID;
    }
    
    public String getFlushDate() {
        return flushDate;
    }
    
    public int getFlshStartTime() {
        return flushStartTime;
    }
    
    public int getFlushEndTime() {
        return flushEndTime;
    }
    
    public int getFlushDuration() {
        return flushDuration;
    }
    
    public double getTotalGallonsFlushed() {
        return totalGallonsFlushed;
    }

    @Override
    public String toString() {
        return "Hydrant ID: " + hydrantID + ", Flush Date: " + flushDate + ", Start Time: " + flushStartTime + ", End Time: " + flushEndTime + ", Duration: " + flushDuration + ", Total Gallons Flushed: " + totalGallonsFlushed;
    }
}