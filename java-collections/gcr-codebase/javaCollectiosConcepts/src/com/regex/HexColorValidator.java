package com.regex;

public class HexColorValidator {
    public static void main(String[] args) {
        String color = "#FFA500";

        // # followed by 6 hex characters
        String regex = "^#[0-9A-Fa-f]{6}$";

        System.out.println(color.matches(regex));
    }
}