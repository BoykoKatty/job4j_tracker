package ru.job4j.poly;

public class Bus implements Transport {
    private double fuelPrice;

    public Bus(double fuelPrice) {
        this.fuelPrice = fuelPrice;
    }

    @Override
    public void go() {
        System.out.println("Автобус поехал. Пристегнитесь, торможение не предусмотрено.");
    }

    @Override
    public void passengers(int passengersNumber) {
        System.out.printf("В автобусе едет %d человек.%n", passengersNumber);
    }

    @Override
    public double refuel(double volume) {
        return volume * fuelPrice;
    }
}
