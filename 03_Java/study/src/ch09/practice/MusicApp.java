package ch09.practice;

public class MusicApp {
    private static String user = "yura";

    public static class PlayerUI {
        public void show() {
            System.out.println("🎧 현재 사용자: " + user); // ❌ 컴파일 에러 발생
        }
    }

    public static void main(String[] args) {
        MusicApp.PlayerUI ui = new MusicApp.PlayerUI();
        ui.show();
    }
}
