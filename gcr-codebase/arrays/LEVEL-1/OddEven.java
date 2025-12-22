import java.util.Scanner;   // Import Scanner class for input

public class OddEvenArray {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        // Create Scanner object

        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        // Take integer input from user

        // Check for Natural Number
        if (number <= 0) {
            System.out.println("Error: Please enter a natural number.");
            sc.close();
            return;
            // Exit the program if not a natural number
        }

        int size = number / 2 + 1;
        // Size of odd and even arrays

        int[] odd = new int[size];
        int[] even = new int[size];
        // Create odd and even arrays

        int oddIndex = 0;
        int evenIndex = 0;
        // Index variables for odd and even arrays

        // Loop from 1 to number
        for (int i = 1; i <= number; i++) {

            if (i % 2 == 0) {
                even[evenIndex] = i;
                evenIndex++;
                // Store even number
            } else {
                odd[oddIndex] = i;
                oddIndex++;
                // Store odd number
            }
        }

        // Print odd numbers
        System.out.println("Odd Numbers:");
        for (int i = 0; i < oddIndex; i++) {
            System.out.print(odd[i] + " ");
        }

        // Print even numbers
        System.out.println("\nEven Numbers:");
        for (int i = 0; i < evenIndex; i++) {
            System.out.print(even[i] + " ");
        }

        sc.close();
        // Close Scanner
    }
}
