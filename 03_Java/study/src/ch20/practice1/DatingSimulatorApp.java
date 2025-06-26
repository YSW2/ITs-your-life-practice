package ch20.practice1;

import java.util.ArrayList;
import java.util.Scanner;

public class DatingSimulatorApp {
    public static void main (String[] args) {
        ArrayList<DatingCharacter> characterList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int input;

        characterList.add(DatingCharacter.builder()
                .name("지민")
                .personality("다정하고 감성적임")
                .hobby("춤")
                .favoriteFood("떡볶이")
                .talkStyle("부드럽고 공손함")
                .typeCode("S").build());
        characterList.add(DatingCharacter.builder()
                .name("제니")
                .personality("도도하지만 배려심있음")
                .hobby("여행")
                .favoriteFood("파스타")
                .talkStyle("털털한 반말")
                .typeCode("T").build());
        characterList.add(DatingCharacter.builder()
                .name("태연")
                .personality("조용하지만 리더십있음")
                .hobby("독서")
                .favoriteFood("마라탕")
                .talkStyle("단호하지만 상냥함")
                .typeCode("C").build());

        System.out.println("\uD83D\uDC98 대화하고 싶은 캐릭터를 선택하세요:");
        for (int i = 0; i < characterList.size(); i++) {
            System.out.println(i + 1 + ". " + characterList.get(i));
        }
        input = sc.nextInt();
        DatingCharacter character = characterList.get(input - 1);

        if (character == null) {
            System.out.println("\"⚠\uFE0F 유효하지 않은 번호입니다.\"");
            return;
        }

        System.out.print("[" + character.getName() + "] ");
        
        if (character.getTalkStyle().contains("반말")) {
            System.out.println("뭐야~ 왜 이제 왔어?");
        } else if (character.getTalkStyle().contains("공손")) {
            System.out.println("오셨군요. 기다리고 있었어요.");
        } else if (character.getTalkStyle().contains("시크")) {
            System.out.println("왔네.");
        } else {
            System.out.println("안녕.");
        }

        System.out.println();
        System.out.println("\uD83D\uDC49 무엇을 말할까요?\n" +
                "1. 오늘 좀 바빴어\n" +
                "2. 보고 싶었어\n" +
                "3. 아무 말도 하지 않는다");

        input = sc.nextInt();

        System.out.print("[" + character.getName() + "] ");

        switch (input) {
            case 1 -> System.out.println("흐응~ 바빴구나. 알겠어.");
            case 2 -> System.out.println("진짜? 그 말 또 해줘 \uD83D\uDE0A");
            case 3 -> System.out.println("... (가만히 쳐다본다)");
            default -> System.out.println("응? 무슨 말이야?");
        }
    }
}
