package com.stringbuilder;

public class ReverseString {

    public static String reverseString(String input) {
        StringBuilder sb = new StringBuilder();
        sb.append(input);
        sb.reverse();
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseString("hello"));
    }
}