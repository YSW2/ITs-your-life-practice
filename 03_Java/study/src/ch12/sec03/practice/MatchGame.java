package ch12.sec03.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public abstract class MatchGame implements VsSelectable {
    protected Celebrity[] candidates;

    public abstract void initializeCandidates ();


    @Override
    public Celebrity selectWinner (Celebrity c1, Celebrity c2) {
        Scanner sc = new Scanner(System.in);
        String choice = "";
        Celebrity winner = null;

        System.out.print("1. " + c1.getName() + "\n2. " + c2.getName() + "\n선택: ");

        while (true) {
            try {
                choice = sc.nextLine();
                if (!choice.equals("1") && !choice.equals("2"))
                    throw new InvalidGenderException(">> 잘못된 선택입니다! 1 또는 2만 입력하세요.");
                break;
            } catch (InvalidGenderException e) {
                System.out.println(e.getMessage());
            }
        }

        winner = switch (choice) {
            case "1" -> {
                System.out.println("[" + c1.getName() + " 승리!]");
                yield c1;
            }
            case "2" -> {
                System.out.println("[" + c2.getName() + " 승리!]");
                yield c2;
            }
            default -> winner;
        };

        return winner;
    }


    public Celebrity playGame (Celebrity[] candidates) {
        Celebrity[] roundList = Arrays.copyOf(candidates, candidates.length);
        int round = 1;

        while (roundList.length > 1) {
            ArrayList<Celebrity> tempList = new ArrayList<Celebrity>();

            System.out.println("=== " + round + "라운드 ===");
            for (int i = 0; i < roundList.length - 1; i += 2) {
                System.out.println("누가 더 이상형인가요?");
                tempList.add(selectWinner(roundList[i], roundList[i + 1]));
            }

            if (roundList.length % 2 != 0) {
                System.out.println(roundList[roundList.length - 1].getName() + "은(는) 자동으로 다음 라운드 진출!");
                tempList.add(roundList[roundList.length - 1]);
            }//부전승

            roundList = tempList.toArray(new Celebrity[tempList.size()]);
            round += 1;
        }
        return roundList[0];
    }

    public void printCandidates (Celebrity[] candidates) {
        for (Celebrity c : candidates) {
            System.out.println(c.toString());
        }
    }

    public void shuffle (Celebrity[] candidates) {
        Random rand = new Random();

        for (int i = candidates.length - 1; i > 0; i--) {
            int newIndex = rand.nextInt(i + 1);
            Celebrity temp = candidates[newIndex];
            candidates[newIndex] = candidates[i];
            candidates[i] = temp;
        }
    }
}
