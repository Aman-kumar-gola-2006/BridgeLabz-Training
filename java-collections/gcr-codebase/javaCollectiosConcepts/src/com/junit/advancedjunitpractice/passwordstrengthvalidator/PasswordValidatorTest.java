package com.junit.advancedjunitpractice.passwordstrengthvalidator;

import static org.junit.Assert.*;
import org.junit.Test;

// JUnit 4 test class for PasswordValidator
public class PasswordValidatorTest {

    PasswordValidator validator = new PasswordValidator();

    @Test
    public void testValidPassword() {
        assertTrue(validator.isValid("Password1"));
    }

    @Test
    public void testInvalidPasswordTooShort() {
        assertFalse(validator.isValid("Pass1"));
    }

    @Test
    public void testInvalidPasswordNoUppercase() {
        assertFalse(validator.isValid("password1"));
    }

    @Test
    public void testInvalidPasswordNoDigit() {
        assertFalse(validator.isValid("Password"));
    }
}