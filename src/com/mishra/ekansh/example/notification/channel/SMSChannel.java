package com.mishra.ekansh.example.notification.channel;

import com.mishra.ekansh.example.notification.observer.AbstractNotificationChannel;
import com.mishra.ekansh.example.notification.repository.User;
import com.mishra.ekansh.example.notification.repository.UserRepository;
import com.mishra.ekansh.example.notification.strategy.SMSFormattingStrategy;

public class SMSChannel extends AbstractNotificationChannel {

    public SMSChannel() {
        super(new SMSFormattingStrategy());
        for(User user: UserRepository.getSMSSubscribers()){
            subscribe(user);
        }
    }
}
