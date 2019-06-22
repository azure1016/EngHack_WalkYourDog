package com.quintus.labs.datingapp.Models;

/**
 * Created by Quintus Labs on 19-Dec-2018.
 * www.quintuslabs.com
 */

public class Cards {
    private String id;
    private String name, img;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    private int rating;

}
