package ch04.practice;

public class Ch01 {
    public static void main(String[] args) {
        int answer = 0;

        for (int i = 0; i <= 100; i++) {
            if (i % 3 == 0) answer += i;
        }

        System.out.println(answer);
    }
}
