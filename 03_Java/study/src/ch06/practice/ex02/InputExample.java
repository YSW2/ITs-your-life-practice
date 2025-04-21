package ch06.practice.ex02;

public class InputExample {
    public static void main (String[] args) {
        Input input = new Input();
        String line;
        int age;
        boolean close;

        line = input.read("이름: ");
        System.out.println("입력값: " + line);

        line = input.read("이름: ", "홍길동");
        System.out.println("입력값: " + line);

        age = input.readInt("나이: ");
        System.out.println("입력값: " + age);

        close = input.confirm("종료할까요? ");
        System.out.println("입력값: " + close);

        close = input.confirm("종료할까요? ");
        System.out.println("입력값: " + close);
    }
}
