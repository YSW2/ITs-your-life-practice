package ch12.sec03.practice1.ex11;

public class StringBuilderExample {
    public static void main (String[] args) {
        String data = new StringBuilder()
                .append("DEF")
                .insert(0, "ABC")
                .delete(3, 4)
                .toString();
        System.out.println(data);
        //ABCEF
    }
}