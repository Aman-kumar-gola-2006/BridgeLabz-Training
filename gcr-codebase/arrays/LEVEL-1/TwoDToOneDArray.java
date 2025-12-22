import java.util.Scanner;   // Import Scanner class for input

public class TwoDToOneDArray {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take input for rows and columns
        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();

        System.out.print("Enter number of columns: ");
        int columns = sc.nextInt();

        // Create 2D array (matrix)
        int[][] matrix = new int[rows][columns];

        // Take input for 2D array elements
        System.out.println("Enter elements of the matrix:");
        for (int i = 0; i < rows; i++) {              // Outer loop for rows
            for (int j = 0; j < columns; j++) {       // Inner loop for columns
                matrix[i][j] = sc.nextInt();
            }
        }

        // Create 1D array of size rows * columns
        int[] array = new int[rows * columns];

        int index = 0;   // Index for 1D array

        // Copy elements from 2D array to 1D array
        for (int i = 0; i < rows; i++) {              // Outer loop for rows
            for (int j = 0; j < columns; j++) {       // Inner loop for columns
                array[index] = matrix[i][j];
                index++;
            }
        }

        // Display 1D array
        System.out.println("Elements of 1D Array:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

        sc.close();
    }
}
