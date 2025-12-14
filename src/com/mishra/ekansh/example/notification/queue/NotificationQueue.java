package com.mishra.ekansh.example.notification.queue;

import com.mishra.ekansh.example.notification.dto.NotificationRequest;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class NotificationQueue {
    public static final BlockingQueue<NotificationRequest> QUEUE = new LinkedBlockingQueue<>();
}
