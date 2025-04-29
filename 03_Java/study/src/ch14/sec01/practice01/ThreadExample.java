package ch14.sec01.practice01;

public class ThreadExample {
    public static void main (String[] args) {
        Thread task1 = new Thread(new MusicRunnable());
        Thread task2 = new Thread(new MovieThread());

        task1.start();
        task2.start();
    }
}
