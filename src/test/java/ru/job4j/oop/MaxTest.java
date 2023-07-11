package ru.job4j.oop;

import org.junit.Assert;
import org.junit.Test;

public class MaxTest {

    @Test
    public void whenMax1And2And3Then3() {
        int one = 1;
        int two = 2;
        int three = 3;
        int result = Max.max(one, two, three);
        int expected = 3;
        Assert.assertEquals(expected, result);
    }

    @Test
    public void whenMax1And2And3And4Then4() {
        int one = 1;
        int two = 2;
        int three = 3;
        int four = 4;
        int result = Max.max(one, two, three, four);
        int expected = 4;
        Assert.assertEquals(expected, result);
    }
}