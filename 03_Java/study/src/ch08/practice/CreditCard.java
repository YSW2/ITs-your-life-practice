package ch08.practice;

public class CreditCard implements Payment {
    public int amount = 0;

    public boolean pay (int amount) {
        System.out.println("[신용카드] " + amount + "원 결제 완료");
        this.amount = amount;
        Payment.log("결제 수단: [CreditCard], 금액: " + amount + "원");
        return true;
    }

    public boolean beforePay () {
        return Payment.super.beforePay();
    }

    public void approve () {
        System.out.println("[신용카드] 카드 승인 완료");
    }

    public void cancel (String reason) {
        System.out.println("[신용카드] " + this.amount + "원 결제 취소 - 사유: " + reason);
    }
}
