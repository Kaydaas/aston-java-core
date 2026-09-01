package ru.aston.hometask3.decorator;

public class EmailNotification implements NotificationService {
    @Override
    public void notify(String message) {
        System.out.println("Email: " + message);
    }
}
