package ch14.sec01.practice02;

import java.util.ArrayList;
import java.util.List;

public class TicketingRound3 {
    public static void main (String[] args) {
        EntryManager entryManager = new EntryManager(5);
        List<Thread> threads = new ArrayList<>();
        Thread noticeThread = new Thread(new Runnable() {
            @Override
            public void run () {
                try {
                    System.out.println("[공지] 남은 티켓: " + entryManager.getTicketCount() + "장");
                    Thread.sleep(3000);
                    System.out.println("[공지] 남은 티켓: " + entryManager.getTicketCount() + "장");
                    Thread.sleep(3000);
                    System.out.println("[공지] 모든 티켓이 소진되었습니다. 공지 스레드 종료.");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        });

        Fan[] fans = {
                new Fan("팬1", false, entryManager, new RegularBuyer()),
                new Fan("팬2", true, entryManager, new VIPBuyer()),
                new Fan("팬3", false, entryManager, new RegularBuyer()),
                new Fan("팬4", true, entryManager, new VIPBuyer()),
                new Fan("팬5", false, entryManager, new SlowBuyer())
        };

        noticeThread.setDaemon(true);
        noticeThread.start();

        for (Fan fan : fans) {
            Thread thread = new Thread(fan);
            if (fan.isVIP()) thread.setPriority(Thread.MAX_PRIORITY);
            thread.start();
            threads.add(thread);
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("이벤트 종료! 모두 수고하셨습니다 🎉" );
    }
}
