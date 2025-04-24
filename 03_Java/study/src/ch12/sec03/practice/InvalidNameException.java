package ch12.sec03.practice;

public class InvalidNameException extends Exception {
    public InvalidNameException () {
    }

    public InvalidNameException (String message) {
        super(message);
    }
}
