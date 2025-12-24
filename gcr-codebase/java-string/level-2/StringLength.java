import java.util.*;

// Program to find length of a string without using length() method
public class StringLength {

    // Method to find length without using length()
    public static int findLength(String text) {

        int count = 0;

        // Infinite loop
        while (true) {
            try {
                text.charAt(count); // access character
                count++;            // increase count
            } catch (Exception e) {
                // Exception occurs when index is out of range
                break;
            }
        }
        return count;
    }

    // Main method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Taking input using next()
        System.out.println("Enter a string:");
        String input = sc.next();

        // Calling user-defined method
        int calculatedLength = findLength(input);

        // Calling built-in length() method
        int actualLength = input.length();

        // Displaying results
        System.out.println("Length without using length() method: " + calculatedLength);
        System.out.println("Length using built-in length() method: " + actualLength);

        sc.close();
    }
}