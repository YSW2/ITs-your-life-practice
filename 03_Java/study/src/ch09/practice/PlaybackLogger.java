package ch09.practice;

public class PlaybackLogger {
    void log(String title, String artist) {
        class RecentLog {
            String title;
            String artist;

            public RecentLog (String title, String artist) {
                this.title = title;
                this.artist = artist;
            }

            void printLog () {
                System.out.print("🎼 최근 재생: [" + this.title + "] - [" + this.artist + "]");
                if (this.title.length() >= 10 || this.artist.length() >= 10) {
                    System.out.print("(인기곡)");
                }
                System.out.println();
            }
        }
        RecentLog recentLog = new RecentLog(title, artist);
        recentLog.printLog();
    }
}
