package com.mishra.ekansh.example.notification.channel;

import com.mishra.ekansh.example.notification.observer.AbstractNotificationChannel;
import com.mishra.ekansh.example.notification.repository.User;
import com.mishra.ekansh.example.notification.repository.UserRepository;
import com.mishra.ekansh.example.notification.strategy.EmailFormattingStrategy;

public class EmailChannel extends AbstractNotificationChannel {

     public EmailChannel() {
        super(new EmailFormattingStrategy());

        for(User user: UserRepository.getEmailSubscribers()){
            subscribe(user);
        }
    }
}
