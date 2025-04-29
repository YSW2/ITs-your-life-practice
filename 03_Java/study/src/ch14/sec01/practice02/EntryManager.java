package ch14.sec01.practice02;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class EntryManager {
//    private Stack<Fan> vipStack = new Stack<>();
    private Queue<Fan> normalQueue = new LinkedList<>();

    public int getTicketCount () {
        return ticketCount;
    }

    public void printQueue () {
        System.out.println(normalQueue);
    }
    private int ticketCount;

    public EntryManager(int ticketCount) {
        this.ticketCount = ticketCount;
    }

    void registerFan(Fan fan) {
        normalQueue.offer(fan);
    }

    synchronized boolean processEntry(Fan fan) {
        if (normalQueue.isEmpty()) {return false;}
        if (fan.isVIP() || normalQueue.peek() == fan) {
            Fan enterFan = normalQueue.poll();
            ticketCount--;
            enterFan.getBuyer().entranceMessage(enterFan.getName());
            return true;
        }
        return false;
    }
}
