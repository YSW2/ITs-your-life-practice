package ch16.practice3;

public class Message {
    private String sender;
    private String receiver;
    private String content;

    public Message (String line) {
        String[] parsedLine = line.split("\\|");

        this.sender = parsedLine[0];
        this.receiver = parsedLine[1];
        this.content = parsedLine[2];
    }

    public String getContent () {
        return content;
    }

    @Override
    public String toString () {
        return "[" + sender + " → " + receiver + "]\n" +
                content;
    }
}
