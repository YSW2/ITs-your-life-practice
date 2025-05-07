package ch15.practice2.ex02;

import java.util.Comparator;

public class FruitComparator implements Comparator<Fruit> {
    @Override
    public int compare (Fruit o1, Fruit o2) {
        return o1.price - o2.price;
    }
}