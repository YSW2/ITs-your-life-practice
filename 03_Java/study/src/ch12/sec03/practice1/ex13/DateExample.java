package ch12.sec03.practice1.ex13;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateExample {
    public static void main (String[] args) {
        Date now = new Date();
        String strNow1 = now.toString();
        System.out.println(strNow1);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        String strNow2 = sdf.format(now);
        System.out.println(strNow2);
    }
}