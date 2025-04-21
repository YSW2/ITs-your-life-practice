package ch06.sec14;

public class Car {
    //필드 선언
    private int speed;
    private boolean stop;

    public int getSpeed () {
        return speed;
    }

    public void setSpeed (int speed) {
        this.speed = Math.max(speed, 0);
    }

    public boolean isStop () {
        return stop;
    }

    public void setStop (boolean stop) {
        if (stop) {
            setSpeed(0);
        }
        this.stop = stop;
    }
}
