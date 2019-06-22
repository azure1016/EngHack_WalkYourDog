package com.quintus.labs.datingapp.Models;

public class LikeDog extends Like{

        public LikeDog (String userId, String dogId, int timeslot) {
            setLikingId(userId);
            setLikedId(dogId);
            setTimeslot(timeslot);
        }
}
