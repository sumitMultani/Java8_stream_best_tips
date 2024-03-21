package com.model.stream.demo;

import java.util.List;

class Company {

    private String name;
    private Address address;
    private List<Person> personList;

    // getter and setter methods.
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    // toString method

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", address=" + address +
                ", personList=" + personList +
                '}';
    }
}
