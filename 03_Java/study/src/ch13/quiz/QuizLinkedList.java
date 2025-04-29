package ch13.quiz;

import java.util.Iterator;

public class QuizLinkedList implements Iterable<QuizNode> {
    QuizNode head;

    public QuizLinkedList () {
        this.head = null;
    }

    void addFirst (String title, String content) {
        QuizNode newNode = new QuizNode(title, content);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    void addLast (String title, String content) {
        QuizNode node = new QuizNode(title, content);

        if (head == null) {
            head = node;
        } else {
            QuizNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = node;
        }
    }

    void addAt (int index, String title, String content) {
        QuizNode node = new QuizNode(title, content);
        QuizNode current = head;
        int count = 0;

        if (index == 0) {
            node.next = current;
        } else {
            while (count < index && current.next == null) {
                current = current.next;
            }
            QuizNode temp = current.next;
            current.next = node;
            node.next = temp;
        }
    }

    void removeFirst () {
        if (head == null) return;
        head = head.next;
    }

    void printAll () {
        QuizNode current = head;
        System.out.println("=== 현재 도전할 문제 리스트 ===");

        while (current != null) {
            System.out.println("문제 제목: " + current.title);
            System.out.println("문제 내용: " + current.content + "\n");
            current = current.next;
        }
    }

    int size () {
        QuizNode current = head;
        int count = 0;

        while (current != null) {
            current = current.next;
            count++;
        }

        return count;
    }

    @Override
    public Iterator<QuizNode> iterator () {
        return new QuizIterator(head);
    }
}
