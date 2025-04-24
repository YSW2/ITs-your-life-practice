package ch12.sec03.practice1.ex05;

public class ThrowsExample1 {
    public static void main (String[] args) {
        try {
            findClass();
        } catch (ClassNotFoundException e) {
            System.out.println("예외 처리: " + e.toString());
        }
    }

    public static void findClass () throws ClassNotFoundException {
        Class.forName("java.lang.String2");
    }
}