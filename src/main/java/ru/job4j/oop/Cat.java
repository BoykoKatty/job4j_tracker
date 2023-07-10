package ru.job4j.oop;

public class Cat {

    private String name;
    private String food;

    public void show() {
        System.out.printf("Имя: %s, еда: %s", this.name, this.food);
    }

    public void eat(String meat) {
        this.food = meat;
    }

    public void giveNick(String nick) {
        this.name = nick;
    }

    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.giveNick("Tom");
        cat.eat("Jerry");
        cat.show();
    }
}