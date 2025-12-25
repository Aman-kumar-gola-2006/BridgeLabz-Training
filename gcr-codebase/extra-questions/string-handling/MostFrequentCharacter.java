// Write a Java program to find the most frequent character in a string

import java.util.*;

public class MostFrequentCharacter {

 public static void findMostFrequentCharacter(String s) {

        int[] frequency = new int[256]; 

        //Count frequency of each character
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            frequency[ch]++;
        }

        //Find maximum frequency
        char mostFrequentChar = ' ';
        int maxFreq = 0;

        for (int i = 0; i < frequency.length; i++) {
            if (frequency[i] > maxFreq) {
                maxFreq = frequency[i];
                mostFrequentChar = (char) i;
            }
        }

        //  Display result
       
        System.out.println("Most frequent character: " + mostFrequentChar + "   Frequency: " + maxFreq);
    }

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the sentence:");
        String s = sc.nextLine();

        findMostFrequentCharacter(s);
        sc.close();
    }

   
}