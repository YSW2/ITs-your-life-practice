package ch14.sec01.practice02;

public class SlowBuyer implements TicketBuyer {
    @Override
    public void waitTurn () throws InterruptedException {
        Thread.sleep(200);
    }

    @Override
    public void entranceMessage (String name) {
        System.out.println(name + ": 처음이라 떨려요... 입장 완료!");
    }

    @Override
    public void buyTicket () {

    }
}
