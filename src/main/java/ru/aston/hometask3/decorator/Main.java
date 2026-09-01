package ru.aston.hometask3.decorator;

public class Main {
    void main() {
        new LoggingNotificationDecorator(
                new EmailNotification()
        ).notify("Some message");
    }
}
