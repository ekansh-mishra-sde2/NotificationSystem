
# Notification System (Observer + Strategy + Queue)

Overview

This project implements a scalable, extensible Notification System that supports multiple notification channels (Email, SMS) using clean object-oriented design principles.

The system is designed to:

. Be open for extensible, closed for modification
. Supports asynchronous processing
. Allow dynamic message formatting
. Send notification only to subscribed users
. Be easily testable and extensible


## Design Principles Used

* Observer Pattern -> User subscription model
* Strategy Pattern -> Channel-specific message formatting
* Factory Pattern  -> Channel creation
* Producer-Consumer Patter -> Loose coupling via queue

* SOLID Principles
    * Single Responsibility
    * Open-closed Principles
    * Dependency Inversion

## High-level Design

+--------------------+
| NotificationSystem |
|        Main        |
+----------+---------+
           |
           | starts
           v
+--------------------+       +----------------------+
| NotificationProducer| ---> | NotificationQueue    |
| (CLI Input)         |      | (BlockingQueue)      |
+--------------------+       +----------+-----------+
                                          |
                                          | consumes
                                          v
                            +-----------------------------+
                            | NotificationDispatcher      |
                            | - Retry mechanism            |
                            | - Channel selection          |
                            +--------------+--------------+
                                           |
                                           v
                            +-----------------------------+
                            | NotificationChannel         |
                            | (Email / SMS)               |
                            +--------------+--------------+
                                           |
                                           v
                            +-----------------------------+
                            | Users (Observers)           |
                            +-----------------------------+
## 📄 Use Cases


UC-1: Send Email Notification

Actor: Admin/System
Flow:

User enters EMAIL, subject, message

Request added to queue

Dispatcher processes request

Email channel formats message

Subscribed users receive email

UC-2: Send SMS Notification

Actor: Admin/System
Flow:

User enters SMS, subject, message

Request added to queue

Dispatcher processes request

SMS formatter formats message

Subscribed users receive SMS

UC-3: Retry on Failure

Flow:

Notification fails

Dispatcher retries up to 3 times

Logs failure if retries exhausted
## 📁 Folder Structure

src/main/java/com/example/notification
├── NotificationSystemMain.java
├── channel/
│   ├── EmailChannel.java
│   └── SMSChannel.java
├── strategy/
│   ├── MessageFormattingStrategy.java
│   ├── EmailFormattingStrategy.java
│   └── SMSFormattingStrategy.java
├── observer/
│   ├── NotificationObserver.java
│   ├── NotificationChannel.java
│   └── AbstractNotificationChannel.java
├── dispatcher/
│   ├── NotificationDispatcher.java
│   └── ChannelFactory.java
├── queue/
│   └── NotificationQueue.java
├── repository/
│   └── UserRepository.java
├── dto/
│   └── NotificationRequest.java
├── producer/
│   └── NotificationProducer.java
├── consumer/
│   └── NotificationConsumer.java
## 🔌 Extending the System

Add a New Channel (e.g., Push Notification)

Create new formatter:

class PushFormattingStrategy implements MessageFormattingStrategy


Create new channel:

class PushChannel extends AbstractNotificationChannel


Register in ChannelFactory

✔ No existing code modification needed

🚀 Future Enhancements

Kafka / RabbitMQ integration

Dead-letter queue

REST API producer

Metrics & logging

Persistence layer

Exponential backoff retries

🧠 Key Takeaway

This project demonstrates how real-world notification systems are built using:

Clean architecture

Design patterns

Asynchronous processing

Industry-standard practices

This design is interview-ready and production-aligned.