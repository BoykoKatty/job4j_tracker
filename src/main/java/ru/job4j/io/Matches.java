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
            int matches = Integer.parseInt(matchesStr);
            if (matches < 1 || matches > Math.min(3, count)) {
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