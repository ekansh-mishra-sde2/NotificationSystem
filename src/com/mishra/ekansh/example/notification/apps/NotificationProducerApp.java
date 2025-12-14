package com.mishra.ekansh.example.notification.apps;

import com.mishra.ekansh.example.notification.dto.NotificationRequest;
import com.mishra.ekansh.example.notification.queue.NotificationQueue;

import java.util.Scanner;

public class NotificationProducerApp {
    public void start() {

        Scanner sc = new Scanner(System.in);
        System.out.println("Notification Producer App started....");
        System.out.println("Please enter: <CHANNEL> <SUBJECT> <BODY>");
        System.out.println("=====Please enter 'exit' to quit!===");
        while (true) {
            System.out.println("> ");

            String input = sc.nextLine();
            if("exit".equalsIgnoreCase(input)) {
                break;
            }
            String[] parts = input.split(" ",3);

            if(parts.length != 3) {
                System.out.println("Invalid input. Please try again.");
                continue;
            }
            NotificationRequest request = new NotificationRequest(parts[0], parts[1], parts[2]);
            NotificationQueue.QUEUE.offer(request);
        }
        sc.close();
    }
}
