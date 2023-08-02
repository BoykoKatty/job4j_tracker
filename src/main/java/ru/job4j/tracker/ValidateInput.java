package ru.job4j.tracker;

public class ValidateInput implements Input {

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
        int value;
        String answer = askStr(question);
        try {
            value = Integer.parseInt(answer);
        } catch (NumberFormatException nfe) {
            out.println("Please enter valid data");
            value = askInt(question);
        }
        return value;
    }

    @Override
    public void closeResource() {
        in.closeResource();
    }
}