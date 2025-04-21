package ch04.practice;

import java.util.Arrays;

public class Ch06 {
    public static void main (String[] args) {
        int answer = 0;
        int count = 0;

        int[][] array = {
                {95, 86},
                {83, 92, 96},
                {78, 83, 93, 87, 88}
        };

        for (int[] ints : array) {
            answer += Arrays.stream(ints).sum();
            count += ints.length;
        }

        System.out.printf("합계: %d\n", answer);
        System.out.printf("평균: %.1f\n", (float) answer / count);
    }
}
