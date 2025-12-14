package com.mishra.ekansh.example.notification.strategy;

public class SMSFormattingStrategy implements MessageFormattingStrategy {

    @Override
    public String format(String subject, String body) {
        return " [SMS] "+ subject + " : " + body;
    }
}
