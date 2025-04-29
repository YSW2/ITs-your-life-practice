package ch14.sec01.practice02;

public class VIPBuyer implements TicketBuyer {
    @Override
    public void waitTurn () throws InterruptedException {
        Thread.sleep(10);
    }

    @Override
    public void entranceMessage (String name) {
        System.out.println("VIP " + name + " 입장 완료!");
    }

    @Override
    public void buyTicket () {

    }
}
