package ch12.sec03.practice;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class CelebrityRegister {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 0;
        String name = "";
        ArrayList<Celebrity> maleNameList = new ArrayList<>();
        ArrayList<Celebrity> femaleNameList = new ArrayList<>();

        try {
            System.out.print("남자 연예인 몇 명 등록할까요? ");
            count = sc.nextInt();
            sc.nextLine();

            int i = 0;
            while (i < count) {
                System.out.print("이름 입력: ");
                name = sc.nextLine();

                if (isValid(name)) {
                    if (!isDuplicate(maleNameList, new MaleCelebrity(name))) {
                        System.out.println(">> 중복된 이름입니다. 등록하지 않습니다.");
                        continue;
                    }
                    maleNameList.add(new MaleCelebrity(name));
                    i += 1;
                }
            }

            System.out.print("여자 연예인 몇 명 등록할까요? ");
            count = sc.nextInt();
            sc.nextLine();

            i = 0;
            while (i < count) {
                System.out.print("이름 입력: ");
                name = sc.nextLine();

                if (isValid(name)) {
                    if (!isDuplicate(femaleNameList, new FemaleCelebrity(name))) {
                        System.out.println(">> 중복된 이름입니다. 등록하지 않습니다.");
                        continue;
                    }
                    femaleNameList.add(new FemaleCelebrity(name));
                    i += 1;
                }
            }
        } catch (InvalidNameException e) {
            System.err.println("😡 탈락! 잘못된 이름입니다: " + e.getMessage());
        }

        System.out.println("[남자 연예인 리스트]");
        for (Celebrity c : maleNameList) {
            System.out.println("남자 연예인: " + c.getName());
        }

        System.out.println("[여자 연예인 리스트]");
        for (Celebrity c : femaleNameList) {
            System.out.println("여자 연예인: " + c.getName());
        }
    }

    public static boolean isValid (String name) throws InvalidNameException {
        if (!Pattern.matches("^[가-힣]{2,10}$", name)) {
            throw new InvalidNameException("이름은 한글 2~10자여야 합니다!");
        }
        return true;
    }

    public static boolean isDuplicate (ArrayList<Celebrity> nameList, Celebrity celebrity) {
        for (Celebrity c : nameList) {
            if (c.equals(celebrity)) return false;
        }
        return true;
    }
}
