package ch06.practice;

public class Database {
    private static Database database = new Database();
    private String connection = "MySQL";

    private Database () {
    }

    public static Database getDatabase () {
        return database;
    }

    String connect () {
        System.out.println(connection + "에 연결합니다.");
        return connection;
    }

    void close () {
        System.out.println(connection + "을 닫습니다.");
    }
}
