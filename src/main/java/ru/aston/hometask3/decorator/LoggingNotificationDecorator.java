package ru.aston.hometask3.decorator;

public class LoggingNotificationDecorator implements NotificationService {
    private final NotificationService notificationService;

    public LoggingNotificationDecorator(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @Override
    public void notify(String message) {
        System.out.println("Sending message...");
        this.notificationService.notify(message);
        System.out.println("Message sent.");
    }
}
