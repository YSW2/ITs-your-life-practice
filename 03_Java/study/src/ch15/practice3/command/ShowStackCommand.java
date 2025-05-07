package ch15.practice3.command;

import ch15.practice3.stack.DollStackManager;

public class ShowStackCommand implements Command {
    private DollStackManager stackManager;

    public ShowStackCommand (DollStackManager stackManager) {
        this.stackManager = stackManager;
    }

    @Override
    public void execute () {
        stackManager.showStack();
    }
}
