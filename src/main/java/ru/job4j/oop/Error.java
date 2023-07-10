package ru.job4j.oop;

public class Error {
    boolean active;
    int status;
    String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println("Error{"
                + "active=" + active
                + ", status=" + status
                + ", message='" + message + '\''
                + '}');
    }

    public static void main(String[] args) {
        Error error1 = new Error();
        Error error2 = new Error(true, 2, "Возникла непредвиденная ошибка 1.");
        Error error3 = new Error(true, 3, "Возникла непредвиденная ошибка 2.");
        error1.printInfo();
        error2.printInfo();
        error3.printInfo();
    }
}
