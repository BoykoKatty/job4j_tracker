package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("ivanov@mail.ru", "Ivanov Ivan");
        hashMap.put("sergeev@mail.ru", "Sergeev Sergey");
        hashMap.put("petrov@mail.ru", "Petrov Petr");
        hashMap.put("ivanov@mail.ru", "Ivanov Andrey");
        for (String key : hashMap.keySet()) {
            System.out.println(hashMap.get(key));
        }
    }
}
