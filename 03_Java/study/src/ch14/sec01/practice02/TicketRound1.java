package ch14.sec01.practice02;

public class TicketRound1 {
    public static void main (String[] args) {
        Thread fan1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " 티켓 구매 시도중!");

            }
        });

        Thread fan2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " 티켓 구매 시도중!");
            }
        });

        fan1.setName("팬1");
        fan2.setName("팬2");

        System.out.println("=== run() 직접 호출 테스트 ===");
        fan1.run();
        fan1.start();

        fan2.run();
        fan2.start();
    }
}
