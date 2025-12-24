//program to find vowels and consonants in a string and 
//display the count of  Vowels and Consonants in the string

import java.util.*;

public class VowelConsonantCount {

    // Method to check character type
    public static String checkCharacterType(char ch) {

        // Convert uppercase to lowercase
        if (ch >= 'A' && ch <= 'Z') {
            ch = (char) (ch + 32);
        }

        // Check if alphabet
        if (ch >= 'a' && ch <= 'z') {

            // Check vowel
            if (ch == 'a' || ch == 'e' || ch == 'i' || 
                ch == 'o' || ch == 'u') {
                return "Vowel";
            } else {
                return "Consonant";
            }

        } else {
            return "Not a Letter";
        }
    }

    // Method to count vowels and consonants using charAt()
    public static int[] findVowelsAndConsonants(String s) {

        int vowels = 0;
        int consonants = 0;

        for (int i = 0; i < s.length(); i++) {
            String result = checkCharacterType(s.charAt(i));

            if (result.equals("Vowel")) {
                vowels++;
            } else if (result.equals("Consonant")) {
                consonants++;
            }
        }

        return new int[]{vowels, consonants};
    }

    // Main Method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the string:");
        String s = sc.nextLine();

        int[] count = findVowelsAndConsonants(s);

        System.out.println("Number of Vowels: " + count[0]);
        System.out.println("Number of Consonants: " + count[1]);
    }
}
