package ch16.practice3;

public class Photo {
    private String name; // 촬영자 이름
    private String pose; // 포즈

    public Photo (String name, String pose) {
        this.name = name;
        this.pose = pose;
    }

    public String getPose () {
        return pose;
    }

    public String getName () {
        return name;
    }

    @Override
    public String toString () {
        return name + "님이 " + pose + " 포즈로 사진을 찍었습니다.";
    }
}
