package com.searchingalgorithm.binarysearch;

import java.util.Scanner;

public class RotationPoint {

    // Returns index of smallest element (rotation point)
    public static int findMin(int[] arr) {

        int l = 0, r = arr.length - 1;

        while (l < r) {
            int mid = (l + r) / 2;

            // Decide search side
            if (arr[mid] > arr[r])
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
        System.out.println("Enter rotated sorted array:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Find rotation point
        int index = findMin(arr);

        // Display result
        System.out.println("Rotation point index: " + index);
        System.out.println("Smallest element: " + arr[index]);

        sc.close();
    }
}
