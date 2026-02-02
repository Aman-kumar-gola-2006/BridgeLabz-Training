package com.regex;

import java.util.regex.*;

public class LanguageExtractor {
    public static void main(String[] args) {
        String text = "I love Java, Python, JavaScript and Go";

        String regex = "\\b(Java|Python|JavaScript|Go)\\b";

        Matcher matcher = Pattern.compile(regex).matcher(text);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}