package ch08.practice;

import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        Payment payment = null;
        Scanner sc = new Scanner(System.in);
        PaymentManager manager = new PaymentManager();

        while (true) {
            System.out.println("=== 유니페이 결제 시스템 ===");
            System.out.println("[1] 신용카드");
            System.out.println("[2] 카카오페이");
            System.out.print("결제 수단을 선택하세요:");

            int choice = sc.nextInt();
            switch (choice) {
                case 1 -> payment = new CreditCard();
                case 2 -> payment = new KakaoPay();
            }

            if (choice == 0) {
                break;
            }

            if (payment instanceof KakaoPay) {
                System.out.print("[카카오페이 사용자 인증을 진행하시겠습니까? (y/n)]");
                char ch = sc.next().charAt(0);

                if (ch == 'y') {
                    ((KakaoPay) payment).authenticate();
                }
            }

            if (payment.beforePay()) {
                System.out.print("결제 금액을 입력하세요: ");
                int amount = sc.nextInt();
                manager.process(payment, amount);
            }
            System.out.println();
        }

        manager.printSummary();
    }
    
}
