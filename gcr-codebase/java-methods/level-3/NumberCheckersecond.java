import java.util.*;

// Utility class to perform various number checks
public class NumberCheckersecond {

    // Method to generate a random number using Math.random()
    public static int generateRandomNumber() 
	{
        return (int)(Math.random() * 9000) + 1000; // random 4-digit number
    }

    // Method to find the count of digits in the number
    public static int countDigits(int number) {
        int count = 0;
        while (number > 0) {
            count++;
            number = number / 10;
        }
        return count;
    }

    // Method to store digits of the number in an array
    public static int[] storeDigits(int number, int count) {
        int[] digits = new int[count];
        int index = 0;

        while (number > 0) {
            digits[index] = number % 10;
            number = number / 10;
            index++;
        }
        return digits;
    }

    // Method to find sum of digits using digits array
    public static int sumOfDigits(int[] digits) {
        int sum = 0;
        for (int i = 0; i < digits.length; i++) {
            sum += digits[i];
        }
        return sum;
    }

    // Method to find sum of squares of digits using Math.pow()
    public static int sumOfSquaresOfDigits(int[] digits) {
        int sum = 0;
        for (int i = 0; i < digits.length; i++) {
            sum += Math.pow(digits[i], 2);
        }
        return sum;
    }

    // Method to check if number is a Harshad number
    public static boolean isHarshadNumber(int number, int[] digits) {
        int sum = sumOfDigits(digits);
        return number % sum == 0;
    }

    // Method to find frequency of each digit using 2D array
    public static int[][] digitFrequency(int[] digits) {
        int[][] freq = new int[10][2];

        // initialize digits in first column
        for (int i = 0; i < 10; i++) {
            freq[i][0] = i;
        }

        // count frequency
        for (int i = 0; i < digits.length; i++) {
            freq[digits[i]][1]++;
        }

        return freq;
    }

    // Main method
    public static void main(String[] args) {
         
		//taking a number varialbe to store the random number 
        int number = generateRandomNumber();
        System.out.println("Generated Number: " + number);

        int count = countDigits(number);
        int[] digits = storeDigits(number, count);

        System.out.println("Count of Digits: " + count);

        System.out.print("Digits: ");
        for (int d : digits) {
            System.out.print(d + " ");
        }
        System.out.println();

        System.out.println("Sum of Digits: " + sumOfDigits(digits));
        System.out.println("Sum of Squares of Digits: " + sumOfSquaresOfDigits(digits));
        System.out.println("Is Harshad Number: " + isHarshadNumber(number, digits));

        int[][] frequency = digitFrequency(digits);

        System.out.println("Digit Frequency:");
        for (int i = 0; i < frequency.length; i++) {
            if (frequency[i][1] > 0) {
                System.out.println("Digit " + frequency[i][0] + " occurs " + frequency[i][1] + " times");
            }
        }
    }
}