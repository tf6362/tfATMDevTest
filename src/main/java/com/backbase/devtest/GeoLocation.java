package com.backbase.devtest;

/**
 * Created by bbates on 1/16/17.
 */
public class GeoLocation {
    float lat=0.000000f;

    /**
     *  getLat
     * @return  float latitude
     */
    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    /**
     * getLng
     * @return  float longitude
     */
    public float getLng() {
        return lng;
    }

    public void setLng(float lng) {
        this.lng = lng;
    }

    float lng=0.000000f;
}
