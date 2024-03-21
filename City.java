package com.model.stream.demo;

public class City {

    private String name;
    private State state;

    // getter and setter methods.
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    // toString method

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", state=" + state +
                '}';
    }
}
