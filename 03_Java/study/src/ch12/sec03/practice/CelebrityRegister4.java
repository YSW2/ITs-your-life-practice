package ch12.sec03.practice;

import java.util.Scanner;

public class CelebrityRegister4 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        Celebrity winner = null;
        String choice = "";
        MaleCelebrity[] maleCelebs = {
                new MaleCelebrity("박서준"),
                new MaleCelebrity("차은우"),
                new MaleCelebrity("정해인"),
                new MaleCelebrity("이도현"),
                new MaleCelebrity("송강"),
                new MaleCelebrity("김선호"),
                new MaleCelebrity("안효섭"),
                new MaleCelebrity("도경수"),
                new MaleCelebrity("임시완"),
                new MaleCelebrity("이준호")
        };

        FemaleCelebrity[] femaleCelebs = {
                new FemaleCelebrity("아이유"),
                new FemaleCelebrity("장원영"),
                new FemaleCelebrity("카리나"),
                new FemaleCelebrity("윈터"),
                new FemaleCelebrity("한소희"),
                new FemaleCelebrity("김세정"),
                new FemaleCelebrity("윤아"),
                new FemaleCelebrity("설현"),
                new FemaleCelebrity("제니"),
                new FemaleCelebrity("지수")
        };
        System.out.println("""
                === 이상형 월드컵 ===
                1. 남자 연예인 월드컵
                2. 여자 연예인 월드컵
                경기를 선택하세요:""");

        try {
            choice = sc.nextLine();
            if (!choice.equals("1") && !choice.equals("2"))
                throw new InvalidGenderException(">> 잘못된 선택입니다! 1 또는 2만 입력하세요.");

        } catch (InvalidGenderException e) {
            System.out.println(e.getMessage());
        }

        switch (choice) {
            case "1":
                MaleMatchGame maleGame = new MaleMatchGame(maleCelebs);
                maleGame.shuffle();
                System.out.println("[셔플 된 참가자 명단]");
                maleGame.printCandidates();
                winner = maleGame.playGame();
                break;
            case "2":
                FemaleMatchGame femaleGame = new FemaleMatchGame(femaleCelebs);
                System.out.println("[셔플 된 참가자 명단]");
                femaleGame.printCandidates();
                winner = femaleGame.playGame();
                break;
        }

        System.out.println("\uD83C\uDFC6 최종 우승자: " + winner.getName());
    }
}
