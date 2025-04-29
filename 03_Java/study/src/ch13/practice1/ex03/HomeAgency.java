package ch13.practice1.ex03;

public class HomeAgency implements Rentable<Home> {
    public Home rent () {
        return new Home();
    }
}