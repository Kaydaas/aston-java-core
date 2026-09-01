package ru.aston.hometask3.adapter.email;

import ru.aston.hometask3.adapter.NotificationService;

public class EmailAdapter implements NotificationService {
    private final EmailService emailService;

    public EmailAdapter(EmailService emailService) {
        this.emailService = emailService;
    }

    @Override
    public void notify(String message) {
        this.emailService.sendEmail(message);
    }
}
