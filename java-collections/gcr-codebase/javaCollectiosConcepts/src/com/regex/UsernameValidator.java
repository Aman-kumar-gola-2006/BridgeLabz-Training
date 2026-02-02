package com.regex;
public class UsernameValidator {
    public static void main(String[] args) {
        String username = "user_123";

        // Regex:  Starts with letter, 5–15 chars, letters/digits/_
        String regex = "^[A-Za-z][A-Za-z0-9_]{4,14}$";

        System.out.println(username.matches(regex));
    }
}