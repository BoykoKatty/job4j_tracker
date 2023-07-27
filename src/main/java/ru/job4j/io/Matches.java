package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Игра 11.");
        boolean turn = true;
        int count = 11;
        String player = null;
        while (count > 0) {
            player = turn ? "Первый игрок" : "Второй игрок";
            System.out.println(player + " введите число от 1 до 3:");
            String matchesStr = input.nextLine();
            Integer matches;
            try {
                matches = Integer.valueOf(matchesStr);
            } catch (NumberFormatException e) {
                matches = null;
            }
            if (matches == null || count < matches || matches < 1 || matches > 3) {
                System.out.println("Некорректный ввод.");
            } else {
                count -= matches;
                turn = !turn;
            }
        }
        System.out.printf("Выиграл %s%n", player.toLowerCase());
        input.close();
    }
}