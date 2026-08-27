package com.fundoo.notes.messaging;

import com.fundoo.notes.security.JwtUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.jms.core.JmsOperations;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class JmsAndRedisTest {

    @Mock
    private JmsOperations jmsTemplate;

    @Mock
    private StringRedisTemplate redisTemplate;

    @Mock
    private ValueOperations<String, String> valueOperations;

    @InjectMocks
    private ReminderProducerImpl reminderProducer;

    @Test
    void testJmsProducer_SendPasswordResetRequest() {
        assertDoesNotThrow(() -> reminderProducer.sendPasswordResetRequest("user@example.com", "reset-token-123"));
        verify(jmsTemplate, times(1)).convertAndSend(eq("password-reset-queue"), eq("user@example.com|reset-token-123"));
    }

    @Test
    void testJmsProducer_SendReminderNotification() {
        assertDoesNotThrow(() -> reminderProducer.sendReminderNotification("user@example.com", 101L, "Meeting Notes", "2026-08-22T10:00:00"));
        verify(jmsTemplate, times(1)).convertAndSend(eq("reminder-queue"), eq("user@example.com|101|Meeting Notes|2026-08-22T10:00:00"));
    }

    @Test
    void testJmsConsumer_HandleMessages() {
        ReminderConsumer consumer = new ReminderConsumer();
        assertDoesNotThrow(() -> consumer.handlePasswordResetRequest("user@example.com|token-123"));
        assertDoesNotThrow(() -> consumer.handleReminderNotification("user@example.com|101|Meeting|2026-08-22T10:00:00"));
    }

    @Test
    void testJwtUtil_RedisCacheMissThenHit() {
        JwtUtil jwtUtil = new JwtUtil();
        jwtUtil.setRedisTemplate(redisTemplate);

        String token = jwtUtil.generateToken("user@example.com");
        String cacheKey = "jwt:valid:" + token;

        when(redisTemplate.opsForValue()).thenReturn(valueOperations);
        // First call: Cache MISS -> perform real validation & cache result
        when(valueOperations.get(cacheKey)).thenReturn(null);

        boolean isValidFirst = jwtUtil.isTokenValid(token);
        assertTrue(isValidFirst);
        verify(valueOperations, times(1)).set(eq(cacheKey), eq("true"), anyLong(), eq(TimeUnit.SECONDS));

        // Second call: Cache HIT -> skip real validation
        when(valueOperations.get(cacheKey)).thenReturn("true");
        boolean isValidSecond = jwtUtil.isTokenValid(token);
        assertTrue(isValidSecond);
    }

    @Test
    void testJwtUtil_RedisCacheTTLDoesNotExceedTokenLifetime() {
        JwtUtil jwtUtil = new JwtUtil();
        jwtUtil.setRedisTemplate(redisTemplate);

        // Generate token expiring in 15 seconds
        String shortToken = jwtUtil.generateTokenWithExpiration("user@example.com", 15000);
        String cacheKey = "jwt:valid:" + shortToken;

        when(redisTemplate.opsForValue()).thenReturn(valueOperations);
        when(valueOperations.get(cacheKey)).thenReturn(null);

        boolean isValid = jwtUtil.isTokenValid(shortToken);
        assertTrue(isValid);

        // Capture TTL argument passed to redisTemplate.opsForValue().set(...)
        ArgumentCaptor<Long> ttlCaptor = ArgumentCaptor.forClass(Long.class);
        verify(valueOperations).set(eq(cacheKey), eq("true"), ttlCaptor.capture(), eq(TimeUnit.SECONDS));

        long capturedTtl = ttlCaptor.getValue();
        // TTL must be <= 15 seconds (the token's remaining lifetime) and definitely <= 60 seconds
        assertTrue(capturedTtl <= 15, "Redis cache TTL (" + capturedTtl + "s) must not exceed token remaining lifetime (15s)");
    }
}

