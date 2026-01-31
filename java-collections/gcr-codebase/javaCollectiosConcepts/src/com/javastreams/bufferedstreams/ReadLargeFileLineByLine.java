package com.javastreams.bufferedstreams;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class ReadLargeFileLineByLine {

	    public static void main(String[] args) {

	        // Path to large file (500MB+ supported)
	        String filePath = "C:\\\\Users\\\\ronit\\\\Desktop\\\\Java Programming Workspace\\\\java-collections\\\\gcr-codebase\\\\javaCollections\\\\src\\\\com\\\\javastreams\\\\bufferedstreams\\\\Textfile.txt";

	        // try-with-resources ensures the reader is closed automatically
	        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

	            String line;

	            // Read file line by line
	            while ((line = reader.readLine()) != null) {

	                // Case-insensitive check for "error"
	                if (line.toLowerCase().contains("error")) {
	                    System.out.println(line);
	                }
	            }

	            System.out.println("Finished scanning file.");

	        } catch (IOException e) {
	            System.out.println("Error while reading the file.");
	            e.printStackTrace();
	        }
	    }
	}
