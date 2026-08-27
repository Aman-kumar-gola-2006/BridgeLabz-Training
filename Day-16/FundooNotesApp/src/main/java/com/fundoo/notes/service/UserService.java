package com.fundoo.notes.service;

import com.fundoo.notes.dto.AuthResponse;
import com.fundoo.notes.dto.LoginRequest;
import com.fundoo.notes.dto.RegisterRequest;
import com.fundoo.notes.entity.User;
import com.fundoo.notes.repository.UserRepository;
import com.fundoo.notes.security.JwtUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/*
 * UserService - Handles User registration, login, and JWT generation.
 * Freshers logic: Easy to follow steps with clear exception messages.
 */
import com.fundoo.notes.exception.ResourceNotFoundException;
import com.fundoo.notes.exception.UserAlreadyExistsException;
import com.fundoo.notes.messaging.ReminderProducer;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final ReminderProducer reminderProducer;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtUtil jwtUtil, ReminderProducer reminderProducer) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
        this.reminderProducer = reminderProducer;
    }

    public AuthResponse register(RegisterRequest request) {
        // Step 1: Check if email already exists
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new UserAlreadyExistsException("Email is already registered: " + request.getEmail());
        }

        // Step 2: Encrypt password and save user
        User user = new User(
                request.getFirstName(),
                request.getLastName(),
                request.getEmail(),
                passwordEncoder.encode(request.getPassword())
        );

        userRepository.save(user);

        // Step 3: Generate JWT token for user
        String token = jwtUtil.generateToken(user.getEmail());

        return new AuthResponse(token, "User registered successfully");
    }

    public AuthResponse login(LoginRequest request) {
        // Step 1: Find user by email
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid email or password!"));

        // Step 2: Validate password (check encoded password match or plain password for legacy)
        boolean isPasswordValid = passwordEncoder.matches(request.getPassword(), user.getPassword())
                || request.getPassword().equals(user.getPassword());

        if (!isPasswordValid) {
            throw new RuntimeException("Invalid email or password!");
        }

        // Step 3: Generate JWT token for successful login
        String token = jwtUtil.generateToken(user.getEmail());

        return new AuthResponse(token, "User logged in successfully");
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found!"));
    }

    public void requestPasswordReset(String email) {
        User user = getUserByEmail(email);
        String resetToken = UUID.randomUUID().toString();
        if (reminderProducer != null) {
            reminderProducer.sendPasswordResetRequest(user.getEmail(), resetToken);
        }
    }
}
