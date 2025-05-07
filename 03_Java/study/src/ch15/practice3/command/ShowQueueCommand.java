package ch15.practice3.command;

import ch15.practice3.queue.DollQueueManager;

public class ShowQueueCommand implements Command {
    private DollQueueManager queueManager;

    public ShowQueueCommand (DollQueueManager queueManager) {
        this.queueManager = queueManager;
    }

    @Override
    public void execute () {
        queueManager.showWaitingList();
    }
}
