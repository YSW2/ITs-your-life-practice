package ch06.practice.ex02;

import java.util.Scanner;

public class Input {
    static Scanner scanner = new Scanner(System.in);

    String read (String title) {
        System.out.print(title);
        return scanner.nextLine();
    }

    String read (String title, String defaultValue) {
        System.out.print(title + "(" + defaultValue + ")");
        String line = scanner.nextLine();
        if (line.isEmpty()) return defaultValue;
        else return line;
    }

    int readInt (String title) {
        System.out.print(title);
        return Integer.parseInt(scanner.nextLine());
    }

    boolean confirm (String title, boolean defaultValue) {
        System.out.print(title);
        if (defaultValue) {
            System.out.print("(Y / n)");
        } else {
            System.out.print("(y / N)");
        }

        String line = scanner.nextLine();

        if (line.isEmpty()) return defaultValue;
        else return line.equals("y");
    }

    boolean confirm (String title) {
        return this.confirm(title, true);
    }
}
