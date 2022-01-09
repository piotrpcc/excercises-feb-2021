package com.codecool.feb2021pl.springdemo;

import org.springframework.stereotype.Component;

@Component
public class EmployeeFactory {

    public Employee create() {
        return new Employee("aaaaa");
    }

    public Employee create(String name) {
        System.out.println("Elo");
        return new Employee(name);
    }
}
