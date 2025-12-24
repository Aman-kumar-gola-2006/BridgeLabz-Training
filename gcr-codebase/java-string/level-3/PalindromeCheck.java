import java.util.Scanner;

public class PalindromeCheck {

    // LOGIC 1: Check palindrome using start and end index (loop)
    public static boolean isPalindromeLoop(String text) {

        int start = 0;
        int end = text.length() - 1;

        while (start < end) {
            if (text.charAt(start) != text.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    // LOGIC 2: Check palindrome using recursion
    public static boolean isPalindromeRecursive(String text, int start, int end) {

        if (start >= end) {
            return true;
        }

        if (text.charAt(start) != text.charAt(end)) {
            return false;
        }

        return isPalindromeRecursive(text, start + 1, end - 1);
    }

    // Method to reverse string using charAt()
    public static char[] reverseString(String text) {

        char[] reverse = new char[text.length()];
        int index = 0;

        for (int i = text.length() - 1; i >= 0; i--) {
            reverse[index] = text.charAt(i);
            index++;
        }

        return reverse;
    }

    // LOGIC 3: Check palindrome using character arrays
    public static boolean isPalindromeArray(String text) {

        char[] original = text.toCharArray();
        char[] reverse = reverseString(text);

        for (int i = 0; i < original.length; i++) {
            if (original[i] != reverse[i]) {
                return false;
            }
        }
        return true;
    }

    // Main method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the text:");
        String input = sc.nextLine();

        boolean result1 = isPalindromeLoop(input);
        boolean result2 = isPalindromeRecursive(input, 0, input.length() - 1);
        boolean result3 = isPalindromeArray(input);

        System.out.println("\nPalindrome Check Results:");
        System.out.println("Using Loop Method: " + result1);
        System.out.println("Using Recursive Method: " + result2);
        System.out.println("Using Array Method: " + result3);

        sc.close();
    }
}
