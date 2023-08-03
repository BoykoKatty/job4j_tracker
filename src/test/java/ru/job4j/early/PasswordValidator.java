package ru.job4j.early;

public class PasswordValidator {
    private static final String[] FORBIDDEN = {"qwerty", "12345", "password", "admin", "user"};

    public static String validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException(
                    "Password can't be null"
            );
        }
        if (password.length() < 8 || password.length() > 32) {
            throw new IllegalArgumentException(
                    "Password should be length [8, 32]"
            );
        }
        if (password.toLowerCase().equals(password)) {
            throw new IllegalArgumentException(
                    "Password should contain at least one uppercase letter"
            );
        }
        if (password.toUpperCase().equals(password)) {
            throw new IllegalArgumentException(
                    "Password should contain at least one lowercase letter"
            );
        }
        if (password.replaceAll("[0-9]", "").equals(password)) {
            throw new IllegalArgumentException(
                    "Password should contain at least one figure"
            );
        }
        if (password.replaceAll("[^0-9,a-z,A-Z]", "").equals(password)) {
            throw new IllegalArgumentException(
                    "Password should contain at least one special symbol"
            );
        }
        if (checkSpecialWords(password)) {
            throw new IllegalArgumentException(
                    "Password shouldn't contain substrings: qwerty, 12345, password, admin, user"
            );
        }
        return password;
    }

    private static boolean checkSpecialWords(String password) {
        boolean result = false;
        password = password.toLowerCase();
        for (String forbiddenWord : FORBIDDEN) {
            if (password.contains(forbiddenWord)) {
                result = true;
                break;
            }
        }
        return result;
    }
}