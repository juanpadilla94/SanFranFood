package com.example.juanm.sanfranfood;

/**
 * Created by JuanM on 10/5/2017.
 */

public class Restaurant {

    // unique id
    private String id;

    // restaurant name (may not be unique)
    private String name;

    private String rating;

    private String address;

    // latitude
    private double lat;

    // longitude
    private double lng;

    public Restaurant(String id, String name) {
        this.id = id;
        this.name = name;
    }

    // GETTER
    public String getName(){
        if(name == null) return "N/A";
        return name;
    }

    public String getID(){
        if(id == null) return "N/A";
        return id;
    }

    public double getLat(){
        return lat;
    }

    public double getLng(){
        return lng;
    }

    public String getRating() {
        if(rating == null) return "N/A";
        return rating;
    }

    public String getAddress() {
        if(address == null) return "N/A";
        return address;
    }

    // SETTERS

    public void setCoord(double lat, double lng) {
        this.lat = lat;
        this.lng = lng;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
