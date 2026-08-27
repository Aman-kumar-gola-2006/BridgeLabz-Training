package com.fundoo.notes.messaging;

import com.fundoo.notes.config.RabbitMQConfig;
import com.fundoo.notes.dto.NoteEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class RabbitMQProducer {

    private static final Logger logger = LoggerFactory.getLogger(RabbitMQProducer.class);

    private final RabbitTemplate rabbitTemplate;

    @Autowired(required = false)
    public RabbitMQProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendNoteEvent(Long noteId, String actionType, String title, String userEmail) {
        NoteEvent event = new NoteEvent(noteId, actionType, title, userEmail, LocalDateTime.now().toString());
        logger.info("RABBITMQ PRODUCER - Sending event: action={}, noteId={}, user={}", actionType, noteId, userEmail);

        try {
            if (rabbitTemplate != null) {
                rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME, RabbitMQConfig.ROUTING_KEY, event);
                logger.info("RABBITMQ PRODUCER - Event published successfully to Exchange: {}", RabbitMQConfig.EXCHANGE_NAME);
            } else {
                logger.warn("RABBITMQ PRODUCER - RabbitTemplate is not available. Skipping message send.");
            }
        } catch (Exception e) {
            logger.warn("RABBITMQ PRODUCER - Failed to send message to RabbitMQ: {}", e.getMessage());
        }
    }
}
