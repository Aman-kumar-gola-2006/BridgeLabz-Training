import java.util.*;

// Program to find first non-repeating character in a string
public class FirstNonRepeatingCharacter {

    // Method to find first non-repeating character
    public static char findFirstNonRepeatingChar(String text) {

        // Array to store frequency of characters (ASCII size = 256)
        int[] frequency = new int[256];

        // Step 1: Count frequency of each character
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            frequency[ch]++;
        }

        // Step 2: Find first character with frequency 1
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (frequency[ch] == 1) {
                return ch;
            }
        }

        // If no non-repeating character found
        return '\0';
    }

    // Main method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a string:");
        String input = sc.nextLine();

        char result = findFirstNonRepeatingChar(input);

        if (result != '\0') {
            System.out.println("First non-repeating character: " + result);
        } else {
            System.out.println("No non-repeating character found");
        }

        sc.close();
    }
}