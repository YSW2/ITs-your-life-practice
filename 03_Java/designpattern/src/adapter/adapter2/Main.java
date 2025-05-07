package adapter.adapter2;

import adapter.adapter1.Banner;

public class Main {
    public static void main (String[] args) {
        Banner banner = new Banner("Hello");

        Print p = new PrintBanner(banner);
        p.printWeak();
        p.printStrong();
    }
}
