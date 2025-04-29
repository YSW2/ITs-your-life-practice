package ch14.sec01.practice02;

import java.util.ArrayList;

public class FestivalTicketEvent extends AbstractTicketEvent{
    public FestivalTicketEvent (int ticketCount) {
        super(ticketCount);
    }

    @Override
    protected void fanEntry () {
        ArrayList<Thread> fans = new ArrayList<>();

        for (int i = 0; i < ticketCount; i++) {
            Thread newThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " 티켓 구매 시도중!");
                }
            });
            newThread.setName("팬" + (i + 1));
            fans.add(newThread);
        }

        for (Thread thread : fans) {
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
