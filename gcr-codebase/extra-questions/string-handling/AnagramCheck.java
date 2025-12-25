// Java program that accepts two strings from the user and checks if the two
// strings are anagrams of each other 
// (i.e., whether they contain the same characters in any order).

import java.util.Scanner;

public class AnagramCheck {

    // Method to check if two texts are anagrams
    public static boolean isAnagram(String s1, String s2) {

        // Remove spaces and convert to lowercase
        s1 = s1.replace(" ", "").toLowerCase();
        s2 = s2.replace(" ", "").toLowerCase();

        // Check length
        if (s1.length() != s2.length()) {
            return false;
        }

        // Array to store frequency of characters
        int[] freq = new int[26];

        // Count frequency of characters in first string
        for (int i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);
            freq[ch - 'a']++;
        }

        // Reduce frequency using second string
        for (int i = 0; i < s2.length(); i++) {
            char ch = s2.charAt(i);
            freq[ch - 'a']--;
        }

        // Check if all frequencies are zero
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] != 0) {
                return false;
            }
        }

        return true;
    }

    // Main method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter first text:");
        String text1 = sc.nextLine();

        System.out.println("Enter second text:");
        String text2 = sc.nextLine();

        boolean result = isAnagram(text1, text2);

        if (result) {
            System.out.println("The texts are anagrams.");
        } else {
            System.out.println("The texts are not anagrams.");
        }

        sc.close();
    }
}
