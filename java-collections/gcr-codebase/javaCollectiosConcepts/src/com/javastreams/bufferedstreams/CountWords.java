package com.javastreams.bufferedstreams;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class CountWords {
	
	    public static void main(String[] args) {

	        String filePath = "C:\\\\Users\\\\ronit\\\\Desktop\\\\Java Programming Workspace\\\\java-collections\\\\gcr-codebase\\\\javaCollections\\\\src\\\\com\\\\javastreams\\\\bufferedstreams\\\\Textfile.txt"; // path to text file
	        Map<String, Integer> wordCount = new HashMap<>();

	        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

	            String line;

	            // Read file line by line
	            while ((line = br.readLine()) != null) {

	                // Normalize text
	                line = line.toLowerCase().replaceAll("[^a-z0-9 ]", "");

	                // Split into words
	                String[] words = line.split("\\s+");

	                for (String word : words) {
	                    if (!word.isEmpty()) {
	                        wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
	                    }
	                }
	            }

	        } catch (IOException e) {
	            System.out.println("Error reading the file.");
	            e.printStackTrace();
	            return;
	        }

	        // Sort words by frequency (descending)
	        List<Map.Entry<String, Integer>> sortedList =
	                new ArrayList<>(wordCount.entrySet());

	        sortedList.sort((a, b) -> b.getValue() - a.getValue());

	        // Display top 5 words
	        System.out.println("Top 5 Most Frequent Words:");
	        for (int i = 0; i < Math.min(5, sortedList.size()); i++) {
	            Map.Entry<String, Integer> entry = sortedList.get(i);
	            System.out.println((i + 1) + ". " + entry.getKey() + " → " + entry.getValue());
	        }
	    }
	}