package com.model.stream.demo;

public class State {

    private String name;

    // getter and setter methods.
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // toString method

    @Override
    public String toString() {
        return "State{" +
                "name='" + name + '\'' +
                '}';
    }
}
