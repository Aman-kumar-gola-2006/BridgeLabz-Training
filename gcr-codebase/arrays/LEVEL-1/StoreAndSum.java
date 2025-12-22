import java.util.Scanner;   // Import Scanner class for user input

public class StoreAndSum {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);  
        // Create Scanner object

        double[] arr = new double[10];  
        // Declare an array of size 10 to store double values

        double total = 0.0;  
        // Variable to store the sum of all numbers, initialized to 0.0

        int index = 0;  
        // Index variable for array, initialized to 0

        // Infinite while loop
        while (true) {

            System.out.print("Enter a number: ");  
            // Ask user to enter a number

            double num = sc.nextDouble();  
            // Read user input

            // Check if number is 0 or negative
            if (num <= 0) {
                break;  
                // Break the loop if input is 0 or negative
            }

            // Check if array size limit (10) is reached
            if (index == 10) {
                break;  
                // Break the loop if array is full
            }

            arr[index] = num;  
            // Store the number in the array

            index++;  
            // Increment index value
        }

        // Loop to display numbers and calculate total
        System.out.println("Stored numbers:");
        for (int i = 0; i < index; i++) {
            System.out.println(arr[i]);  
            // Print each number

            total = total + arr[i];  
            // Add each number to total
        }

        // Display the total sum
        System.out.println("Total sum = " + total);

        sc.close();  
        // Close the Scanner
    }
}
