package com.reader.filereader;

import java.io.BufferedReader;
import java.io.FileReader;

public class CountOccurrence 
{

	    public static void main(String[] args) throws Exception {

	        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\HP\\Desktop\\Java Programming Workspace\\java-dsa-practice\\gcr-codebase\\javaDsaConcepts\\src\\com\\filereader\\sample.txt"));
	        String line;
	        int count = 0;
	        String word = "java";

	        while ((line = br.readLine()) != null) {
	            String[] words = line.split("\\s+");
	            for (String w : words) {
	                if (w.equalsIgnoreCase(word))
	                    count++;
	            }
	        }
	        br.close();
	        System.out.println("Occurrences: " + count);
	    }
	

}