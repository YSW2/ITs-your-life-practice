package ch15.practice1.ex06;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {
    public static void main (String[] args) {
        Queue<Message> queue = new LinkedList<>();

        queue.offer(new Message("sendMail", "홍길동"));
        queue.offer(new Message("sendSMS", "신용권"));
        queue.offer(new Message("sendKakaotalk", "김자바"));

        Iterator<Message> iterator = queue.iterator();

        while (iterator.hasNext()) {
            Message message = iterator.next();
            sendMessage(message.to, message.command);
        }
    }

    public static void sendMessage (String to, String command) {
        switch (command) {
            case "sendMail" -> {
                System.out.println(to + "님에게 메일을 보냅니다.");
            }
            case "sendSMS" -> {
                System.out.println(to + "님에게 SMS를 보냅니다.");
            }
            case "sendKakaotalk" -> {
                System.out.println(to + "님에게 카카오톡을 보냅니다.");
            }
        }
    }
}
