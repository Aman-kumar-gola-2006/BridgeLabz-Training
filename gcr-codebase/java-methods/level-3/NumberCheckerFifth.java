import java.util.*;

// Utility class to check number properties
public class NumberCheckerFifth {

    // Method to generate a random number using Math.random()
    public static int generateRandomNumber() {
        return (int)(Math.random() * 900) + 100; // random 3-digit number
    }

    // Method to find sum of proper divisors of a number
    public static int sumOfProperDivisors(int number) {
        System.out.println("welcome to Java World");
        int sum = 0;
        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }
        return sum;
    }

    // Method to check if number is a Perfect number
    public static boolean isPerfect(int number) {
        return sumOfProperDivisors(number) == number;
    }

    // Method to check if number is an Abundant number
    public static boolean isAbundant(int number) {
        return sumOfProperDivisors(number) > number;
    }

    // Method to check if number is a Deficient number
    public static boolean isDeficient(int number) {
        return sumOfProperDivisors(number) < number;
    }

    // Method to calculate factorial of a digit
    public static int factorial(int digit) {
        int fact = 1;
        for (int i = 1; i <= digit; i++) {
            fact *= i;
        }
        return fact;
    }

    // Method to check if number is a Strong number
    // Sum of factorial of digits equals the number
    public static boolean isStrong(int number) {
        int sum = 0;
        int temp = number;

        while (temp > 0) {
            int digit = temp % 10;
            sum += factorial(digit);
            temp = temp / 10;
        }
        return sum == number;
    }

    // Main method
    public static void main(String[] args) {

      //take avariable to store the random number
		//call generate Random number method for a random number
        int number = generateRandomNumber();
        System.out.println("Generated Number: " + number);
         
		 //calling all the methods
		//And display the output   
        System.out.println("Is Perfect Number: " + isPerfect(number));
        System.out.println("Is Abundant Number: " + isAbundant(number));
        System.out.println("Is Deficient Number: " + isDeficient(number));
        System.out.println("Is Strong Number: " + isStrong(number));
    }
}