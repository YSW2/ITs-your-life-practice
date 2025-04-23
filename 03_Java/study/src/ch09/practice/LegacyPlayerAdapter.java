package ch09.practice;

public class LegacyPlayerAdapter implements Playable {
    LegacyPlayer legacyPlayer;

    LegacyPlayerAdapter (LegacyPlayer legacyPlayer) {
        this.legacyPlayer = legacyPlayer;
    }

    @Override
    public void play (String title) {
        this.legacyPlayer.startPlay(title);
    }
}
