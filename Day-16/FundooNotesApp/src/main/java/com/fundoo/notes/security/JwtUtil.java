package com.fundoo.notes.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

@Component
public class JwtUtil {

    private static final Logger logger = LoggerFactory.getLogger(JwtUtil.class);
    private static final String SECRET = "FundooNotesAppSecretKeyForJWTAuthentication256BitsLong!";
    private static final long EXPIRATION_TIME = 86400000; // 24 hours in ms

    private StringRedisTemplate redisTemplate;

    public JwtUtil() {
    }

    @Autowired(required = false)
    public JwtUtil(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void setRedisTemplate(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    private Key getSigningKey() {
        return Keys.hmacShaKeyFor(SECRET.getBytes());
    }

    public String generateToken(String email) {
        return generateTokenWithExpiration(email, EXPIRATION_TIME);
    }

    public String generateTokenWithExpiration(String email, long expirationMillis) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + expirationMillis);

        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public String extractEmail(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public Boolean isTokenExpired(String token) {
        try {
            return extractExpiration(token).before(new Date());
        } catch (Exception e) {
            return true;
        }
    }

    public boolean isTokenValid(String token) {
        String cacheKey = "jwt:valid:" + token;

        // 1. Check Redis cache first
        if (redisTemplate != null) {
            try {
                String cached = redisTemplate.opsForValue().get(cacheKey);
                if (cached != null) {
                    logger.debug("Cache HIT for token, skipping real validation");
                    return Boolean.parseBoolean(cached);
                }
            } catch (Exception e) {
                logger.warn("Redis lookup failed, falling back to real validation: {}", e.getMessage());
            }
        }

        // 2. Perform real JWT validation
        logger.debug("Cache MISS for token, performing real validation");
        boolean isValid = false;
        long remainingSeconds = 0;

        try {
            Claims claims = extractAllClaims(token);
            Date expiration = claims.getExpiration();
            if (expiration != null && !expiration.before(new Date())) {
                isValid = true;
                remainingSeconds = (expiration.getTime() - System.currentTimeMillis()) / 1000;
            }
        } catch (Exception e) {
            isValid = false;
        }

        // 3. Cache the result briefly (CRITICAL TTL RULE: cache TTL <= token's remaining lifetime)
        if (redisTemplate != null && isValid && remainingSeconds > 0) {
            try {
                long cacheTtl = Math.min(remainingSeconds, 60);
                redisTemplate.opsForValue().set(cacheKey, String.valueOf(isValid), cacheTtl, TimeUnit.SECONDS);
                logger.debug("Cached validation result, expires in {}s", cacheTtl);
            } catch (Exception e) {
                logger.warn("Redis set failed: {}", e.getMessage());
            }
        }

        return isValid;
    }

    public Boolean validateToken(String token, String userEmail) {
        if (!isTokenValid(token)) {
            return false;
        }
        try {
            final String extractedEmail = extractEmail(token);
            return (extractedEmail != null && extractedEmail.equals(userEmail));
        } catch (Exception e) {
            return false;
        }
    }
}

