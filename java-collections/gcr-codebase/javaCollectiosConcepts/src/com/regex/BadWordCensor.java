package com.regex;

public class BadWordCensor {
    public static void main(String[] args) {
        String text = "This is a damn stupid example";

        // Replace bad words with ****
        String result = text.replaceAll("\\b(damn|stupid)\\b", "****");

        System.out.println(result);
    }
}