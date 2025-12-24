import java.util.*;

public class TrimSpaces {

    // Method to find start and end index without spaces
    public static int[] findTrimIndex(String s) {

        int start = 0;
        int end = s.length() - 1;

        // Remove leading spaces
        while (start <= end && s.charAt(start) == ' ') {
            start++;
        }

        // Remove trailing spaces
        while (end >= start && s.charAt(end) == ' ') {
            end--;
        }

        return new int[]{start, end};
    }

    // Method to create substring using charAt()
    public static String createSubstring(String s, int start, int end) {

        String result = "";

        for (int i = start; i <= end; i++) {
            result += s.charAt(i);
        }

        return result;
    }

    // Method to compare two strings using charAt()
    public static boolean compareStrings(String s1, String s2) {

        if (s1.length() != s2.length())
            return false;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i))
                return false;
        }
        return true;
    }

    // Main method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the string:");
        String input = sc.nextLine();

        // Trim using user-defined method
        int[] index = findTrimIndex(input);
        String trimmed = createSubstring(input, index[0], index[1]);

        // Trim using built-in method
        String builtInTrim = input.trim();

        // Compare both results
        boolean isSame = compareStrings(trimmed, builtInTrim);

        System.out.println("After trimming: " + trimmed);
        System.out.println("Same as trim() method: " + isSame);
    }
}
