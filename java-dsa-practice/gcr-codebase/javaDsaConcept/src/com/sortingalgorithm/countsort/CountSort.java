package com.sortingalgorithm.countsort;

import java.util.Scanner;
import java.util.Arrays;

public class CountSort {

    // Sorts ages using Counting Sort
    static void countingSort(int[] ages) {

        int minAge = 10;
        int maxAge = 18;
        int range = maxAge - minAge + 1;

        int[] count = new int[range];
        int[] output = new int[ages.length];

        // Count frequency of each age
        for (int age : ages) {
            count[age - minAge]++;
        }

        // Compute cumulative frequency
        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }

        // Place elements in correct positions
        for (int i = ages.length - 1; i >= 0; i--) {
            int age = ages[i];
            output[count[age - minAge] - 1] = age;
            count[age - minAge]--;
        }

        // Copy sorted data back
        for (int i = 0; i < ages.length; i++) {
            ages[i] = output[i];
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read number of students
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int[] ages = new int[n];

        // Read ages
        System.out.println("Enter student ages (10–18):");
        for (int i = 0; i < n; i++) {
            ages[i] = sc.nextInt();
        }

        // Sort ages
        countingSort(ages);

        // Display result
        System.out.println("Sorted ages: " + Arrays.toString(ages));

        sc.close();
    }
}
