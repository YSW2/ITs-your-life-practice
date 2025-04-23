package ch09.practice;

public class GenrePlaybackManager {
    public interface GenrePlayer {
        public void play(String title, String artist);  // 전략에 따른 재생 실행
    }

    private GenrePlayer player;

    public void setPlayer (GenrePlayer player) {
        this.player = player;
    }

    public void play (String title, String artist) {
        if (player == null) {
            System.out.println("❌ 재생 전략이 설정되지 않았습니다.");
            return;
        }
        player.play(title, artist);
    }
}
