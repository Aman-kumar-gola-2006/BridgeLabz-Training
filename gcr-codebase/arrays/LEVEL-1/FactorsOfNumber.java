import java.util.Scanner;   // Import Scanner for input

public class FactorsOfNumber {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();   // Take number input

        int maxFactor = 10;          // Initial size of factors array
        int[] factors = new int[maxFactor];
        int index = 0;               // Index to store factors

        // Loop from 1 to number to find factors
        for (int i = 1; i <= number; i++) {

            // Check if i is a factor of number
            if (number % i == 0) {

                // If array is full, increase its size
                if (index == maxFactor) {

                    maxFactor = maxFactor * 2;        // Double the size
                    int[] temp = new int[maxFactor]; // Create temp array

                    // Copy old array elements to temp array
                    for (int j = 0; j < index; j++) {
                        temp[j] = factors[j];
                    }

                    factors = temp;   // Assign temp array to factors
                }

                factors[index] = i;   // Store factor
                index++;              // Increment index
            }
        }

        // Display factors
        System.out.println("Factors of " + number + " are:");
        for (int i = 0; i < index; i++) {
            System.out.print(factors[i] + " ");
        }

        sc.close();
    }
}
