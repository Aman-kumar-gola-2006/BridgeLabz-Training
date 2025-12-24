import java.util.*;

// Program to find frequency of characters using nested loops
public class CharacterFrequencyNestedLoop {

    // Method to find frequency of characters
    public static String[] findFrequency(String text) {

        // Convert string to character array
        char[] chars = text.toCharArray();
        int n = chars.length;

        // Frequency array
        int[] freq = new int[n];

        // Step 1: Calculate frequency using nested loops
        for (int i = 0; i < n; i++) {

            if (chars[i] == '0')
                continue;

            freq[i] = 1;

            for (int j = i + 1; j < n; j++) {
                if (chars[i] == chars[j]) {
                    freq[i]++;
                    chars[j] = '0'; // mark duplicate
                }
            }
        }

        // Step 2: Count unique characters
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (chars[i] != '0')
                count++;
        }

        // Step 3: Store character and frequency in 1D String array
        String[] result = new String[count];
        int index = 0;

        for (int i = 0; i < n; i++) {
            if (chars[i] != '0') {
                result[index] = chars[i] + " -> " + freq[i];
                index++;
            }
        }

        return result;
    }

    // Main method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a string:");
        String input = sc.nextLine();

        String[] result = findFrequency(input);

        System.out.println("\nCharacter Frequency:");
        System.out.println("---------------------");

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }

        sc.close();
    }
}