package ch15.practice3.popularity;

import java.util.*;
import java.util.Map.Entry;

public class DollPopularityManager {
    private Map<String, Integer> countMap = new HashMap<>();

    public void addDoll (String dollName) {
        countMap.put(dollName, countMap.getOrDefault(dollName, 0) + 1);
    }

    public void showRanking () {
        if (countMap.isEmpty()) {
            System.out.println("\uD83D\uDCCA 아직 뽑힌 인형이 없습니다.");
        }
        List<Entry<String, Integer>> rankList = new ArrayList<>(countMap.entrySet());
        Collections.sort(rankList, new Comparator<Entry<String, Integer>>() {
            @Override
            public int compare (Entry<String, Integer> o1, Entry<String, Integer> o2) {
                int result = o2.getValue().compareTo(o1.getValue());
                if (result == 0) result = o1.getKey().compareTo(o2.getKey());
                return result;
            }
        });
        
        int index = 1;
        System.out.println("\uD83D\uDD25 인형별 인기 순위 (많이 뽑힌 순):");
        for (Entry<String, Integer> entry : rankList) {
            System.out.println(index++ + ". " + entry.getKey() + " : " + entry.getValue() + "회");
        }

    }
}
