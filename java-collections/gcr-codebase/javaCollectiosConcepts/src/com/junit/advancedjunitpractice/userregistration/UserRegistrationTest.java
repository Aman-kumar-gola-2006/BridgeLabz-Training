package com.junit.advancedjunitpractice.userregistration;

import org.junit.Test;

//JUnit 4 test class for UserRegistration
public class UserRegistrationTest {

 UserRegistration registration = new UserRegistration();

 @Test
 public void testValidUserRegistration() {
     // Should not throw any exception
     registration.registerUser("shifa", "shifa@gmail.com", "secret123");
 }

 @Test(expected = IllegalArgumentException.class)
 public void testInvalidUsername() {
     registration.registerUser("", "test@gmail.com", "password123");
 }

 @Test(expected = IllegalArgumentException.class)
 public void testInvalidEmail() {
     registration.registerUser("user", "gmail.com", "password123");
 }

 @Test(expected = IllegalArgumentException.class)
 public void testInvalidPassword() {
     registration.registerUser("user", "user@gmail.com", "123");
 }
}
