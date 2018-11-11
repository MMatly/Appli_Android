package com.example.mathi.appli_android;

public class POI {

    String type;
    String display;
    String media;
    double lat;
    double lon;

    public String getType() {
        return type;
    }

    public String getDisplay() {
        return display;
    }

    public String getMedia() {
        return media;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public void setMedia(String media) {
        this.media = media;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public POI(String type, String display, String media, double lat, double lon) {
        this.type = type;
        this.display = display;
        this.media = media;
        this.lat = lat;
        this.lon = lon;
    }
}
