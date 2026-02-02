package com.exceptions.finallyblock;

public class FinallyExample {
    public static void main(String[] args) {

        int a = 10, b = 0;

        try {
            System.out.println("Result: " + (a / b));
        } catch (ArithmeticException e) {
            System.out.println("Division by zero error");
        } finally {
            System.out.println("Operation completed");
        }
    }
}