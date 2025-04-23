package ch09.practice;

public class MusicPractice {
    public static void main(String[] args) {
        PlaybackLogger logger = new PlaybackLogger();

        logger.log("사건의 지평선", "윤하");
        logger.log("오늘만 I LOVE YOU", "BOYNEXTDOOR");
        logger.log("Ditto", "NewJeans");
    }
}
