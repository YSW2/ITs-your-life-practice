package ch19.practice1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        Manager manager = new Manager();
        Scanner sc = new Scanner(System.in);
        Map<String, Product> usedList = new HashMap<>();

        manager.register("insta", new CardTemplate("Instagram Story", "*"));
        manager.register("twit", new CardTemplate("Tweet Style", "-"));
        manager.register("short", new CardTemplate("YouTube Shorts", "#"));

        while (true) {
            manager.printRegisteredStyles();

            System.out.print("사용할 스타일 이름 입력 (종료: exit): ");
            String style = sc.nextLine();

            if (style.equals("exit")) break;

            System.out.print("출력할 문구 입력: ");
            String title = sc.nextLine();

            Product product = manager.create(style);

            if (product == null) {
                System.out.println("[Error] 등록되지 않은 스타일입니다: " + style);
                continue;
            }

            usedList.put(title, product);
            product.use(title);
        }
        System.out.println("\uD83D\uDCE6 사용된 카드 목록 출력: ");

        usedList.forEach((title, product) -> {
            product.use(title);
        });
    }
}
