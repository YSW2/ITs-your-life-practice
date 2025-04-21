package ch06.sec08.ex02;

public class Computer {
    public Computer () {
    }

    public int sum (int... numbers) {
        int result = 0;

        for (int number : numbers) {
            result += number;
        }
        return result;
    }
}
