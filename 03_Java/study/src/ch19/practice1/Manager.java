package ch19.practice1;

import java.util.HashMap;
import java.util.Map;

public class Manager {
    Map<String, Product> cards = new HashMap<>();

    public void register (String name, Product p) {
        cards.put(name, p);
    }

    public Product create (String name) {
        Product p = cards.get(name);
        if (p == null) return null;
        return p.createCopy();
    }

    public void printRegisteredStyles () {
        System.out.println("[등록된 스타일 목록]");
        cards.forEach((key, product) -> System.out.println("- " + key + " : " + product));
    }
}
