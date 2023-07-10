package ru.job4j.oop;

public class Jukebox {

    public void music(int position) {
        String melody = switch (position) {
            case 1 -> "Пусть бегут неуклюже";
            case 2 -> "Спокойной ночи";
            default -> "Песня не найдена";
        };
        System.out.println(melody);
    }

    public static void main(String[] args) {
        Jukebox jukebox = new Jukebox();
        for (int i = 0; i < 3; i++) {
            System.out.printf("Позиция %d: ", i);
            jukebox.music(i);
        }
    }

}