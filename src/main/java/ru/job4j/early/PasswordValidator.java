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
        if (checkSpecialWords(password)) {
            throw new IllegalArgumentException(
                    "Password shouldn't contain substrings: qwerty, 12345, password, admin, user"
            );
        }

        String errorDescription = fitsToRequirement(password);
        if (errorDescription != null) {
            throw new IllegalArgumentException(errorDescription);
        }

        return password;
    }

    private static String fitsToRequirement(String password) {
        int numberLowerCase = 0, numberUpperCase = 0, numberIsDigit = 0, numberIsNotLetterOrDigit = 0;
        String errorDescription = null;
        for (char c : password.toCharArray()) {
            if (Character.isLowerCase(c)) {
                numberLowerCase++;
            }
            if (Character.isUpperCase(c)) {
                numberUpperCase++;
            }
            if (Character.isDigit(c)) {
                numberIsDigit++;
            }
            if (!Character.isLetterOrDigit(c)) {
                numberIsNotLetterOrDigit++;
            }
        }
        errorDescription = numberLowerCase == 0 ? "Password should contain at least one lowercase letter" : errorDescription;
        errorDescription = numberUpperCase == 0 ? "Password should contain at least one uppercase letter" : errorDescription;
        errorDescription = numberIsDigit == 0 ? "Password should contain at least one figure" : errorDescription;
        errorDescription = numberIsNotLetterOrDigit == 0 ? "Password should contain at least one special symbol" : errorDescription;
        return errorDescription;
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