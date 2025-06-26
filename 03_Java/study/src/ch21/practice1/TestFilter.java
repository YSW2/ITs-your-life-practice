package ch21.practice1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TestFilter {
    public static void main (String[] args) {
        Map<String, FilterStrategy> filterList = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        String inputFilter;
        String inputString;
        FilterStrategy selectedFilter = null;

        filterList.put("smooth", new SmoothSkinFilter());
        filterList.put("cute", new CuteEyesFilter());
        filterList.put("kawaii", new KawaiiFilter());

        System.out.println("\uD83D\uDCF8 AI 필터 엔진에 오신 걸 환영합니다!");
        System.out.println("✨ 사용할 필터를 선택해주세요 (smooth, cute, kawaii, exit)\n");

        while (true) {
            System.out.print(">> 적용할 필터 입력: ");
            inputFilter = sc.nextLine().toLowerCase();

            if (inputFilter.equals("exit")) break;
            else if (!filterList.containsKey(inputFilter)) {
                System.out.println("⚠\uFE0F 존재하지 않는 필터입니다. 다시 입력해주세요.\n");
                continue;
            }

            System.out.print(">> 사진 입력: ");
            inputString = sc.nextLine();

            selectedFilter = filterList.get(inputFilter);

            System.out.println("[사용 필터: " + inputFilter + "] => " + selectedFilter.apply(inputString) + "\n");
        }

        System.out.println("\uD83D\uDCF8 필터 부스를 종료합니다. 안녕히 가세요!");
    }
}