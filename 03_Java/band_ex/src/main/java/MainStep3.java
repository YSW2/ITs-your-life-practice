public class MainStep3 {
    public static void main (String[] args) {
        Band band = new Band("DreamStage");
        Band subband = new Band("스윗즈");

        Member zero = new Member("제로비트", "ENFP", "Vocal", 85);
        Member mint = new Member("민트초코", "ISTJ", "Guitar", 90);
        Member ai = new Member("아이시스", "ISFP", "Keyboard", 25);
        Member dongle = new Member("동글몽", "INTP", "Drums", 70);

        band.add(zero);

        subband.add(mint);
        subband.add(ai);
        subband.add(dongle);

        band.add(subband);

        band.printStructure("|-");
        System.out.println("\n[공연 시작]");
        band.perform();
    }
}