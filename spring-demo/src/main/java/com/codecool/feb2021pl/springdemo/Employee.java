package com.codecool.feb2021pl.springdemo;

import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Employee {

    public static Map<String, Employee> cache = new HashMap<>();

    private String name;

    public static Employee create(String name) {

        if (cache.containsKey(name)) {
            return cache.get(name);
        }
        Employee employee;
        if ("Maryla".equalsIgnoreCase(name)) {
            employee = new Singer(name);
        } else {
            employee = Employee(name);
        }
        cache.put(name, employee);
        return employee;
    }

    public static Employee Employee() {
        return new Employee();
    }

    public static Employee Employee(String name) {
        return new Employee(name);
    }

    public static Employee zenek() {
        return new Singer("Zenek");
    }

    public static Employee czesiek() {
        return new Employee("Czesiek");
    }

    public Employee() {
        name = "Zenek";
    }

    public Employee(String name) {
        this.name = name;
    }

    public synchronized String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                '}';
    }
}
