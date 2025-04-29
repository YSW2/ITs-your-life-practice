package ch13.quiz;

import java.util.Arrays;

public class QuizBox<T extends Quiz> {
    Content[] quizList;
    int size;

    public QuizBox () {
        quizList = new Content[0];
        this.size = 0;
    }

    static <T extends Content> void removeFromBox (QuizBox<? super T> box, T quiz) {
        box.remove(quiz);
    }

    public void add (T content) {
        quizList = Arrays.copyOf(quizList, size + 1);
        quizList[size++] = content;
    }

    public void printAll () {
        for (int i = 0; i < size; i++) {
            System.out.println((i + 1) + ". " + quizList[i].question);
        }
    }

    boolean remove (Content content) {
        Content[] newList = new Content[size - 1];
        int index = 0;

        for (int i = 0; i < quizList.length; i++) {
            if (!quizList[i].equals(content.question)) {
                newList[index++] = quizList[i];
            }
        }
        quizList = newList;
        size--;

        return true;
    }
}
