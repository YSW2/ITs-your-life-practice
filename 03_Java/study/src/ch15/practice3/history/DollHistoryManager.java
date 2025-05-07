package ch15.practice3.history;

import java.util.*;

public class DollHistoryManager {
    Map<String, List<String>> historyMap = new HashMap<String, List<String>>();

    public void addHistory (String customer, String doll) {
        System.out.println("\uD83D\uDCD2 " + customer + " 님의 인형 기록에 '" + doll + "'이(가) 추가되었습니다.");

        if (historyMap.containsKey(customer)) {
            historyMap.get(customer).add(doll);
            return;
        }
        List<String> list = new ArrayList<>();
        list.add(doll);
        historyMap.put(customer, new ArrayList<>(list));
    }

    public void showAllHistory () {
        if (historyMap.isEmpty()) {
            System.out.println("📋 아직 기록된 고객이 없습니다.");
            return;
        }
        List<String> keySet = new ArrayList<>(historyMap.keySet());
        Collections.sort(keySet);

        for (String key : keySet) {
            System.out.println(key + ": [" + String.join(", ", historyMap.get(key)) + "]");
        }
    }

    public void showAllUniqueHistory () {
        for (String name : historyMap.keySet()) {
            Set<String> unique = new HashSet<>(historyMap.get(name));
            Iterator<String> it = unique.iterator();

            System.out.print(name + ": [");
            while (it.hasNext()) {
                System.out.print(it.next());
                if (it.hasNext()) System.out.print(", ");
            }
            System.out.println("]");
        }
    }
}
