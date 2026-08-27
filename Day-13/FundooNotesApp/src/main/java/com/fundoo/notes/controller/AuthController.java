package com.fundoo.notes.controller;

import com.fundoo.notes.dto.AuthResponse;
import com.fundoo.notes.dto.LoginRequest;
import com.fundoo.notes.dto.RegisterRequest;
import com.fundoo.notes.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	private final UserService userService;

	public AuthController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping("/register")
	public ResponseEntity<AuthResponse> registerUser(@Valid @RequestBody RegisterRequest registerRequest) {
		AuthResponse response = userService.register(registerRequest);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	@PostMapping("/login")
	public ResponseEntity<AuthResponse> loginUser(@Valid @RequestBody LoginRequest loginRequest) {
		AuthResponse response = userService.login(loginRequest);
		return ResponseEntity.ok(response);
	}

	@PostMapping("/forgot-password")
	public ResponseEntity<java.util.Map<String, String>> forgotPassword(@RequestBody java.util.Map<String, String> body) {
		String email = body != null ? body.get("email") : null;
		if (email == null || email.isBlank()) {
			throw new IllegalArgumentException("Email is required!");
		}
		userService.requestPasswordReset(email);
		java.util.Map<String, String> response = new java.util.HashMap<>();
		response.put("message", "Password reset email queued asynchronously for processing.");
		return ResponseEntity.ok(response);
	}
}
