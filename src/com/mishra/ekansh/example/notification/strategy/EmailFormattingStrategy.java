package com.mishra.ekansh.example.notification.strategy;

public class EmailFormattingStrategy implements MessageFormattingStrategy {

    @Override
    public String format(String subject, String body) {
        return """
                ======================================================
                📧 EMAIL NOTIFICATION
                Subject: %s
                ------------------------------------------------------
                %s
                ======================================================
                """.formatted(subject, body);
    }
}
