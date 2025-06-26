package ch20.practice1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CharacterRecommender {
    public static void main (String[] args) {
        Map<String, DatingCharacter> recommendList = new HashMap<String, DatingCharacter>();
        Scanner sc = new Scanner(System.in);

        recommendList.put("도도함", DatingCharacter.builder()
                .name("제니")
                .personality("도도하지만 배려심있음")
                .hobby("여행")
                .favoriteFood("파스타")
                .talkStyle("털털함")
                .build());
        recommendList.put("다정함", DatingCharacter.builder()
                .name("지민")
                .personality("다정하고 감성적임")
                .hobby("춤")
                .favoriteFood("떡볶이")
                .talkStyle("부드럽고 공손함").build());
        recommendList.put("조용함", DatingCharacter.builder()
                .name("태연")
                .personality("조용하지만 리더십있음")
                .hobby("독서")
                .favoriteFood("마라탕")
                .talkStyle("단호하지만 상냥함").build());

        System.out.println("어떤 성격의 캐릭터를 선호하시나요?");
        System.out.println("→ 다정함 / 도도함 / 조용함 중 하나를 입력해주세요.");
        System.out.print("입력: ");
        String input = sc.nextLine();
        DatingCharacter result = recommendList.get(input);

        if (result == null) {
            System.out.println("해당 스타일의 캐릭터는 준비 중입니다.");
        } else {
            System.out.println(result);
        }
    }
}
