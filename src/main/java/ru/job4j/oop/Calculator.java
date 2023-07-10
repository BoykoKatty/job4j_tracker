package ru.job4j.oop;

public class Calculator {

    private static final int X = 5;

    public static int sum(int y) {
        return X + y;
    }

    public static int minus(int y) {
        return X - y;
    }

    public int multiply(int y) {
        return X * y;
    }

    public double divide(int y) {
        return (double) X / y;
    }

    public double sumAllOperation(int y) {
        return Calculator.sum(y)
                + Calculator.minus(y)
                + this.multiply(y)
                + this.divide(y);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.printf("Сумма: %s%n", sum(3));
        System.out.printf("Разница: %s%n", minus(3));
        System.out.printf("Умножение: %s%n", calculator.multiply(3));
        System.out.printf("Деление: %s%n", calculator.divide(3));
        System.out.printf("Все операции: %s%n", calculator.sumAllOperation(3));
    }
}