package ch19.practice1;

public class CardTemplate implements Product {
    String title;
    String frameChar;

    public CardTemplate (String title, String frameChar) {
        this.title = title;
        this.frameChar = frameChar;
    }

    @Override
    public void use (String content) {
        System.out.println("[" + title + "]");
        for (int i = 0; i < content.length(); i++) {
            System.out.print(frameChar);
        }
        System.out.println("\n" + content);
        for (int i = 0; i < content.length(); i++) {
            System.out.print(frameChar);
        }
        System.out.println("\n");
    }

    @Override
    public Product createCopy () {
        Product p = null;

        p = (Product) clone();

        return p;
    }

    @Override
    public Object clone () {
        return this;
    }

    @Override
    public String toString () {
        return title;
    }
}
