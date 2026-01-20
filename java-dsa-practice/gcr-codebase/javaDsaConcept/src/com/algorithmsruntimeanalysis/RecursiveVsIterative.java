package com.algorithmsruntimeanalysis;

import java.util.Scanner;

public class RecursiveVsIterative {

    // Recursive Fibonacci (Exponential Time)
    public static int fibonacciRecursive(int n) {
        if (n <= 1)
            return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    // Iterative Fibonacci (Linear Time)
    public static int fibonacciIterative(int n) {
        if (n <= 1)
            return n;

        int a = 0, b = 1, sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Read input
        System.out.print("Enter the number: ");
        int n = scanner.nextInt();

        // Recursive Fibonacci timing
        long start = System.nanoTime();
        int recResult = fibonacciRecursive(n);
        long end = System.nanoTime();
        System.out.println("Recursive Fibonacci Result: " + recResult);
        System.out.println("Time taken by Recursive Fibonacci (ns): " + (end - start));

        // Iterative Fibonacci timing
        start = System.nanoTime();
        int itrResult = fibonacciIterative(n);
        end = System.nanoTime();
        System.out.println("Iterative Fibonacci Result: " + itrResult);
        System.out.println("Time taken by Iterative Fibonacci (ns): " + (end - start));

        scanner.close();
    }
}