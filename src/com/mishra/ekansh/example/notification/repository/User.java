package com.mishra.ekansh.example.notification.repository;

import com.mishra.ekansh.example.notification.observer.NotificationObserver;

public class User implements NotificationObserver {
    private final String name;
    private final String contact;

    public User(String name, String contact) {
        this.name = name;
        this.contact = contact;
    }

    @Override
    public void update(String formattedMessage) {
        System.out.println("Sending to "+ name + " -> " + contact);
        System.out.println(formattedMessage);
    }
}
