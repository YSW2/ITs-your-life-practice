package ch06.practice;

public class DatabaseExample {
    public static void main (String[] args) {
        Database db = Database.getDatabase();

        String dbName = db.connect();
        System.out.println("데이터베이스: " + dbName);
        db.close();
    }
}
