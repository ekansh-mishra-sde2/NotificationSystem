package com.mishra.ekansh.example.notification.dispatcher;

import com.mishra.ekansh.example.notification.channel.EmailChannel;
import com.mishra.ekansh.example.notification.channel.SMSChannel;
import com.mishra.ekansh.example.notification.observer.NotificationChannel;

public class ChannelFactory {
    static NotificationChannel getChannel(String type) throws IllegalAccessException {
        return switch(type.toUpperCase()){
            case "EMAIL" -> new EmailChannel();
            case "SMS" -> new SMSChannel();
            default -> throw new IllegalAccessException("Unsupported channel");
        };
    }
}
