package com.fundoo.notes.messaging;

import org.springframework.jms.core.JmsOperations;
import org.springframework.stereotype.Component;

@Component
public class ReminderProducerImpl implements ReminderProducer {

    private final JmsOperations jmsTemplate;

    public ReminderProducerImpl(JmsOperations jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    @Override
    public void sendPasswordResetRequest(String email, String resetToken) {
        String messageBody = email + "|" + resetToken;
        jmsTemplate.convertAndSend("password-reset-queue", messageBody);
    }

    @Override
    public void sendReminderNotification(String email, Long noteId, String title, String reminderTime) {
        String messageBody = email + "|" + noteId + "|" + title + "|" + reminderTime;
        jmsTemplate.convertAndSend("reminder-queue", messageBody);
    }
}
