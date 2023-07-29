package ru.job4j.cast;

public class Trip {
    public static void main(String[] args) {
        Vehicle[] vehicles = {new Bus(), new Train(), new Plane()};
        for (Vehicle vehicle:vehicles) {
            vehicle.describe();
            vehicle.move();
            System.out.println();
        }
    }
}
