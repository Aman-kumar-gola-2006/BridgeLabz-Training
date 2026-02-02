package com.exceptions.multiplecatchblocks;

import java.util.Scanner;

public class ArrayOperations {

    // This method performs safe array access by validating the array and index
    public static void arrayOperations(int arr[], int index) {

        // Check if the array reference is null before accessing it
        if (arr == null) {
            throw new NullPointerException("Array Cannot be Null");
        }

        // Validate the index to ensure it is within valid array bounds
        if (index < 0 || index >= arr.length) {
            throw new ArrayIndexOutOfBoundsException("Please Input Correct Index");
        }

        // If all validations pass, print the element at the given index
        System.out.println("Element at Index " + index + " is : " + arr[index]);
    }

    public static void main(String[] args) {

        // Initialize the array with sample integer values
        int arr[] = {10, 34, 54, 3, 4, 3, 2, 4, 5, 4, 3, 5, 5, 66, 6, 7};

        // Create Scanner object to take user input from the console
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter an index value
        System.out.println("Enter Index");
        int index = scanner.nextInt();

        try {
            // Call the method that performs array operations
            arrayOperations(arr, index);

        } catch (NullPointerException e) {
            // Handles the case where the array reference is null
            System.out.println(e.getMessage());

        } catch (ArrayIndexOutOfBoundsException e) {
            // Handles invalid index values provided by the user
            System.out.println(e.getMessage());

        } catch (Exception e) {
            // Catches any other unexpected runtime exceptions
            System.out.println("Unexpected Error");
        }

        // Close the scanner resource to avoid memory leaks
        scanner.close();
    }
}
