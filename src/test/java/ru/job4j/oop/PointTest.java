package ru.job4j.oop;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {
    @Test
    public void when00to20then2() {
        double expected = 2;
        Point point1 = new Point(0, 0);
        Point point2 = new Point(2, 0);
        double out = point1.distance(point2);
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void when11to55then5dot66() {
        double expected = 5.66;
        Point point1 = new Point(1, 1);
        Point point2 = new Point(5, 5);
        double out = point1.distance(point2);
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void when24to67then5() {
        double expected = 5;
        Point point1 = new Point(2, 4);
        Point point2 = new Point(6, 7);
        double out = point1.distance(point2);
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void when20to00then2() {
        double expected = 2;
        Point point1 = new Point(2, 0);
        Point point2 = new Point(0, 0);
        double out = point1.distance(point2);
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void when201to001then2() {
        double expected = 2;
        Point point1 = new Point(2, 0, 1);
        Point point2 = new Point(0, 0, 1);
        double out = point1.distance3d(point2);
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void when203to002then2point2361() {
        double expected = 2.24;
        Point point1 = new Point(2, 0, 3);
        Point point2 = new Point(0, 0, 2);
        double out = point1.distance3d(point2);
        Assert.assertEquals(expected, out, 0.01);
    }

}