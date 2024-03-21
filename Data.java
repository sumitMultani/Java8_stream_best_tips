package com.model.stream.demo;

import java.util.ArrayList;
import java.util.List;

public class Data {

    public static List<Company> getCompanyList() {
        List<Company> companies = new ArrayList<>();
        Company company = new Company();
        company.setName("Gain java knowledge");
        company.setAddress(getAddress());
        company.setPersonList(getPersonList());
        companies.add(company);
        return companies;
    }

    private static Address getAddress() {
        Address address  =new Address();
        address.setStreet("local");
        address.setCity(getCity());
        return address;
    }

    private static List<Person> getPersonList() {
        List<Person> personList = new ArrayList<>();
        Person person = new Person();
        person.setName("Sumit");
        person.setId(1l);
        personList.add(person);
        Person person2 = new Person();
        person2.setName("Vivek");
        person2.setId(2l);
        personList.add(person2);
        return personList;
    }

    private static City getCity() {
        City city = new City(); //null;
        city.setName("Naraingarh");
        city.setState(getState());
        return city;
    }

    private static State getState() {
        State state = new State();
        state.setName("Haryana");
        return state;
    }

}
