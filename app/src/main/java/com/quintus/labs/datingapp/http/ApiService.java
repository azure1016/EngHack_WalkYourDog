package com.quintus.labs.datingapp.http;

import com.quintus.labs.datingapp.Models.*;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.*;


public interface ApiService {

    //-------------------Dog Like Volunteers---------------------
    @POST("/likeVoln/{dogid}/{volunteerid}/{time}")
    Observable<RespFormat> createLikeVolunteer(@Query("dogid") String dogid,
                                         @Query("volunteerid") String volunteerid,
                                         @Query("time") String time);

    //-------------------Volunteers Like Dog---------------------
    @POST("/likeDog/{dogid}/{volunteerid}/{time}")
    Observable<RespFormat> createLikeDog(@Query("dogid") String dogid,
                                         @Query("volunteerid") String volunteerid,
                                         @Query("time") String time);
    // get by dogid OR volunteerid
    @GET("/like/{dogid}/{volunteerid}")
    Observable<RespFormat> getDogLike(@Query("dogid") String dogid,
                                      @Query("volunteerid") String volunteerid);


    //------------------Timeslot----------------------

    //create in timeslot
    @POST("/timeslot/{time}/{dogid}/{volunteerid}")
    Observable<RespFormat> createInTimeslot(@Query("time") String time,
                                        @Query("dogid") String dogid,
                                        @Query("volunteerid") String volunteerid
                                        );

    //get by timeslot
    @GET("/timeslot/{time}/{volunteerid}/{dogid}")
    Observable<RespFormat> getByTimeslot(@Query("time") String time,
                                         @Query("dogid") String dogid,
                                         @Query("volunteerid") String volunteerid);


//
//    //-------------------Profile------------------------------
//
    @POST("/dog/{id}/{name}/{rating}/{img}")
    Observable<RespFormat> createDogProfile(@Query("time") String id,
                                         @Query("dogid") String name,
                                         @Query("time") int rating,
                                         @Query("dogid") String img);

    @POST("/volunteer/{id}/{name}/{rating}/{img}")
    Observable<RespFormat> createVolunteerProfile(@Query("time") String id,
                                         @Query("dogid") String name,
                                         @Query("time") int rating,
                                         @Query("dogid") String img);

}
