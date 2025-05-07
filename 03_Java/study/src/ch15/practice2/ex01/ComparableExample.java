package ch15.practice2.ex01;

import java.util.TreeSet;

public class ComparableExample {
    public static void main (String[] args) {
        TreeSet<Person> tree = new TreeSet<>();

        tree.add(new Person("홍길동", 35));
        tree.add(new Person("김자바", 25));
        tree.add(new Person("박지원", 31));

        for (Person person : tree) {
            System.out.println(person.name + " " + person.age);
        }
    }
}