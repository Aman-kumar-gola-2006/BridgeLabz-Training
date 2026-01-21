package com.algorithmsruntimeanalysis;

import java.util.Arrays;
import java.util.Random;

public class SortingLargeData {

    /* -------- Bubble Sort -------- */
    static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    /* -------- Merge Sort -------- */
    static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    static void merge(int[] arr, int l, int m, int r) {
        int[] left = Arrays.copyOfRange(arr, l, m + 1);
        int[] right = Arrays.copyOfRange(arr, m + 1, r + 1);

        int i = 0, j = 0, k = l;
        while (i < left.length && j < right.length)
            arr[k++] = (left[i] <= right[j]) ? left[i++] : right[j++];

        while (i < left.length) arr[k++] = left[i++];
        while (j < right.length) arr[k++] = right[j++];
    }

    /* -------- Quick Sort -------- */
    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int p = partition(arr, low, high);
            quickSort(arr, low, p - 1);
            quickSort(arr, p + 1, high);
        }
    }

    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high], i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int t = arr[i]; arr[i] = arr[j]; arr[j] = t;
            }
        }
        int t = arr[i + 1]; arr[i + 1] = arr[high]; arr[high] = t;
        return i + 1;
    }

    /* -------- Main -------- */
    public static void main(String[] args) {

        int N = 10000; // change size: 1000, 10000, 100000
        int[] original = new int[N];
        Random r = new Random();

        for (int i = 0; i < N; i++)
            original[i] = r.nextInt(100000);

        int[] a1 = original.clone();
        int[] a2 = original.clone();
        int[] a3 = original.clone();

        // Bubble Sort Time
        long start = System.nanoTime();
        bubbleSort(a1);
        long end = System.nanoTime();
        System.out.println("Bubble Sort Time (ms): " + (end - start) / 1_000_000);

        // Merge Sort Time
        start = System.nanoTime();
        mergeSort(a2, 0, a2.length - 1);
        end = System.nanoTime();
        System.out.println("Merge Sort Time (ms): " + (end - start) / 1_000_000);

        // Quick Sort Time
        start = System.nanoTime();
        quickSort(a3, 0, a3.length - 1);
        end = System.nanoTime();
        System.out.println("Quick Sort Time (ms): " + (end - start) / 1_000_000);
    }
}
