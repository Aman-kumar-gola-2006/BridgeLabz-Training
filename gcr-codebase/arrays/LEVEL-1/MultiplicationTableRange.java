import java.util.Scanner;   // Import Scanner class for input

public class MultiplicationTableRange {
    public static void main(String[] args) {
        System.out.println("welcome to Java World");
        Scanner sc = new Scanner(System.in);  
        // Create Scanner object

        System.out.print("Enter a number: ");
        int number = sc.nextInt();  
        // Take integer input from user

        int[] multiplicationResult = new int[4];  
        // Array to store multiplication results for 6, 7, 8, 9

        // Loop from 6 to 9 to calculate multiplication
        for (int i = 6; i <= 9; i++) {
            multiplicationResult[i - 6] = number * i;  
            // Store result in array
        }

        // Display the multiplication table from array
        for (int i = 6; i <= 9; i++) {
            System.out.println(number + " * " + i + " = " + multiplicationResult[i - 6]);
            // Print in required format
        }

        sc.close();  
        // Close Scanner
    }
}
