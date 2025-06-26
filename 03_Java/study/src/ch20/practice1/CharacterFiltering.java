package ch20.practice1;

import java.util.ArrayList;
import java.util.Scanner;

public class CharacterFiltering {
    public static void main (String[] args) {
        ArrayList<CharacterType> characterList = new ArrayList<CharacterType>();
        Scanner sc = new Scanner(System.in);

        characterList.add(DatingCharacter.builder()
                .name("제니")
                .personality("도도하지만 배려심있음")
                .typeCode("C")
                .build());
        characterList.add(DatingCharacter.builder()
                .name("지민")
                .personality("다정하고 감성적임")
                .typeCode("S")
                .build());
        characterList.add(DatingCharacter.builder()
                .name("수지")
                .personality("순수한 첫사랑 느낌")
                .typeCode("S")
                .build());
        characterList.add(DatingCharacter.builder()
                .name("민호")
                .personality("무뚝뚝한 츤데레")
                .typeCode("T")
                .build());
        characterList.add(DatingCharacter.builder()
                .name("태연")
                .personality("조용하지만 리더십 있음")
                .typeCode("T")
                .build());

        System.out.println("\uD83D\uDC98 어떤 유형의 캐릭터를 보고 싶나요?");
        System.out.println("→ S (순수형), T (츤데레형), C (차도남/차도녀형)");
        System.out.print("입력: ");
        String input = sc.nextLine();


        characterList.stream().filter(characterType -> characterType.getTypeCode().equals(input))
                .forEach(System.out::println);
    }
}
