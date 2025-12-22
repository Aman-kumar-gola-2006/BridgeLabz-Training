import java.util.Scanner;   // Import Scanner class to take input from user

public class MultiplicationTable {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);  
        // Create Scanner object for user input

        System.out.print("Enter a number: ");  
        // Ask the user to enter a number

        int number = sc.nextInt();  
        // Store the entered number in variable 'number'

        int[] table = new int[10];  
        // Declare an integer array to store multiplication results from 1 to 10

        // Loop from 1 to 10 to calculate multiplication values
        for (int i = 1; i <= 10; i++) {
            table[i - 1] = number * i;  
            // Store result of number * i in the array
        }

        // Loop again to display the multiplication table
        for (int i = 1; i <= 10; i++) {
            System.out.println(number + " * " + i + " = " + table[i - 1]);
            // Print the result in the required format
        }

        sc.close();  
        // Close the Scanner object
    }
}
