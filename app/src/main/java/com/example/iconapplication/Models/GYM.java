package com.example.iconapplication.Models;

import java.io.Serializable;

public class GYM {
    public static final int MAX_LINES_COLLAPSED = 3;
    public static final int MIN_LINES_COLLAPSED = 1;

    private String name = "";
    private String address = "";
    private String phoneNumber = "";
    private float rating = 0.0f;
    private String poster = "";
    private boolean isFavorite = false;
    private double latitude = 0.0;
    private double longitude = 0.0;
    private int currentExercisers;

    public GYM() {
    }

    public String getName() {
        return name;
    }

    public GYM setName(String name) {
        this.name = name;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public GYM setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public GYM setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public float getRating() {
        return rating;
    }

    public GYM setRating(float rating) {
        this.rating = rating;
        return this;
    }

    public String getPoster() {
        return poster;
    }

    public GYM setPoster(String poster) {
        this.poster = poster;
        return this;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public GYM setFavorite(boolean favorite) {
        isFavorite = favorite;
        return this;
    }

    public double getLatitude() {
        return latitude;
    }

    public GYM setLatitude(double lat) {
        this.latitude = lat;
        return this;
    }

    public double getLongitude() {
        return longitude;
    }

    public GYM setLongitude(double lon) {
        this.longitude = lon;
        return this;
    }

    public int getCurrentExercisers() {
        return currentExercisers;
    }

    public GYM setCurrentExercisers(int currentExercisers) {
        this.currentExercisers = currentExercisers;
        return this;
    }
}

