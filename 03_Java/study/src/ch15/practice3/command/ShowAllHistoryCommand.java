package ch15.practice3.command;

import ch15.practice3.history.DollHistoryManager;

public class ShowAllHistoryCommand implements Command {
    private DollHistoryManager historyManager;

    public ShowAllHistoryCommand (DollHistoryManager historyManager) {
        this.historyManager = historyManager;
    }

    @Override
    public void execute () {
        historyManager.showAllHistory();
    }
}
