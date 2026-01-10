package com.searchingalgorithm.linearsearch;

import java.util.Scanner;

public class SentenceSearch {

    // Returns first sentence containing the word
    public static String search(String[] sentences, String word) {
        for (String s : sentences) {
            if (s.contains(word))
                return s;
        }
        return "Not Found";
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read number of sentences
        System.out.print("Enter number of sentences: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        String[] sentences = new String[n];

        // Read sentences
        System.out.println("Enter sentences:");
        for (int i = 0; i < n; i++) {
            sentences[i] = sc.nextLine();
        }

        // Read search word
        System.out.print("Enter word to search: ");
        String word = sc.nextLine();

        // Perform linear search
        String result = search(sentences, word);

        // Display result
        System.out.println("Result: " + result);

        sc.close();
    }
}
