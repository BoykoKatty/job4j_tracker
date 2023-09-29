package ru.job4j.testmy;

public class Parent {
    private String name;
    private String surname;

    public Parent(String name) {
        this.name = name;
    }

    public Parent(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
