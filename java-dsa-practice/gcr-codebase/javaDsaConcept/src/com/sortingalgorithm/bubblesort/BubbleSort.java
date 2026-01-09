package com.sortingalgorithm.bubblesort;

import java.util.Scanner;

public class BubbleSort {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Ask user for array size
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] a = new int[n];

        // Take array elements from user
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        // Bubble Sort Logic
        // Outer loop controls number of passes
        for (int j = 0; j < n - 1; j++) {

            // Inner loop compares adjacent elements
            for (int i = 0; i < n - 1 - j; i++) {

                // If left element is greater, swap
                if (a[i] > a[i + 1]) {
                    int temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                }
            }
        }

        // Display sorted array
        System.out.println("Sorted Array:");
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }

        sc.close();
    }
}
