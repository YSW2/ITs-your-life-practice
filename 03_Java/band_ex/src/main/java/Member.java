public class Member extends BandComponent {
    private String name;
    private String mbti;
    private String position;
    private int energyLevel;

    public Member (String name, String mbti, String position, int energyLevel) {
        this.name = name;
        this.mbti = mbti;
        this.position = position;
        this.energyLevel = energyLevel;
    }

    @Override
    public String getName () {
        return name;
    }

    @Override
    public void perform () {
        String ment;

        if (energyLevel < 30) {
            ment = "\uD83D\uDE35 [" + mbti + "] " + name + ": 너무 지쳐서 공연을 못 하겠어요...";
        } else {
            switch (mbti) {
                case "ENFP" -> ment = "\uD83D\uDD25 [ENFP] " + name + ": 여러분 안녕!! 불태워볼까요?";
                case "ISTJ" -> ment = "\uD83E\uDDCA [ISTJ] " + name + ": 공연 시작합니다.";
                case "ISFP" -> ment = "\uD83C\uDF19 [ISFP] " + name + ": 조용히 시작해볼게요.";
                case "INTP" -> ment = "\uD83E\uDDE0 [INTP] " + name + ": 이 곡은 구조적으로 매우 완벽합니다.";
                case "ESFJ" -> ment = "\uD83D\uDC95 [ESFJ] " + name + ": 다들 잘 지냈죠? 오늘도 힘내요!";
                default -> ment = "\uD83C\uDFB6 [기타] " + name + ": 준비됐어요!";
            }
        }

        System.out.println(ment);
    }

    @Override
    public void printStructure (String prefix) {
        System.out.println(prefix + " \uD83C\uDFB8 " + position + " - " + name + " (" + mbti + ")");
    }
}
