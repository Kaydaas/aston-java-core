package ru.aston.hometask3.adapter;

import ru.aston.hometask3.adapter.email.EmailAdapter;
import ru.aston.hometask3.adapter.email.EmailService;
import ru.aston.hometask3.adapter.telegram.TelegramAPI;
import ru.aston.hometask3.adapter.telegram.TelegramAdapter;

public class NotificationFactory {
    public static NotificationService getAdapter(NotificationType type) {
        return switch (type) {
            case EMAIL -> new EmailAdapter(new EmailService());
            case TELEGRAM -> new TelegramAdapter(new TelegramAPI());
        };
    }
}
