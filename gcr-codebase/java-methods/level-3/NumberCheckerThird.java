import java.util.*;

// Utility class to perform number related checks
public class NumberCheckerThird {

    // Method to find the count of digits in the number
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

    // Method to reverse the digits array
    public static int[] reverseArray(int[] digits) {
        int[] reversed = new int[digits.length];
        for (int i = 0; i < digits.length; i++) {
            reversed[i] = digits[digits.length - 1 - i];
        }
        return reversed;
    }

    // Method to compare two arrays
    public static boolean compareArrays(int[] a, int[] b) {
        if (a.length != b.length)
            return false;

        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i])
                return false;
        }
        return true;
    }

    // Method to check if the number is a palindrome
    public static boolean isPalindrome(int[] digits) {
        int[] reversed = reverseArray(digits);
        return compareArrays(digits, reversed);
    }

    // Method to check if number is a Duck number
    // Duck number contains at least one non-zero digit
    public static boolean isDuckNumber(int[] digits) {
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] != 0)
                return true;
        }
        return false;
    }

    // Main method
    public static void main(String[] args) {
        
		//create a scanner class object
        Scanner sc = new Scanner(System.in);
        
		//taking input from the user 
        System.out.println("Enter a number");
        long number = sc.nextLong();

        //take a variable to store the count method output 
        int count = countDigits(number);
        int[] digits = storeDigits(number, count);

        //display the count 
        System.out.println("Count of Digits: " + count);

        //displaythe digits    
        System.out.print("Digits Array: ");
        for (int d : digits) {
            System.out.print(d + " ");
        }
        System.out.println();
        
		//call reverse method to reversethe digits array
        int[] reversed = reverseArray(digits);
        System.out.print("Reversed Digits: ");
        for (int d : reversed) {
            System.out.print(d + " ");
        }
        System.out.println();

        System.out.println("Arrays Equal: " + compareArrays(digits, reversed));
        System.out.println("Is Palindrome Number: " + isPalindrome(digits));
        System.out.println("Is Duck Number: " + isDuckNumber(digits));

        sc.close();
    }
}