package com.regex;

public class SpaceReplacer {
    public static void main(String[] args) {
        String text = "This   is      an   example";

        // Replace multiple spaces with single space
        System.out.println(text.replaceAll("\\s+", " "));
    }
}