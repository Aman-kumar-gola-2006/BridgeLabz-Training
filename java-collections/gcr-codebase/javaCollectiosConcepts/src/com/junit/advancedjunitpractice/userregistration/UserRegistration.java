package com.junit.advancedjunitpractice.userregistration;

//Handles user registration validation
public class UserRegistration {

/*
* Registers a user after validating input data
* Throws IllegalArgumentException for invalid inputs
*/
public void registerUser(String username, String email, String password) {

   // Validate username
   if (username == null || username.trim().isEmpty()) {
       throw new IllegalArgumentException("Invalid username");
   }

   // Validate email
   if (email == null || !email.contains("@")) {
       throw new IllegalArgumentException("Invalid email");
   }

   // Validate password
   if (password == null || password.length() < 6) {
       throw new IllegalArgumentException("Invalid password");
   }

   // If all validations pass, user is registered successfully
   // (No return value needed for this example)
}
}
