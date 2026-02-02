package com.regex;

import java.util.regex.*;

public class CurrencyExtractor {
    public static void main(String[] args) {
        String text = "Price is $45.99 and discount 10.50";

        String regex = "\\$?\\d+\\.\\d{2}";

        Matcher matcher = Pattern.compile(regex).matcher(text);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}