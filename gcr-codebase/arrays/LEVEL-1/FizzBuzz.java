import java.util.Scanner;

public class FizzBuzz {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take input from user
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        // Check if number is a positive integer
        if (number <= 0) {
            System.out.println("Please enter a positive integer.");
            sc.close();
            return;
        }

        // Create String array to store results
        String[] result = new String[number + 1];

        // Loop from 0 to number and store FizzBuzz values
        for (int i = 0; i <= number; i++) {

            if (i == 0) {
                result[i] = "0";
            } 
            else if (i % 3 == 0 && i % 5 == 0) {
                result[i] = "FizzBuzz";
            } 
            else if (i % 3 == 0) {
                result[i] = "Fizz";
            } 
            else if (i % 5 == 0) {
                result[i] = "Buzz";
            } 
            else {
                result[i] = String.valueOf(i);
            }
        }

        // Display results with index position
        for (int i = 0; i < result.length; i++) {
            System.out.println("Position " + i + " = " + result[i]);
        }

        sc.close();
    }
}
