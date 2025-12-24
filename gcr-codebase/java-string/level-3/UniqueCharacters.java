import java.util.*;

public class UniqueCharacters {

    // Method to find length of string without using length()
    public static int findLength(String s) {
        int count = 0;
        for (char ch : s.toCharArray()) {
            count++;
        }
        return count;
    }

    // Method to find unique characters using charAt()
    public static char[] findUniqueCharacters(String s) {

        int len = findLength(s);
        char[] temp = new char[len];
        int index = 0;

        // Outer loop to pick each character
        for (int i = 0; i < len; i++) {
            char current = s.charAt(i);
            boolean isUnique = true;

            // Inner loop to compare with previous characters
            for (int j = 0; j < i; j++) {
                if (current == s.charAt(j)) {
                    isUnique = false;
                    break;
                }
            }

            // Store unique character
            if (isUnique) {
                temp[index] = current;
                index++;
            }
        }

        // Create new array for exact unique characters
        char[] result = new char[index];
        for (int i = 0; i < index; i++) {
            result[i] = temp[i];
        }

        return result;
    }

    // Main method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the string:");
        String input = sc.nextLine();

        char[] uniqueChars = findUniqueCharacters(input);

        System.out.println("Unique characters are:");
        for (int i = 0; i < uniqueChars.length; i++) {
            System.out.print(uniqueChars[i] + " ");
        }
    }
}
