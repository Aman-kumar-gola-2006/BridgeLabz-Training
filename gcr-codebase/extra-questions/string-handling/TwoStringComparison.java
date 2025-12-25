// program to compare two strings in dictionary order

import java.util.*;

public class TwoStringComparison {

    public static void compareStrings(String s1, String s2) {
		
        int minLength = Math.min(s1.length(), s2.length());

        for (int i = 0; i < minLength; i++) {
            if (s1.charAt(i) < s2.charAt(i)) {
                System.out.println("\"" + s1 + "\" comes before \"" + s2 + "\" in lexicographical order");
                return;
            } 
            else if (s1.charAt(i) > s2.charAt(i)) {
                System.out.println("\"" + s1 + "\" comes after \"" + s2 + "\" in lexicographical order");
                return;
            }
        }

        // If all characters are same till min length
        if (s1.length() < s2.length()) {
            System.out.println("\"" + s1 + "\" comes before \"" + s2 + "\" in lexicographical order");
        } 
        else if (s1.length() > s2.length()) {
            System.out.println("\"" + s1 + "\" comes after \"" + s2 + "\" in lexicographical order");
        } 
        else {
            System.out.println("Both strings are equal");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the 1st String:");
        String s1 = sc.next();

        System.out.println("Enter the 2nd String:");
        String s2 = sc.next();

        compareStrings(s1, s2);
    }
}
