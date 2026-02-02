package com.regex;

import java.util.regex.*;

public class LinkExtractor {
    public static void main(String[] args) {
        String text = "Visit https://google.com and http://example.org";

        String regex = "https?://\\S+";

        Matcher matcher = Pattern.compile(regex).matcher(text);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}