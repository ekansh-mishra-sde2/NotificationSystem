package com.mishra.ekansh.example.notification.apps;

import com.mishra.ekansh.example.notification.dispatcher.NotificationDispatcher;

public class NotificationConsumerApp {
    public void start() {
        System.out.println("Starting Notification Consumer App....");
        Thread consumerThread = new Thread(new NotificationDispatcher());

        consumerThread.setDaemon(true);
        consumerThread.start();
    }
}
