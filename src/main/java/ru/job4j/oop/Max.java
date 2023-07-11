package ru.job4j.oop;

public class Max {
    public static int max(int left, int right) {
        return left > right ? left : right;
    }

    public static int max(int one, int two, int three) {
        int tmp = max(one, two);
        return max(tmp, three);
    }

    public static int max(int one, int two, int three, int four) {
        int tmp1 = max(one, two);
        int tmp2 = max(three, four);
        return max(tmp1, tmp2);
    }
}
