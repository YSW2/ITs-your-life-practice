package ch17.sec12;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectExample {
    public static void main (String[] args) {
        List<Student> totalList = new ArrayList<>();
        totalList.add(new Student("홍길동", "남", 92));
        totalList.add(new Student("김수영", "여", 87));
        totalList.add(new Student("감자바", "남", 95));
        totalList.add(new Student("오해영", "여", 93));
//        Map<String, Double> map = totalList.stream()
//                .collect(
//                        Collectors.groupingBy(
//                                s -> s.getSex(),
//                                Collectors.averagingDouble(s -> s.getScore())
//                        )
//                );
//        System.out.println(map);
//
//        List<Student> maleList = totalList.stream().filter(s -> s.getSex().equals("남")).collect(Collectors.toList());
//        System.out.println(maleList);
//
//        List<Student> sortedList = totalList.stream().sorted((a, b) -> b.getScore() - a.getScore()).limit(2).toList();
//        sortedList.forEach(System.out::println);

        Map<String, Integer> map = totalList.stream().collect(Collectors.toMap(s -> s.getName(), s -> s.getScore()));
        System.out.println(map);
    }

}