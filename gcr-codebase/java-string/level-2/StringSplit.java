import java.util.*;

// Program to split string and store words with their lengths
public class StringSplit {

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
            if (text.charAt(i) == ' ')
                spaceIndex[index++] = i;
        }
        spaceIndex[index] = length;

        // Step 3: Extract words
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

    // Method to store word and its length in 2D array
    public static String[][] wordLength(String[] words) {

        String[][] result = new String[words.length][2];

        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(findLength(words[i]));
        }

        return result;
    }

    // Main method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a sentence:");
        String input = sc.nextLine();

        String[] customWords = customSplit(input);
        String[][] ans = wordLength(customWords);

        // Display result in tabular format
        System.out.println("\nWord\tLength");
        System.out.println("--------------");

        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i][0] + "\t" + Integer.parseInt(ans[i][1]));
        }

        sc.close();
    }
}