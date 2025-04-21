package ch04.practice;

import java.util.Scanner;

public class Ch07 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int selected;
        int balance = 0;
        int inputBalance = 0;

        do {
            System.out.println("------------------------------");
            System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
            System.out.println("------------------------------");
            System.out.print("선택> ");

            selected = sc.nextInt();

            switch (selected) {
                case 1 -> {
                    System.out.print("예금액> ");
                    inputBalance = sc.nextInt();
                    balance += inputBalance;
                }
                case 2 -> {
                    System.out.print("출금액> ");
                    inputBalance = sc.nextInt();
                    if (balance >= inputBalance) {
                        balance -= inputBalance;
                    } else {
                        System.out.println("잔액이 부족합니다.");
                    }
                }
                case 3 -> {
                    System.out.println("잔고> " + balance);
                }
            }

        } while (selected != 4);
    }
}
