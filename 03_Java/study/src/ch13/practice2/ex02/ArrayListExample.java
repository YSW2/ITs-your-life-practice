package ch13.practice2.ex02;

import java.util.ArrayList;

public class ArrayListExample {
    public static void main (String[] args) {
        ArrayList<Board> boards = new ArrayList<>();

        Board board1 = new Board();
        board1.setSubject("안녕하세요!");
        board1.setContent("첫 번째 게시글입니다.");
        board1.setWriter("김철수");

        Board board2 = new Board();
        board2.setSubject("자바 프로그래밍 질문");
        board2.setContent("자바에서 Set과 HashSet의 차이가 뭔가요?");
        board2.setWriter("이영희");

        Board board3 = new Board();
        board3.setSubject("오늘의 날씨");
        board3.setContent("오늘은 맑고 화창한 날씨입니다.");
        board3.setWriter("박지민");

        Board board4 = new Board();
        board4.setSubject("프론트엔드 스터디 모집");
        board4.setContent("React와 TypeScript를 함께 공부할 스터디원을 모집합니다.");
        board4.setWriter("최동욱");

        Board board5 = new Board();
        board5.setSubject("주말 여행 추천");
        board5.setContent("이번 주말에 가기 좋은 국내 여행지 추천해주세요!");
        board5.setWriter("정수진");

        boards.add(board1);
        boards.add(board2);
        boards.add(board3);
        boards.add(board4);
        boards.add(board5);

        System.out.println(boards.size());
        System.out.println(boards.get(2));

        for (int i = 0; i < boards.size(); i++) {
            System.out.println(boards.get(i));
        }

        boards.remove(2);
        boards.remove(2);

        for (Board board : boards) {
            System.out.println(board);
        }
    }
}