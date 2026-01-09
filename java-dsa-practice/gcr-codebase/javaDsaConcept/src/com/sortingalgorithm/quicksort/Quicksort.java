package com.sortingalgorithm.quicksort;
import java.util.Arrays;

public class Quicksort {

    // Method to perform Quick Sort
    public static void quickSort(double[] prices, int low, int high) {

        if (low < high) {
            int pivotIndex = partition(prices, low, high);

            // Recursively sort left and right partitions
            quickSort(prices, low, pivotIndex - 1);
            quickSort(prices, pivotIndex + 1, high);
        }
    }

    // Partition method
    private static int partition(double[] prices, int low, int high) {

        double pivot = prices[high]; // pivot = last element
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (prices[j] < pivot) {
                i++;
                // swap prices[i] and prices[j]
                double temp = prices[i];
                prices[i] = prices[j];
                prices[j] = temp;
            }
        }

        // place pivot in correct position
        double temp = prices[i + 1];
        prices[i + 1] = prices[high];
        prices[high] = temp;

        return i + 1;
    }

    // Driver method
    public static void main(String[] args) {

        double[] productPrices = { 799.99, 299.50, 1499.00, 499.99, 199.00 };

        System.out.println("Before Sorting: " + Arrays.toString(productPrices));

        quickSort(productPrices, 0, productPrices.length - 1);

        System.out.println("After Sorting:  " + Arrays.toString(productPrices));
    }
}
