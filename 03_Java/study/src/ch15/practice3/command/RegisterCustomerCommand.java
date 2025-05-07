package ch15.practice3.command;

import ch15.practice3.queue.DollQueueManager;
import ch15.practice3.util.RandomCustomerProvider;

public class RegisterCustomerCommand implements Command {
    private DollQueueManager queueManager;

    public RegisterCustomerCommand (DollQueueManager queueManager) {
        this.queueManager = queueManager;
    }

    @Override
    public void execute () {
        String name = RandomCustomerProvider.getRandomCustomer();
        queueManager.registerCustomer(name);
    }
}