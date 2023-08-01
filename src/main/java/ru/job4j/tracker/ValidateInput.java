package ru.job4j.tracker;

public class ValidateInput extends ConsoleInput {

    private final Output out;
    private final Input in;

    public ValidateInput(Output out, Input input) {
        this.out = out;
        this.in = input;
    }

    @Override
    public String askStr(String question) {
        return in.askStr(question);
    }

    @Override
    public int askInt(String question) {
        int value = -1;
        try {
            value = super.askInt(question);
        } catch (NumberFormatException nfe) {
            out.println("Please enter valid data");
            askInt(question);
        }
        return value;
    }
}