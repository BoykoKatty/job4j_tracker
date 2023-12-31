package ru.job4j.io;

import java.util.Random;
import java.util.Scanner;

public class MagicBall {
    public static void main(String[] args) {
        System.out.print("Я великий Оракул. Что ты хочешь узнать? ");
        try (Scanner scan = new Scanner(System.in)) {
            scan.nextLine();
            String answer = switch (new Random().nextInt(3)) {
                case 0 -> "Да";
                case 1 -> "Нет";
                default -> "Может быть";
            };
            System.out.println(answer);
        }
    }
}
