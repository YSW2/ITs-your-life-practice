package ch09.practice;

public class MusicApp {
    private static final String user = "yura";

    public static void main (String[] args) {
        MusicApp.PlayerUI ui = new MusicApp.PlayerUI();
        ui.show();
    }

    public static class PlayerUI {
        public void show () {
            System.out.println("🎧 현재 사용자: " + user); // ❌ 컴파일 에러 발생
        }
    }
}
