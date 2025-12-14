package com.mishra.ekansh.example.notification.observer;

public interface NotificationChannel {
    void subscribe(NotificationObserver observer);
    void notifyUser(String subject, String body);
}
