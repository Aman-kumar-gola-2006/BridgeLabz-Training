package com.fundoo.notes.messaging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ReminderConsumer {

    private static final Logger logger = LoggerFactory.getLogger(ReminderConsumer.class);

    @JmsListener(destination = "password-reset-queue")
    public void handlePasswordResetRequest(String messageBody) {
        if (messageBody == null || !messageBody.contains("|")) {
            logger.warn("Invalid password reset message format: {}", messageBody);
            return;
        }

        String[] parts = messageBody.split("\\|");
        String email = parts[0];
        String resetToken = parts[1];

        sendActualPasswordResetEmail(email, resetToken);
    }

    @JmsListener(destination = "reminder-queue")
    public void handleReminderNotification(String messageBody) {
        if (messageBody == null || !messageBody.contains("|")) {
            logger.warn("Invalid reminder message format: {}", messageBody);
            return;
        }

        String[] parts = messageBody.split("\\|");
        String email = parts[0];
        String noteId = parts.length > 1 ? parts[1] : "";
        String title = parts.length > 2 ? parts[2] : "";
        String reminderTime = parts.length > 3 ? parts[3] : "";

        logger.info("JMS CONSUMER - REMINDER: for user {} regarding note '{}' (ID: {}) scheduled at {}",
                email, title, noteId, reminderTime);
    }

    private void sendActualPasswordResetEmail(String email, String resetToken) {
        try {
            // Simulate slow external email server latency (~100ms for test fast execution, 3s conceptual)
            Thread.sleep(100);
            logger.info("JMS CONSUMER - Password reset email sent to: {} with token: {}", email, resetToken);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            logger.error("Email sending interrupted for: {}", email, e);
        }
    }
}
