package ch15.practice3.queue;

import java.util.LinkedList;
import java.util.Queue;

public class DollQueueManager {
    Queue<String> queue = new LinkedList<String>();

    public void registerCustomer (String name) {
        queue.add(name);
        System.out.println("\uD83D\uDC49 " + name + " 님이 대기열에 등록되었습니다.");
    }

    public String getNextCustomer () {
        if (queue.isEmpty()) {
            System.out.println("⛔ 대기 중인 고객이 없습니다.");
            return null;
        }
        String customer = queue.remove();
        System.out.println("\uD83C\uDF89" + customer + " 님! 인형 뽑기 하러 오세요!");
        return customer;
    }

    public void showWaitingList () {
        System.out.println("현재 대기열: [" + String.join(", ", queue) + "]");
    }
}
