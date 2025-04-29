package ch13.quiz;

public class QuizNode {
    String title;
    String content;
    QuizNode next;

    public QuizNode (String title, String content) {
        this.title = title;
        this.content = content;
        this.next = null;
    }
}
