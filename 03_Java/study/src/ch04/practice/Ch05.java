package ch04.practice;

public class Ch05 {
    public static void main(String[] args) {
        int[] array = {1, 5, 3, 8, 2};
        int answer = 0;

        for (int num : array) {
            answer = Math.max(answer, num);
        }

        System.out.println(answer);
    }
}
