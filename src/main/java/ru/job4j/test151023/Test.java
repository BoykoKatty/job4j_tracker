package ru.job4j.test151023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Test {
    protected class TestInner {

    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("Петров", "Ивано", "Сидоров");
        Comparator<String> cmpText = (left, right) -> left.compareTo(right);
        Comparator<String> cmpDescSize = (left, right) -> Integer.compare(right.length(), left.length());
        list.sort(cmpText);
        System.out.println(list);
        list.sort(cmpDescSize);
        System.out.println(list);
    }

}
