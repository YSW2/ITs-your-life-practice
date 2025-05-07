package ch15.practice3.command;

import ch15.practice3.history.DollHistoryManager;
import ch15.practice3.popularity.DollPopularityManager;
import ch15.practice3.queue.DollQueueManager;
import ch15.practice3.stack.DollStackManager;

import java.util.Scanner;

public class PickDollCommand implements Command {

    private DollQueueManager queueManager;
    private DollStackManager stackManager;
    private DollHistoryManager historyManager;
    private DollPopularityManager popularityManager;

    public PickDollCommand (DollStackManager stackManager, DollHistoryManager historyManager, DollPopularityManager popularityManager, DollQueueManager queueManager) {
        this.stackManager = stackManager;
        this.historyManager = historyManager;
        this.popularityManager = popularityManager;
        this.queueManager = queueManager;
    }

    @Override
    public void execute () {
        Scanner sc = new Scanner(System.in);
        String nextCustomer = queueManager.getNextCustomer();
        if (nextCustomer != null) {
            String doll = stackManager.storeRandomDoll();
            historyManager.addHistory(nextCustomer, doll);
            popularityManager.addDoll(doll);
            System.out.print("\uD83D\uDC49 " + nextCustomer + " 님, 한 번 더 뽑으시겠습니까? (y/n): ");
            String choice = sc.next();
            if (choice.toLowerCase().equals("y")) {
                queueManager.registerCustomer(nextCustomer);
                System.out.println("\uD83D\uDD01 " + nextCustomer + " 님이 다시 대기열에 등록되었습니다.");
            }
        }
    }
}
