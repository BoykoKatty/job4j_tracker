package ru.job4j.pojo;

import java.time.LocalDate;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFullName("Иванов Иван Иванович");
        student.setGroup("РА-11");
        student.setEntryDate(LocalDate.of(2020, 9, 1));
        System.out.println(student.getFullName());
        System.out.println(student.getGroup());
        System.out.println(student.getEntryDate());
    }
}
