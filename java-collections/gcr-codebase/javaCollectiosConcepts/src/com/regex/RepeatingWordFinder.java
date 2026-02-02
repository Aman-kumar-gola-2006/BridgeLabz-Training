package com.regex;

import java.util.regex.*;

public class RepeatingWordFinder {
    public static void main(String[] args) {
        String text = "This is is a repeated repeated word";

        String regex = "\\b(\\w+)\\s+\\1\\b";

        Matcher matcher = Pattern.compile(regex).matcher(text);

        while (matcher.find()) {
            System.out.println(matcher.group(1));
        }
    }
}