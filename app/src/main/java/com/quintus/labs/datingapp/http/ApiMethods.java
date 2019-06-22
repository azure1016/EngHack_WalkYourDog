package com.quintus.labs.datingapp.http;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

import com.quintus.labs.datingapp.Utils.User;
import com.quintus.labs.datingapp.Models.*;


public class ApiMethods {
    public static void ApiSubscribe(Observable observable, Observer observer) {
        observable.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

//---------------------User profile------------------------

    public static void createDogProfile(Observer<List<User>> observer,
                                     String userId, String name, int timeslot, String picture) {
        ApiSubscribe(Api.getApiService().createDogProfile(userId, name, timeslot, picture), observer);
    }

    public static void createVolunteerProfile(Observer<List<User>> observer,
                                        String userId, String name, int timeslot, String picture) {
        ApiSubscribe(Api.getApiService().createVolunteerProfile(userId, name, timeslot, picture), observer);
    }

//---------------------Unilike------------------------
    //---------------------Like Dog------------------------

    public static void createLikeDog(Observer<RespFormat> observer,
                                   String likingId, String likedId, String timeslot) {
        ApiSubscribe(Api.getApiService().createLikeDog(likingId, likedId, timeslot), observer);
    }

    public static void getLike(Observer<RespFormat> observer,
                                String dogId, String volunteerId) {
        ApiSubscribe(Api.getApiService().getDogLike(dogId, volunteerId), observer);
    }

    //---------------------Like Volunteer------------------------

    public static void createLikeVolunteer(Observer<RespFormat> observer,
                                   String dogid, String volunteerid, String time) {
        ApiSubscribe(Api.getApiService().createLikeVolunteer(dogid, volunteerid, time), observer);
    }


//    //-----------------------getMatch--------------------------
//    public static void getLiked(Observer<List<LikeAd>> observer,
//                               String storename, String address, double latitude, double longitude, String city, double postcode) {
//        ApiSubscribe(Api.getApiService().createStore(storename, address, latitude, longitude, city, postcode), observer);
//    }
    //---------------------Ads------------------------
    //---------------------available dogs OR volunteers------------------------
    public static void getByTimeslot(Observer<RespFormat> observer,
                                   String dogId, String volunteerid, String timeslot) {
        ApiSubscribe(Api.getApiService().getByTimeslot(dogId, volunteerid, timeslot), observer);
    }



}
