package com.codecool.feb2021pl.springdemo;

public class Person {

    private String name;

    private Person() {

    }

    public static Person create(String name) {
        Person person = new Person();
        person.name = name;
        return person;
    }
}
