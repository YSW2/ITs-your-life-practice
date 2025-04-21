package ch06.sec08.ex01;

public class Calculator {
    boolean power;

    public Calculator () {
    }

    public void powerOn () {
        System.out.println("전원을 켭니다.");
        this.power = true;
    }

    public void powerOff () {
        System.out.println("전원을 끕니다.");
        this.power = false;
    }

    public int plus (int a, int b) {
        return a + b;
    }

    public double divide (double a, double b) {
        return a / b;
    }
}
