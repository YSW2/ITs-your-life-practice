package ch14.sec01.practice02;

public class RegularBuyer implements TicketBuyer {
    @Override
    public void waitTurn () throws InterruptedException {
        Thread.sleep(100);
    }

    @Override
    public void entranceMessage (String name) {
        System.out.println(name + " 입장 완료!");
    }

    @Override
    public void buyTicket () {

    }
}
