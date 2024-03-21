package com.model.stream.demo;

public class Address {

    private String street;
    private City city;

    // getter and setter methods.
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    // toString method

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", city=" + city +
                '}';
    }
}
