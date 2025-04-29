package ch13.practice1.ex03;

public class CarAgency implements Rentable<Car> {
    public Car rent () {
        return new Car();
    }
}
