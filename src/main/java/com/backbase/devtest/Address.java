package com.backbase.devtest;

/**
 * Created by bbates on 1/16/17.
 * used to store an address of an atm
 */
public class Address {
    String street=null;
    String housenumber=null;
    String postalcode=null;
    GeoLocation geoLocation=null;

    /**
     * getStreet
     * @return  street
     */
    public String getStreet() {
        return street;
    }

    /**
     * getGeoLocation
     * @return lattitude and longitude object
     */
    public GeoLocation getGeoLocation() {
        return geoLocation;
    }

    public void setGeoLocation(GeoLocation geoLocation) {
        this.geoLocation = geoLocation;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * getHousenumber
     * @return  house number
     */
    public String getHousenumber() {
        return housenumber;
    }

    public void setHousenumber(String housenumber) {
        this.housenumber = housenumber;
    }

    /**
     * getPostalcode
     * @return postal code
     */
    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    /**
     * getCity
     * @return city of atm
     */
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    String city=null;

}
