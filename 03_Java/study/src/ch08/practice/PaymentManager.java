package ch08.practice;

public class PaymentManager {
    int totalCount = 0;
    int totalAmount = 0;
    int totalCredit = 0;
    int totalKakao = 0;

    public void process (Payment payment, int amount) {
//        if (!payment.beforePay()) {
//            return;
//        }

        if (!payment.pay(amount)) {
            return;
        } else {
            payment.approve();
            payment.cancel("테스트 취소");

            this.totalCount += 1;
            this.totalAmount += amount;

            if (payment instanceof KakaoPay) {
                this.totalKakao += 1;
                ((KakaoPay) payment).sendNotification();
            } else {
                this.totalCredit += 1;
                System.out.println("[알림 서비스 없음]");
            }
        }
    }

    public void printSummary () {
        System.out.println("✅ 결제 통계 요약\n" +
                "총 결제 횟수: " + this.totalCount + "회\n" +
                "총 결제 금액: " + this.totalAmount + "원\n" +
                "[CreditCard] : " + this.totalCredit + "건\n" +
                "[KakaoPay] : " + this.totalKakao + "건");
    }
}
