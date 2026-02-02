package com.regex;
import java.util.regex.*;

public class CapitalWordExtractor {
    public static void main(String[] args) {
        String text = "The Eiffel Tower is in Paris and New York";

        String regex = "\\b[A-Z][a-z]*\\b";

        Matcher matcher = Pattern.compile(regex).matcher(text);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}