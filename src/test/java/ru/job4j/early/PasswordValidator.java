package ru.job4j.early;

public class PasswordValidator {
    private static final String[] FORBIDDEN = {"qwerty", "12345", "password", "admin", "user"};

    private enum CheckableCondition {
        INCLUDES_LOWER_CASE("Password should contain at least one lowercase letter"),
        INCLUDES_UPPER_CASE("Password should contain at least one uppercase letter"),
        INCLUDES_NUMBER("Password should contain at least one figure"),
        INCLUDES_SYMBOL("Password should contain at least one special symbol");
        private final String exceptionDescription;

        CheckableCondition(String exceptionDescription) {
            this.exceptionDescription = exceptionDescription;
        }

        public String getExceptionDescription() {
            return exceptionDescription;
        }

    }

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
        for (CheckableCondition condition : CheckableCondition.values()) {
            if (!fitsToRequirement(password, condition)) {
                throw new IllegalArgumentException(condition.getExceptionDescription());
            }
        }
        return password;
    }

    private static boolean fitsToRequirement(String password, CheckableCondition condition) {
        boolean result = false;
        for (char c : password.toCharArray()) {
            result = switch (condition) {
                case INCLUDES_LOWER_CASE -> Character.isLowerCase(c);
                case INCLUDES_UPPER_CASE -> Character.isUpperCase(c);
                case INCLUDES_NUMBER -> Character.isDigit(c);
                case INCLUDES_SYMBOL -> !Character.isLetterOrDigit(c);
            };
            if (result) {
                break;
            }
        }
        return result;
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