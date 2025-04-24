package ch12.sec03.practice;

import java.util.Arrays;

public class MaleMatchGame extends MatchGame {

    public MaleMatchGame (Celebrity[] candidates) {
        this.candidates = Arrays.copyOf(candidates, candidates.length);
    }

    @Override
    public void initializeCandidates () {

    }

    public Celebrity playGame () {
        return super.playGame(candidates);
    }

    public void printCandidates () {
        System.out.println("[남자 연예인 월드컵 참가자 명단]");
        super.printCandidates(candidates);
    }


    public void shuffle () {
        super.shuffle(this.candidates);
    }
}
