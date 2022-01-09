package com.codecool.feb2021pl.springdemo.people;

public class Person {
    private String name;

    private Person() {

    }

    public static Person create(String name) {
        Person person = new HappyPerson();
        person.name = name;
        return person;
    }

    private static class HappyPerson extends Person {

    }
}
