import java.util.*;

// Program to split string without using split() method
public class StringSplitWithoutSplitMethod {

    // Method to find length of string without using length()
    public static int findLength(String text) {

        int count = 0;

        while (true) {
            try {
                text.charAt(count);
                count++;
            } catch (Exception e) {
                break;
            }
        }
        return count;
    }

    // Method to split string into words without using split()
    public static String[] customSplit(String text) {

        int length = findLength(text);

        // Step 1: Count words
        int wordCount = 1;
        for (int i = 0; i < length; i++) {
            if (text.charAt(i) == ' ')
                wordCount++;
        }

        // Step 2: Store space indexes
        int[] spaceIndex = new int[wordCount + 1];
        spaceIndex[0] = -1;

        int index = 1;
        for (int i = 0; i < length; i++) {
            if (text.charAt(i) == ' ') {
                spaceIndex[index++] = i;
            }
        }
        spaceIndex[index] = length;

        // Step 3: Extract words using indexes
        String[] words = new String[wordCount];

        for (int i = 0; i < wordCount; i++) {
            String word = "";
            for (int j = spaceIndex[i] + 1; j < spaceIndex[i + 1]; j++) {
                word = word + text.charAt(j);
            }
            words[i] = word;
        }

        return words;
    }

    // Method to compare two String arrays
    public static boolean compareArrays(String[] a, String[] b) {

        if (a.length != b.length)
            return false;

        for (int i = 0; i < a.length; i++) {
            if (!a[i].equals(b[i]))
                return false;
        }
        return true;
    }

    // Main method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Taking input using nextLine()
        System.out.println("Enter a sentence:");
        String input = sc.nextLine();

        // User-defined split
        String[] customWords = customSplit(input);

        // Built-in split
        String[] builtInWords = input.split(" ");

        // Display words
        System.out.println("\nWords using custom split:");
        for (String w : customWords) {
            System.out.println(w);
        }

        System.out.println("\nWords using built-in split:");
        for (String w : builtInWords) {
            System.out.println(w);
        }

        // Compare both results
        boolean result = compareArrays(customWords, builtInWords);
        System.out.println("\nBoth results are same: " + result);

        sc.close();
    }
}