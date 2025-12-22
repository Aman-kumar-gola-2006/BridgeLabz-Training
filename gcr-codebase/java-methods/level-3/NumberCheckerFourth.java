import java.util.*;

// Utility class to check different properties of a number
public class NumberCheckerFourth {

    // Method to generate a random number using Math.random()
    public static int generateRandomNumber() {
        return (int)(Math.random() * 900) + 100; // random 3-digit number
    }

    // Method to check if number is prime
    public static boolean isPrime(int number) {
        if (number <= 1)
            return false;

        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0)
                return false;
        }
        return true;
    }

    // Method to check if number is a Neon number
    // Sum of digits of square equals the number
    public static boolean isNeon(int number) {
        int square = number * number;
        int sum = 0;

        while (square > 0) {
            sum += square % 10;
            square = square / 10;
        }
        return sum == number;
    }

    // Method to check if number is a Spy number
    // Sum of digits equals product of digits
    public static boolean isSpy(int number) {
        int sum = 0;
        int product = 1;
        int temp = number;

        while (temp > 0) {
            int digit = temp % 10;
            sum += digit;
            product *= digit;
            temp = temp / 10;
        }
        return sum == product;
    }

    // Method to check if number is an Automorphic number
    // Square ends with the number itself
    public static boolean isAutomorphic(int number) {
        int square = number * number;
        return String.valueOf(square).endsWith(String.valueOf(number));
    }

    // Method to check if number is a Buzz number
    // Divisible by 7 or ends with 7
    public static boolean isBuzz(int number) {
        return (number % 7 == 0 || number % 10 == 7);
    }

    // Main method
    public static void main(String[] args) {

        //take avariable to store the random number
		//call generate Random number method for a random number
        int number = generateRandomNumber();
        System.out.println("Generated Number: " + number);


        //calling all the methods
		//And display the output
        System.out.println("Is Prime Number: " + isPrime(number));
        System.out.println("Is Neon Number: " + isNeon(number));
        System.out.println("Is Spy Number: " + isSpy(number));
        System.out.println("Is Automorphic Number: " + isAutomorphic(number));
        System.out.println("Is Buzz Number: " + isBuzz(number));
    }
}