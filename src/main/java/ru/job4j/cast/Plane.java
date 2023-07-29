package ru.job4j.cast;

public class Plane implements Vehicle {
    @Override
    public void describe() {
        System.out.println("Это самолет");
    }

    @Override
    public void move() {
        System.out.println("Самолет летает по воздуху");
    }
}
