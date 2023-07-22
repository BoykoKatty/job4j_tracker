package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book[] bookShell = {new Book("Book №1", 100),
                new Book("Book №2", 200),
                new Book("Book №3", 300),
                new Book("Clean Code", 464)};
        for (int i = 0; i < bookShell.length; i++) {
            System.out.println(bookShell[i]);
        }
        Book temp = bookShell[0];
        bookShell[0] = bookShell[3];
        bookShell[3] = temp;
        System.out.println();
        for (int i = 0; i < bookShell.length; i++) {
            if (bookShell[i].getName().equals("Clean Code")) {
                System.out.println(bookShell[i]);
            }
        }
    }

}
