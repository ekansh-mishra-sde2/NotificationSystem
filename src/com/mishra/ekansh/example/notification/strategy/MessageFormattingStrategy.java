package com.mishra.ekansh.example.notification.strategy;

public interface MessageFormattingStrategy {

    String format(String subject, String body);
}
