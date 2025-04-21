package ch04.practice;

import java.util.Arrays;
import java.util.Scanner;

public class Ch08 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int selected;
        int[] scores = new int[0];

        do {
            System.out.println("---------------------------------------------------");
            System.out.println("1.학생 수 | 2.점수 입력 | 3.점수 리스트 | 4.분석 | 5.종료");
            System.out.println("---------------------------------------------------");
            System.out.print("선택> ");

            selected = sc.nextInt();

            switch (selected) {
                case 1 -> {
                    System.out.print("학생 수> ");
                    scores = new int[sc.nextInt()];
                }
                case 2 -> {
                    for (int i = 0; i < scores.length; i++) {
                        System.out.printf("scores[%d]> ", i);
                        scores[i] = sc.nextInt();
                    }
                }
                case 3 -> {
                    for (int i = 0; i < scores.length; i++) {
                        System.out.printf("scores[%d]> %d\n", i, scores[i]);
                    }
                }
                case 4 -> {
                    System.out.printf("최고 점수: %d\n", getHighScore(scores));
                    System.out.printf("평균 점수: %d\n", getAverage(scores));
                }
            }

        } while (selected != 5);
    }

    public static int getHighScore (int[] arr) {
        int highScore = 0;
        for (int score : arr) {
            if (score > highScore) {
                highScore = score;
            }
        }
        return highScore;
    }

    public static int getAverage (int[] arr) {
        return Math.round((float) Arrays.stream(arr).sum() / arr.length);
    }
}
