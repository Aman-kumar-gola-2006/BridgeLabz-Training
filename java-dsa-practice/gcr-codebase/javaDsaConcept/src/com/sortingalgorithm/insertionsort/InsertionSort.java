package com.sortingalgorithm.insertionsort;
import java.util.Arrays;

public class InsertionSort {
	public static void insertionSort(int[] empIds) {

        for (int i = 1; i < empIds.length; i++) {

            int key = empIds[i];
            int j = i - 1;

            while (j >= 0 && empIds[j] > key) {
                empIds[j + 1] = empIds[j];
                j--;
            }

            empIds[j + 1] = key;
        }
    }

    public static void main(String[] args) {

        int[] employeeIds = { 105, 101, 110, 102, 108 };

        System.out.println("Before Sorting: " + Arrays.toString(employeeIds));

        insertionSort(employeeIds);

        System.out.println("After Sorting:  " + Arrays.toString(employeeIds));
    }

}
