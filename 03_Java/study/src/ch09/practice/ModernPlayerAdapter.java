package ch09.practice;

public class ModernPlayerAdapter implements Playable{
    ModernPlayer modernPlayer;

    ModernPlayerAdapter (ModernPlayer modernPlayer) {
        this.modernPlayer = modernPlayer;
    }

    @Override
    public void play (String title) {
        if (title.contains("bad")) {
            System.out.println("\uD83D\uDEAB 금지어가 포함된 곡은 재생할 수 없습니다: " + title);
            return;
        }
        this.modernPlayer.begin(title);
    }
}
