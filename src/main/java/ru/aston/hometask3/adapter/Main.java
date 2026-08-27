package ru.aston.hometask3.adapter;

public class Main {
    void main() {
        NotificationFactory.getAdapter(NotificationType.EMAIL).notify("email message");
        NotificationFactory.getAdapter(NotificationType.TELEGRAM).notify("telegram message");
    }
}
