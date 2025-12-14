package com.mishra.ekansh.example.notification.repository;

import java.util.List;

public class UserRepository {

    public static List<User> getEmailSubscribers(){
        return List.of(
                new User("Alice", "alice@email.com"),
                new User("Bob", "bob@email.com")

        );
    }

    public static  List<User> getSMSSubscribers() {
        return List.of(
                new User("Charlie", "1234567890"),
                new User("David", "9876543210")

        );
    }
}
