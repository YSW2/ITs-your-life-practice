package ch13.quiz;

public class Quiz extends Content {
    String answer;

    public Quiz (String question, String answer) {
        super(question);
        this.answer = answer;
    }

    public String getQuestion () {
        return question;
    }

    public String getAnswer () {
        return answer;
    }
}
