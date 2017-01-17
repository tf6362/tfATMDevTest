package com.backbase.devtest;

/**
 * Created by bbates on 1/16/17.
 */
public class ATM {

    Address address=null;
    int distance=0;
    String type=null;

    /**
     * getAddress
     * @return address Object
     */
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * getDistance
      * @return distance from set point
     */

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    /**
     * getType
     * @return type of ATM
     */
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }



}
