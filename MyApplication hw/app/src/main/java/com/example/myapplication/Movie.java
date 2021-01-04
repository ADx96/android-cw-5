package com.example.myapplication;

import java.io.Serializable;

public class Movie implements Serializable {

  private  String name;
   private double duration;
   private double rating;
    private int year;
   private  int img;

    public Movie(String name, double duration, double rating, int year, int img) {
        this.name = name;
        this.duration = duration;
        this.rating = rating;
        this.year = year;
        this.img = img;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
