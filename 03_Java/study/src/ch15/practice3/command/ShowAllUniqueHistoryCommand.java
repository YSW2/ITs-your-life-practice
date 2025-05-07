package ch15.practice3.command;

import ch15.practice3.history.DollHistoryManager;

public class ShowAllUniqueHistoryCommand implements Command {
    private DollHistoryManager historyManager;

    public ShowAllUniqueHistoryCommand (DollHistoryManager historyManager) {
        this.historyManager = historyManager;
    }

    @Override
    public void execute () {
        historyManager.showAllUniqueHistory();
    }
}
