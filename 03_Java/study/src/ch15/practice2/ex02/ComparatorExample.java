package ch15.practice2.ex02;

import java.util.Comparator;
import java.util.TreeSet;

public class ComparatorExample {
    public static void main (String[] args) {
        TreeSet<Fruit> tree1 = new TreeSet<>(new FruitComparator());
        TreeSet<Fruit> tree2 = new TreeSet<>(new Comparator<Fruit>() {
            @Override
            public int compare (Fruit o1, Fruit o2) {
                return o1.price - o2.price;
            }
        });

        addPrint(tree1);
        addPrint(tree2);
    }

    public static void addPrint (TreeSet<Fruit> tree) {
        tree.add(new Fruit("포도", 3000));
        tree.add(new Fruit("수박", 10000));
        tree.add(new Fruit("딸기", 6000));

        for (Fruit f : tree) {
            System.out.println(f.name + " " + f.price);
        }
    }
}