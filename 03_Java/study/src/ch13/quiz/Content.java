package ch13.quiz;

public class Content {
    String question;

    public Content (String question) {
        this.question = question;
    }

    public String getQuestion () {
        return question;
    }

    @Override
    public boolean equals (Object obj) {
        return question.equals(obj.toString());
    }
}
