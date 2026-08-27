package ru.aston.hometask3.adapter.telegram;

import ru.aston.hometask3.adapter.NotificationService;

public class TelegramAdapter implements NotificationService {
    private final TelegramAPI telegramAPI;

    public TelegramAdapter(TelegramAPI telegramAPI) {
        this.telegramAPI = telegramAPI;
    }

    @Override
    public void notify(String message) {
        this.telegramAPI.sendMessage(message);
    }
}
