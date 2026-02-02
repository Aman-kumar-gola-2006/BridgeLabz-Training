package com.exceptions.customexception;

public class InvalidAgeException extends Exception {
	public InvalidAgeException(String message) {
		super(message);
	}
}
