package ru.job4j.tracker;

public class ValidateInput extends ConsoleInput {

    @Override
    public int askInt(String question) {
        int value;
        try {
            value = super.askInt(question);
        } catch (NumberFormatException nfe) {
            System.out.println("Please enter valid data");
            value = askInt(question);
        }
        return value;
    }
}