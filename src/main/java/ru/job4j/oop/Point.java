package ru.job4j.oop;

public class Point {

    private int x;
    private int y;
    private int z;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void updateCoordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void updateCoordinate(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double distance(Point point) {
        return Math.sqrt(Math.pow(point.x - this.x, 2) + Math.pow(point.y - this.y, 2));
    }

    public double distance3d(Point point) {
        return Math.sqrt(Math.pow(point.x - this.x, 2) + Math.pow(point.y - this.y, 2) + Math.pow(point.z - this.z, 2));
    }

    public static void main(String[] args) {
        Point point1 = new Point(5, 4);
        Point point2 = new Point(-7, -1);
        double result = point1.distance(point2);
        System.out.printf("Distance from (%s, %s) to (%s, %s) = %s%n", point1.x, point1.y, point2.x, point2.y, result);
        point1.updateCoordinate(11, 18);
        point2.updateCoordinate(-17, -11);
        result = point1.distance(point2);
        System.out.printf("Distance from (%s, %s) to (%s, %s) = %s%n", point1.x, point1.y, point2.x, point2.y, result);
    }
}