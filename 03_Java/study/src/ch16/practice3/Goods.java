package ch16.practice3;

public class Goods {
    private String name;
    private int price;         // 정가
    private double discount;   // 할인율 (예: 0.2 = 20%)

    public Goods (String name, int price, double discount) {
        this.name = name;
        this.price = price;
        this.discount = discount;
    }

    public String getName () {
        return name;
    }

    public double getDiscount () {
        return discount;
    }

    public int getPrice () {
        return price;
    }

    int getDiscountedPrice () {
        return (int) (price * (1 - discount));
    }
}