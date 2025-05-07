package ch15.practice3.stack;

import java.util.Stack;

public class DollStackManager {
    Stack<String> stack = new Stack<>();
    String dolls = "피카츄, 리자몽, 꼬부기, 쿠로미, 헬로키티, 뽀로로, 짱구, 도라에몽, 스폰지밥, 미니언";

    public String storeRandomDoll () {
        String[] dollList = dolls.split(", ");
        int randomIndex = (int) (Math.random() * dollList.length);
        String randomDoll = dollList[randomIndex];

        stack.push(randomDoll);
        return randomDoll;
    }

    public void showStack () {
        if (stack.isEmpty()) {
            System.out.println("인형이 없습니다.");
            return;
        }
        System.out.println(String.join(", ", stack));
    }
}
