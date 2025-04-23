package ch09.practice;

public class PlayerUI {
    public interface ClickListener {
        void onClick();
    }

    public ClickListener clickListener;

    void setClickListener(ClickListener listener) {
        this.clickListener = listener;
    }

    void clickPlayButton() {
        if (this.clickListener == null) {
            System.out.println("❌ 리스너가 등록되지 않았습니다.");
            return;
        }
        this.clickListener.onClick();
    }

}
