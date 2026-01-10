package com.searchingalgorithm.binarysearch;

import java.util.Scanner;

public class PeakElement {

    // Returns index of a peak element
    public static int findPeak(int[] arr) {

        int l = 0, r = arr.length - 1;

        while (l < r) {
            int mid = (l + r) / 2;

            // Move towards higher neighbor
            if (arr[mid] < arr[mid + 1])
                l = mid + 1;
            else
                r = mid;
        }
        return l;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read array size
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        // Read array elements
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Find peak element
        int index = findPeak(arr);

        // Display result
        System.out.println("Peak element index: " + index);
        System.out.println("Peak element value: " + arr[index]);

        sc.close();
    }
}
