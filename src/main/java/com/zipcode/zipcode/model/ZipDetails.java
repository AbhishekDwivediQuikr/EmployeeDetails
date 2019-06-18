package com.zipcode.zipcode.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ZipDetails {
    @Id
    private int zipcode;
    private String city;
    private String State;

    public ZipDetails()
    {

    }
    public ZipDetails(int zipcode)
    {
        this.zipcode=zipcode;
    }


    public ZipDetails(int zipcode, String city, String state) {
        this.zipcode = zipcode;
        this.city = city;
        State = state;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    @Override
    public String toString() {
        return "ZipDetails{" +
                "zipcode=" + zipcode +
                ", city='" + city + '\'' +
                ", State='" + State + '\'' +
                '}';
    }
}
