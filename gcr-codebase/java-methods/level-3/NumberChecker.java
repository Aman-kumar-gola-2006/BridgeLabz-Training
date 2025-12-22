import java.util.*;

// Utility class to perform various number checks
public class NumberChecker {

    // Method to find count of digits in the number
    public static int countDigits(long number) {
        System.out.println("welcome to Java World");
        int count = 0;
        while (number > 0) {
            count++;
            number = number / 10;
        }
        return count;
    }

    // Method to store digits of the number in an array
    public static int[] storeDigits(long number, int count) {
        int[] digits = new int[count];
        int index = 0;

        while (number > 0) {
            digits[index] = (int)(number % 10);
            number = number / 10;
            index++;
        }
        return digits;
    }

    // Method to check if number is a Duck number
    // Duck number has at least one non-zero digit
    public static boolean isDuckNumber(int[] digits) {
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] != 0) {
                return true;
            }
        }
        return false;
    }

    // Method to check if number is an Armstrong number
    public static boolean isArmstrong(long number, int[] digits) {
        int power = digits.length;
        long sum = 0;

        for (int i = 0; i < digits.length; i++) {
            sum += Math.pow(digits[i], power);
        }
        return sum == number;
    }

    // Method to find largest and second largest digit
    public static int[] findLargestAndSecondLargest(int[] digits) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int i = 0; i < digits.length; i++) {
            if (digits[i] > largest) {
                secondLargest = largest;
                largest = digits[i];
            } else if (digits[i] > secondLargest && digits[i] != largest) {
                secondLargest = digits[i];
            }
        }
        return new int[]{largest, secondLargest};
    }

    // Method to find smallest and second smallest digit
    public static int[] findSmallestAndSecondSmallest(int[] digits) {
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        for (int i = 0; i < digits.length; i++) {
            if (digits[i] < smallest) {
                secondSmallest = smallest;
                smallest = digits[i];
            } else if (digits[i] < secondSmallest && digits[i] != smallest) {
                secondSmallest = digits[i];
            }
        }
        return new int[]{smallest, secondSmallest};
    }

    // Main method
    public static void main(String[] args) {
        
       //create a scanner class object		
        Scanner sc = new Scanner(System.in);
     //taking input from the user 
        System.out.println("Enter a number");
        long number = sc.nextLong();

        int count = countDigits(number);
        int[] digits = storeDigits(number, count);

        System.out.println("Count of digits: " + count);

        System.out.print("Digits: ");
        for (int d : digits) {
            System.out.print(d + " ");
        }
        System.out.println();

        System.out.println("Is Duck Number: " + isDuckNumber(digits));
        System.out.println("Is Armstrong Number: " + isArmstrong(number, digits));

        int[] largest = findLargestAndSecondLargest(digits);
        System.out.println("Largest Digit: " + largest[0]);
        System.out.println("Second Largest Digit: " + largest[1]);

        int[] smallest = findSmallestAndSecondSmallest(digits);
        System.out.println("Smallest Digit: " + smallest[0]);
        System.out.println("Second Smallest Digit: " + smallest[1]);

        sc.close();
    }
}