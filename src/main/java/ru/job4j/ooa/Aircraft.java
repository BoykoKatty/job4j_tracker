package ru.job4j.ooa;

public class Aircraft {

    public void printModel() {
        System.out.println("Метод выводит в консоль модель самолета.");
    }

    protected void testProtected() throws CloneNotSupportedException {
        this.clone();
        System.out.println("testProtected");
    }
}