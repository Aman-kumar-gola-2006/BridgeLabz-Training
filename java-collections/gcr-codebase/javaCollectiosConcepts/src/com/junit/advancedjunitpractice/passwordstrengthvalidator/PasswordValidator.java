package com.junit.advancedjunitpractice.passwordstrengthvalidator;

//Validates password strength
public class PasswordValidator {

/*
* Password rules:
* - Minimum 8 characters
* - At least one uppercase letter
* - At least one digit
*/
public boolean isValid(String password) {
   if (password == null) {
       return false;
   }
   return password.matches("^(?=.*[A-Z])(?=.*\\d).{8,}$");
}
}
