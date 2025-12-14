package com.mishra.ekansh.example.notification.dispatcher;

import com.mishra.ekansh.example.notification.dto.NotificationRequest;
import com.mishra.ekansh.example.notification.observer.NotificationChannel;
import com.mishra.ekansh.example.notification.queue.NotificationQueue;

public class NotificationDispatcher implements Runnable{

    private static final int MAX_RETRIES = 3;

    @Override
    public void run(){
        while(true){
            try{
                NotificationRequest request = NotificationQueue.QUEUE.take();

                try{
                    NotificationChannel channel = ChannelFactory.getChannel(request.channel);

                    channel.notifyUser(
                            request.subject, request.body
                    );
                }
                catch(Exception e){
                    request.retryCount++;

                    if(request.retryCount <= MAX_RETRIES){
                        System.out.println("Retry #" + request.retryCount + " of " + MAX_RETRIES);
                        NotificationQueue.QUEUE.offer(request);
                    }else{
                        System.out.println(
                                "failed after reties...."+request.subject
                        );
                    }
                }
            }
            catch(InterruptedException e){
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
