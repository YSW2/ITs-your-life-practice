package ch04.sec01;

public class random {
    public static void main(String[] args) {
        int domain = 5;
        int randomNumber = (int) (Math.random() * domain);

        System.out.println(randomNumber);
    }
}
