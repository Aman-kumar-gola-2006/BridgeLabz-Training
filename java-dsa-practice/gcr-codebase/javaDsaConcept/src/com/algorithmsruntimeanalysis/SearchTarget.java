package com.algorithmsruntimeanalysis;

import java.util.Arrays;

public class SearchTarget {

    // Performs Linear Search and prints runtime
    public static void linearSearch(int[] arr, int target) {

        long start = System.nanoTime(); // start time

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                long end = System.nanoTime(); // end time
                System.out.println("Linear Search: Target Found at index " + i);
                System.out.println("Time Taken (ns): " + (end - start));
                return;
            }
        }

        long end = System.nanoTime();
        System.out.println("Linear Search: Target Not Found");
        System.out.println("Time Taken (ns): " + (end - start));
    }

    // Performs Binary Search and prints runtime
    public static void binarySearch(int[] arr, int target) {

        // Binary search requires sorted array
        Arrays.sort(arr);

        int left = 0, right = arr.length - 1;
        long start = System.nanoTime(); // start time

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == target) {
                long end = System.nanoTime(); // end time
                System.out.println("Binary Search: Target Found at index " + mid);
                System.out.println("Time Taken (ns): " + (end - start));
                return;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        long end = System.nanoTime();
        System.out.println("Binary Search: Target Not Found");
        System.out.println("Time Taken (ns): " + (end - start));
    }

    public static void main(String[] args) {

        int[] arr = {3, 7, 8, 4, 2, 9};
        int target = 4;

        linearSearch(arr, target);
        binarySearch(arr, target);
    }
}
