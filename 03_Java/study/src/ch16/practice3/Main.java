package ch16.practice3;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Function;

public class Main {
//    static List<Goods> giftPool = Arrays.asList(
//            new Goods("메타몽 쿠션", "분홍", false),
//            new Goods("메타몽 키링", "파랑", false),
//            new Goods("메타몽 텀블러", "보라", true),
//            new Goods("메타몽 노트북 파우치", "회색", true),
//            new Goods("메타몽 인형", "분홍", false),
//            new Goods("메타몽 가방", "회색", true)
//    );
//    static List<Goods> goodsList = Arrays.asList(
//            new Goods("메타몽 쿠션", "분홍", false),
//            new Goods("메타몽 노트북 파우치", "보라", true),
//            new Goods("메타몽 인형", "분홍", false),
//            new Goods("메타몽 가방", "회색", true),
//            new Goods("메타몽 키링", "파랑", false)
//    );

    public static Set<String> keywords = new HashSet<>(Arrays.asList("미안", "사랑", "소중", "고마워", "행복", "고맙", "영원", "믿어"));
    public static List<String> lines = Arrays.asList("지우|이슬이|오늘 말 심했지? 정말 미안해. 널 제일 소중하게 생각해.",
            "이슬이|지우|메타몽처럼 말랑말랑해질게. 나도 고마워 :)",
            "웅이|이슬이|사랑해. 영원히 같이 있고 싶어.",
            "지우|웅이|게임은 내가 이겼지롱~");

    public static void main (String[] args) {
//        printSelectedGoods("이슬이", goods -> goods.getColor().equals("분홍"));
//        System.out.println();
//        printSelectedGoods("지우", Goods::isUseful);

//        List<Goods> pickList = pickGifts(giftPool);
//        printResult("이슬이", pickList, gift -> gift.getColor().equals("분홍"), "→ 성공! 분홍색 굿즈를 얻었어요! \uD83C\uDF89", "→ 실패! 분홍색 굿즈가 없어요 \uD83D\uDE22");
//        System.out.println();
//        pickList = pickGifts(giftPool);
//        printResult("지우", pickList, Goods::isUseful, "→ 성공! 유용한 굿즈를 얻었어요! \uD83C\uDF89", "→ 실패! 유용한 굿즈가 없어요 \uD83D\uDE22");

//        PhotoAlbum photoAlbum = new PhotoAlbum();
//        Consumer<Photo> consumer = System.out::println;
//        Photo photo1 = new Photo("지우", "브이✌\uFE0F");
//        Photo photo2 = new Photo("이슬이", "하트❤\uFE0F");
//        Photo photo3 = new Photo("웅이", "메타몽 모자\uD83C\uDFA9");
//
//        System.out.println("[\uD83D\uDCF8 사진 촬영 중...]");
//        photoAlbum.addPhoto(photo1, consumer);
//        photoAlbum.addPhoto(photo2, consumer);
//        photoAlbum.addPhoto(photo3, consumer);
//
//        System.out.println();
//        System.out.println("[\uD83D\uDCE4 SNS에 업로드된 사진 목록]");
//        photoAlbum.printFiltered(photo -> photo.getPose().equals("하트❤\uFE0F"), consumer);

//        List<Goods> goodsList1 = new ArrayList<>();
//        goodsList1.add(new Goods("메타몽 쿠션", 20000, 0.1));
//        goodsList1.add(new Goods("메타몽 키링", 8000, 0.05));
//        goodsList1.add(new Goods("메타몽 인형", 15000, 0.2));
//
//        List<Goods> goodsList2 = new ArrayList<>();
//        goodsList2.add(new Goods("메타몽 노트북 파우치", 30000, 0.2));
//        goodsList2.add(new Goods("메타몽 가방", 40000, 0.2));
//
//        printGoods("이슬이", goodsList1, Goods::getDiscountedPrice, Integer::sum);
//        System.out.println();
//        printGoods("지우", goodsList2, Goods::getDiscountedPrice, Integer::sum);

        List<Message> messageList = new ArrayList<>();
        List<Integer> scoreList = new ArrayList<>();

        for (String line : lines) {
            messageList.add(getNewMessage(line, Message::new));
        }


        for (Message message : messageList) {
            scoreList.add(calcScore(message, t -> {
                int score = 0;
                for (String keyword : keywords) {
                    if (t.getContent().indexOf(keyword) != -1) {
                        score += 30;
                    }
                }
                return Math.min(score, 100);
            }));
        }

        System.out.println("\uD83D\uDCEE 메타몽 편지함 - 진심 메시지만 공개됩니다 \uD83D\uDC8C\n");
        printScore(messageList, scoreList, (a, b) -> System.out.println(a + "✅ 감성 점수: " + b + "\n"));
    }

//    public static void printSelectedGoods (String user, Predicate<Goods> filter) {
//        System.out.println("[" + user + "의 선택]");
//        for (Goods goods : goodsList) {
//            if (filter.test(goods)) {
//                System.out.println("- " + goods.getName());
//            }
//        }
//    }

//    public static List<Goods> pickGifts (List<Goods> pool) {
//        List<Goods> result = new ArrayList<>();
//        int randomIndex;
//
//        for (int i = 0; i < 2; i++) {
//            randomIndex = (int) (Math.random() * pool.size());
//            result.add(pool.get(randomIndex));
//            pool.remove(randomIndex);
//        }
//
//        return result;
//    }

//    public static void printResult (String user, List<Goods> picks, Predicate<Goods> condition, String successMsg, String failMsg) {
//        System.out.println("[" + user + "의 뽑기 결과]");
//
//        for (Goods pick : picks) {
//            System.out.println("- " + pick.getName() + "(" + pick.getColor() + ")");
//        }
//        boolean result = picks.stream().anyMatch(condition);
//
//        if (result) {
//            System.out.println(successMsg);
//        } else {
//            System.out.println(failMsg);
//        }
//    }

//    public static void printGoods (String user, List<Goods> goodsList, ToIntFunction<Goods> function, BinaryOperator<Integer> operator) {
//        int total = 0;
//
//        System.out.println("[" + user + "의 장바구니]");
//        for (Goods goods : goodsList) {
//            System.out.println("- " + goods.getName() + ": " + goods.getPrice() + "원");
//            total = operator.apply(function.applyAsInt(goods), total);
//        }
//
//        System.out.println("총합: " + total + "원");
//    }

    public static Message getNewMessage (String line, Function<String, Message> function) {
        return function.apply(line);
    }

    public static int calcScore (Message message, Function<Message, Integer> function) {
        return function.apply(message);
    }

    public static void printScore (List<Message> messageList, List<Integer> scoreList, BiConsumer<Message, Integer> consumer) {
        for (int i = 0; i < messageList.size(); i++) {
            Message message = messageList.get(i);
            int score = scoreList.get(i);

            if (score >= 60) {
                consumer.accept(message, score);
            }
        }
    }
}
