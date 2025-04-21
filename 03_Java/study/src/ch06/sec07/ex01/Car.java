package ch06.sec07.ex01;

public class Car {
    String model; // 기본값: null
    boolean start; // 기본값: false
    int speed; // 기본값: 0

    public Car (String model, String color, int speed) {
        this(color + " " + model, speed);
    }

    public Car (String model, int speed) {
        this.speed = speed;
        this.model = model;
    }
}
