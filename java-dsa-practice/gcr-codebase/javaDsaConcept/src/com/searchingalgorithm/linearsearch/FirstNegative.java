package com.searchingalgorithm.linearsearch;

import java.util.Scanner;

public class FirstNegative {

    // Returns index of first negative number, else -1
    public static int findFirstNegative(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read array size
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        // Read array elements
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Search for first negative number
        int index = findFirstNegative(arr);

        // Display result
        if (index != -1)
            System.out.println("First negative at index " + index + ": " + arr[index]);
        else
            System.out.println("No negative number found");

        sc.close();
    }
}