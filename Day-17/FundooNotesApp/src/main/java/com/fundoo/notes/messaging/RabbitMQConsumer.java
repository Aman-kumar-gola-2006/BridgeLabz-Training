package com.fundoo.notes.messaging;

import com.fundoo.notes.config.RabbitMQConfig;
import com.fundoo.notes.dto.NoteEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQConsumer {

    private static final Logger logger = LoggerFactory.getLogger(RabbitMQConsumer.class);

    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
    public void consumeNoteEvent(NoteEvent event) {
        logger.info("RABBITMQ CONSUMER - Received event: action={}, noteId='{}', title='{}', user='{}'",
                event.getActionType(), event.getNoteId(), event.getTitle(), event.getUserEmail());
        
        // Business logic for processing asynchronous events
        // (e.g. updating audit logs, sending push notifications, syncing search indices)
    }
}
