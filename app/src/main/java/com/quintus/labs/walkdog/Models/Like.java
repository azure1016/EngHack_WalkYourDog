package com.quintus.labs.walkdog.Models;

public class Like extends Data{

    public void setLikingId(String likingId) {
        this.likingId = likingId;
    }

    public void setLikedId(String likedId) {
        this.likedId = likedId;
    }

    public void setTimeslot(int timeslot) {
        this.timeslot = timeslot;
    }

    private String likingId;

    public String getLikingId() {
        return likingId;
    }

    public String getLikedId() {
        return likedId;
    }

    public int getTimeslot() {
        return timeslot;
    }

    private String likedId;
    private int timeslot;

    public Like () {}
}

