package ch12.sec03.practice;

import java.util.Scanner;
import java.util.regex.Pattern;

public class CelebrityRegister3 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String choice = "";
        MaleCelebrity[] maleCelebs = {
                new MaleCelebrity("박서준"),
                new MaleCelebrity("차은우"),
                new MaleCelebrity("정해인")
        };

        FemaleCelebrity[] femaleCelebs = {
                new FemaleCelebrity("아이유"),
                new FemaleCelebrity("장원영")
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

            if (!Pattern.matches("[0-9]", choice))
                throw new InvalidGenderException(">> 숫자만 입력하세요! (1 또는 2)");

        } catch (InvalidGenderException e) {
            System.out.println(e.getMessage());
        }

        switch (choice) {
            case "1":
                MaleMatchGame maleGame = new MaleMatchGame(maleCelebs);
                maleGame.printCandidates();
                break;
            case "2":
                FemaleMatchGame femaleGame = new FemaleMatchGame(femaleCelebs);
                femaleGame.printCandidates();
                break;
        }
    }
}
