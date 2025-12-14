package com.mishra.ekansh.example.notification.observer;

import com.mishra.ekansh.example.notification.strategy.MessageFormattingStrategy;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractNotificationChannel implements NotificationChannel {

    protected List<NotificationObserver> observers = new ArrayList<>();
    protected MessageFormattingStrategy formatter;

    protected AbstractNotificationChannel(MessageFormattingStrategy formatter) {
        this.formatter = formatter;
    }

    @Override
    public void subscribe(NotificationObserver observer) {
        observers.add(observer);
    }
    @Override
    public void notifyUser(String subject, String body) {
        String formattedMessage = formatter.format(subject, body);

        for (NotificationObserver observer : observers) {
            observer.update(formattedMessage);
        }
    }
}
