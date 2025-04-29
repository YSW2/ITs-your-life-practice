package ch13.quiz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class QuizMain {
    static String data = """
            초인종이 없을 때를 두 글자로 줄이면? - 노벨
            보라돌이 나나 뽀가 자기들끼리 식사할 때 두비가 하는 말은? - 뚜비두밥
            등산을 좋아하는 왕은? - 하이킹
            고등학생이 싫어하는 나무는? - 야자나무
            포도가 자기소개할 때 하는 말은? - 포도당
            신데렐라가 잠을 못 자면? - 모짜렐라
            <옷장 안에 불이 났다>를 다섯 글자로 하면? - 장안의 화재
            호랑이가 차를 타고 가다가 친구를 만나서 하는 말은? - 타이거
            몸이 아파도 반드시 가야 하는 대학교는? - 가야대
            인사하면서 웃으면? - 하이킥
            자동차를 톡하고 치면? - 카톡
            <이것이 코다>를 세 글자로 줄이면? - 디스코
            소녀가 강으로 여행을 가면? - 걸리버 여행
            소고기가 없는 나라는? - 소고기무국
            드라큘라가 가장 싫어하는 사람은? - 찔러도 피 안 나는 사람
            때돈을 버는 곳은? - 목욕탕
            자동차 키 색은? - 카키색
            해와 달 중, 해만 취재하는 사람은? - 해리포터
            입이 S자로 되어있으면? - EBS
            신문이 일하러 가면? - 일간신문
            """;

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        QuizLinkedList quizList = new QuizLinkedList();
        ArrayList<QuizNode> quizArray = new ArrayList<>();
        ArrayList<Integer> correctList = new ArrayList<>();
        ArrayList<Integer> failList = new ArrayList<>();
        String answer = "";

        for (String quizData : data.split("\n")) {
            String[] parsedQuiz = quizData.split(" - ");
            quizList.addLast(parsedQuiz[0], parsedQuiz[1]);
        }

        for (QuizNode quiz : quizList) {
            quizArray.add(quiz);
        }

        Collections.shuffle(quizArray);

        for (int i = 0; i < quizArray.size(); i++) {
            QuizNode quiz = quizArray.get(i);

            System.out.printf("[%d/%d] 문제: %s\n", i + 1, quizArray.size(), quiz.title);
            answer = sc.nextLine().trim();
            if (quiz.content.equals(answer.toUpperCase())) {
                System.out.println("정답입니다!");
                correctList.add(i);
            } else {
                System.out.println("오답입니다! (정답: " + quiz.content + ")");
                failList.add(i);
            }
            System.out.println();
        }

        System.out.println("=== 맞춘 문제 목록 ===");
        for (int index : correctList) {
            QuizNode quiz = quizArray.get(index);
            System.out.println("문제: " + quiz.title);
            System.out.println("정답: " + quiz.content);
            System.out.println();
        }

        System.out.println("=== 틀린 문제 목록 ===");
        for (int index : failList) {
            QuizNode quiz = quizArray.get(index);
            System.out.println("문제: " + quiz.title);
            System.out.println("정답: " + quiz.content);
            System.out.println();
        }

        System.out.println("=== 최종 결과 ===");
        System.out.printf("총 %d문제 중 %d문제 정답!\n", quizArray.size(), correctList.size());
        System.out.println("정답률: " + (int) ((((float) correctList.size() / (float) quizArray.size()) * 100)) + "%");

//        QuizLinkedList quizList = new QuizLinkedList();
//        // 문제들 추가 (addLast)
//        quizList.addLast("몸이 아파도 반드시 가야 하는 대학교는?", "가야대");
//        quizList.addLast("인사하면서 웃으면?", "하이킥");
//        // 맨 앞에 문제 추가 (addFirst)
//        quizList.addFirst("호랑이가 차를 타고 가다가 친구를 만나서 하는 말은?", "타이거");
//        // 1번 인덱스에 문제 추가 (addAt)
//        quizList.addAt(1, "자동차 키 색은?", "카키색");
//        // 리스트 출력
////        quizList.printAll();
//        Iterator<QuizNode> it1 = quizList.iterator();
//
//        System.out.println("=== 현재 도전할 문제 리스트 ===");
//        while (it1.hasNext()) {
//            QuizNode current = it1.next();
//            System.out.println("문제 제목: " + current.title);
//            System.out.println("문제 내용: " + current.content + "\n");
//        }
//
//        // 현재 문제 수 출력
//        System.out.println("=== 현재 문제 수 ===");
//        System.out.println(quizList.size());
//        System.out.println();
//        // 첫 번째 문제 삭제
//        quizList.removeFirst();
//        // 리스트 다시 출력
//        System.out.println("=== 첫 번째 문제 삭제 후 리스트 ===");
////        quizList.printAll();
//        Iterator<QuizNode> it2 = quizList.iterator();
//
//        System.out.println("=== 현재 도전할 문제 리스트 ===");
//        while (it2.hasNext()) {
//            QuizNode current = it2.next();
//            System.out.println("문제 제목: " + current.title);
//            System.out.println("문제 내용: " + current.content + "\n");
//        }
//
//        // 확장 for문을 이용한 문제 출력 (Iterator 사용)
//        System.out.println("=== 남은 문제 리스트 (확장 for문 사용) ===");
//        for (QuizNode node : quizList) {
//            System.out.println("문제 제목: " + node.title);
//            System.out.println("문제 내용: " + node.content);
//            System.out.println();
//        }
    }
}