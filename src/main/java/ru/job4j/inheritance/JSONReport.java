package ru.job4j.inheritance;

public class JSONReport extends TextReport {
    @Override
    public String generate(String name, String body) {

        return String.format("{%n\t\"name\" : \"%s\",%n\t\"body\" : \"%s\"%n}", name, body);
    }
}
