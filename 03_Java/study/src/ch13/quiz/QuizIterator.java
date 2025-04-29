package ch13.quiz;

import java.util.Iterator;

public class QuizIterator implements Iterator<QuizNode> {
    QuizNode head;

    public QuizIterator (QuizNode head) {
        this.head = head;
    }

    @Override
    public boolean hasNext () {
        return head != null;
    }

    @Override
    public QuizNode next () {
        QuizNode current = head;
        head = head.next;
        return current;
    }
}
