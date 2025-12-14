package com.mishra.ekansh.example.notification.dto;

public class NotificationRequest {
    public String channel;
    public String subject;
    public String body;
    public int retryCount =0;


    public NotificationRequest(String channel, String subject, String body) {
        this.channel = channel;
        this.subject = subject;
        this.body = body;
    }
}
