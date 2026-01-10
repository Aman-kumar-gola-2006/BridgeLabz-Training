package com.searchingalgorithm.binarysearch;

import java.util.Scanner;

public class MatrixSearch {

    // Returns true if target exists in matrix
    public static boolean searchMatrix(int[][] mat, int target) {

        int r = mat.length, c = mat[0].length;
        int l = 0, h = r * c - 1;

        while (l <= h) {
            int mid = (l + h) / 2;

            // Convert 1D index to 2D
            int val = mat[mid / c][mid % c];

            if (val == target)
                return true;
            else if (val < target)
                l = mid + 1;
            else
                h = mid - 1;
        }
        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read rows and columns
        System.out.print("Enter rows: ");
        int rows = sc.nextInt();
        System.out.print("Enter columns: ");
        int cols = sc.nextInt();

        int[][] mat = new int[rows][cols];

        // Read matrix elements
        System.out.println("Enter matrix elements:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                mat[i][j] = sc.nextInt();
            }
        }

        // Read target
        System.out.print("Enter target value: ");
        int target = sc.nextInt();

        // Search target
        boolean found = searchMatrix(mat, target);

        // Display result
        System.out.println(found ? "Target Found" : "Target Not Found");

        sc.close();
    }
}