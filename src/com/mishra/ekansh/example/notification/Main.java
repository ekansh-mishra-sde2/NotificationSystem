package com.mishra.ekansh.example.notification;

import com.mishra.ekansh.example.notification.apps.NotificationConsumerApp;
import com.mishra.ekansh.example.notification.apps.NotificationProducerApp;

public class Main {
    public static void main(String[] args) {
       NotificationConsumerApp consumer = new NotificationConsumerApp();
       consumer.start();

        NotificationProducerApp producerApp = new NotificationProducerApp();
        producerApp.start();

        System.out.println("notification system stopped.....");
    }
}
