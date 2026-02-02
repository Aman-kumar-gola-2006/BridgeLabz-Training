package com.regex;

import java.util.regex.*;

public class EmailExtractor {
    public static void main(String[] args) {
        String text = "Contact support@example.com and info@company.org";

        String regex = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";

        Matcher matcher = Pattern.compile(regex).matcher(text);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}