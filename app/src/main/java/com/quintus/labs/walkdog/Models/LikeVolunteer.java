package com.quintus.labs.walkdog.Models;

public class LikeVolunteer extends Like {
    public LikeVolunteer (String dogId, String userId, int timeslot) {
        setLikingId(dogId);
        setLikedId(userId);
        setTimeslot(timeslot);
    }
}