package ru.job4j.ex;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
            for (User u : users) {
                if (u != null && u.getUsername().equals(login)) {
                    return u;
                }
            }
            throw new UserNotFoundException("User is not found.");
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (!user.isValid()) {
            throw new UserInvalidException("User is not valid");
        }
        if (user.getUsername().length() < 3) {
            throw new UserInvalidException("Login length is less than 3 symbols.");
        }
        return true;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Иван", true),
                new User("Иа", true),
                new User("Петр", false)
        };
        for (String login: new String[]{"Иван", "Иа", "Алексей", "Петр"}) {
            System.out.print(login + ": ");
            try {
                User user = findUser(users, login);
                if (validate(user)) {
                    System.out.println("This user has an access");
                }
            } catch (UserInvalidException e) {
                System.out.println("UserInvalidException: " + e);
            } catch (UserNotFoundException e) {
                System.out.println("UserNotFoundException: " + e);
            }
        }
    }
}