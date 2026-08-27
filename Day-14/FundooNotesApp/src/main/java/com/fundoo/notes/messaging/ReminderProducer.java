package com.fundoo.notes.messaging;

public interface ReminderProducer {

    void sendPasswordResetRequest(String email, String resetToken);

    void sendReminderNotification(String email, Long noteId, String title, String reminderTime);
}
