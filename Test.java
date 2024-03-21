package com.model.stream.demo;

import javax.swing.text.html.Option;
import java.util.*;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {

        //Find the maximum element in a list of integers.
        List<Integer> numbers = Arrays.asList(5, 11, 34, 99, 03, 30);
        int max = numbers.stream().mapToInt(Integer::intValue).max().getAsInt();
        System.out.println("Max Number : "+max);
        //Max Number : 99

        //Concatenate all the strings in a list into a single string.
        List<String> fruits = Arrays.asList("apple","banana","cherry","coconut","apple");
        String concat = fruits.stream().collect(Collectors.joining("-"));
        System.out.println("Concat : "+concat);
        //Concat : apple-banana-cherry-coconut-apple

        //Convert each string to uppercase and then sort them in alphabetical order.
        List<String> sortedUpperCase = fruits.stream().map(String::toUpperCase).sorted().collect(Collectors.toList());
        System.out.println("sortedUpperCase : "+sortedUpperCase);
        //sortedUpperCase : [APPLE, APPLE, BANANA, CHERRY, COCONUT]

        //Create a new list that contains only unique words (remove duplicates).
        List<String> duplicateFruits = Arrays.asList("apple","banana","cherry","coconut","apple","banana");
        List<String> uniqueFruits = duplicateFruits.stream().distinct().collect(Collectors.toList());
        System.out.println("uniqueFruits : "+uniqueFruits);
        //uniqueFruits : [apple, banana, cherry, coconut]

        //Find Second Smallest Element in a List
        Optional<Integer> secondSmallest = numbers.stream().distinct().sorted().skip(1).findFirst();
        System.out.println("secondSmallest : "+secondSmallest.get());
        //secondSmallest : 5

        Test2 test = new Test2();
        List<String> cityNames = test.getCityNames(Data.getCompanyList());
        System.out.println("City Names : "+cityNames);

        List<Person> persons = test.getAllPerson(Data.getCompanyList());
        System.out.println("persons : "+persons);

        Map<City, List<Company>>  cityCompy = test.getCompaniesByCity(Data.getCompanyList());
        System.out.println("cityCompy : "+cityCompy);

        boolean isExist = test.hasCompanyInCity(Data.getCompanyList(),"Dlh");
        System.out.println("hasCompanyInCity : "+isExist);

        List<String> cityNamesLog = test.getCityNamesLog(Data.getCompanyList());
        System.out.println("City Names : "+cityNamesLog);
    }

    public List<String> getCityNames(List<Company> companyList){
        return companyList.stream()
                .map(Company::getAddress)
                .filter(Objects::nonNull)
                .map(Address::getCity)
                .filter(Objects::nonNull)
                .map(City::getName)
                .filter(Objects::nonNull)
                .toList();
    }

    public List<Person> getAllPerson(List<Company> companyList) {
        return companyList.stream()
                .map(Company::getPersonList) // It returns a Stream<List<Person>>
                .flatMap(List::stream)  // It returns a Stream<Person>
                .toList();
    }

    // Grouping by an attribute
    public Map<City,List<Company>> getCompaniesByCity(List<Company> companyList){
        return companyList.stream()
                .collect(Collectors.groupingBy(company -> company.getAddress().getCity()));
    }

    //Check if there is an item in the stream
    public boolean hasCompanyInCity(List<Company> companyList, String cityName){
        return companyList.stream()
                .map(Company::getAddress)
                .map(Address::getCity)
                .map(City::getName)
                .anyMatch(cityName::equals);
    }

    //Use the peek method of write a log for each city name returned:
    public List<String> getCityNamesLog(List<Company> companyList){
        return companyList.stream()
                .map(Company::getAddress)
                .map(Address::getCity)
                .map(City::getName)
                //.peek(cityName -> logger.info("Info Name : "+cityName))
                .peek(cityName -> System.out.println("Info Log Name : "+cityName))
                .toList();
    }
}
