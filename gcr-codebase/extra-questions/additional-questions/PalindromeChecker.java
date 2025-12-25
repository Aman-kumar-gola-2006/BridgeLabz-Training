import java.util.Scanner;

public class PalindromeChecker {

    public static void main(String[] args) {

        String input = takeInput();

        if (isPalindrome(input)) {
            System.out.println("The string is a Palindrome.");
        } else {
            System.out.println("The string is NOT a Palindrome.");
        }
    }

    // Function to take input
    public static String takeInput() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string:");
        return sc.nextLine();
    }

    // Function to check palindrome
    public static boolean isPalindrome(String s) {

        String reverse = "";

        // Reversing the string
        for (int i = s.length() - 1; i >= 0; i--) {
            reverse = reverse + s.charAt(i);
        }

        // Comparing original and reversed string
        return s.equals(reverse);
    }
}
