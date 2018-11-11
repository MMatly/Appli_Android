package com.example.mathi.appli_android;

public class POI {

    String type;
    String display;
    String id;
    String media;
    String country;
    int stars;
    float sort;
    float distance;
    float visit_duration;
    int tag;
    String city;
    float lat;
    float lon;

    public String getType() {
        return type;
    }

    public String getDisplay() {
        return display;
    }

    public String getId() {
        return id;
    }

    public String getMedia() {
        return media;
    }

    public String getCountry() {
        return country;
    }

    public int getStars() {
        return stars;
    }

    public float getSort() {
        return sort;
    }

    public float getDistance() {
        return distance;
    }

    public float getVisit_duration() {
        return visit_duration;
    }

    public int getTag() {
        return tag;
    }

    public String getCity() {
        return city;
    }

    public float getLat() {
        return lat;
    }

    public float getLon() {
        return lon;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setMedia(String media) {
        this.media = media;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public void setSort(float sort) {
        this.sort = sort;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public void setVisit_duration(float visit_duration) {
        this.visit_duration = visit_duration;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public void setLon(float lon) {
        this.lon = lon;
    }

    public POI(String type, String display, String id, String media, String country, int stars, float sort, float distance, float visit_duration, int tag, String city, float lat, float lon) {
        this.type = type;
        this.display = display;
        this.id = id;
        this.media = media;
        this.country = country;
        this.stars = stars;
        this.sort = sort;
        this.distance = distance;
        this.visit_duration = visit_duration;
        this.tag = tag;
        this.city = city;
        this.lat = lat;
        this.lon = lon;
    }
}
