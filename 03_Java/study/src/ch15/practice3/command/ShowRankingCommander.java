package ch15.practice3.command;

import ch15.practice3.popularity.DollPopularityManager;

public class ShowRankingCommander implements Command {
    private DollPopularityManager popularityManager;

    public ShowRankingCommander (DollPopularityManager popularityManager) {
        this.popularityManager = popularityManager;
    }

    @Override
    public void execute () {
        popularityManager.showRanking();
    }
}
