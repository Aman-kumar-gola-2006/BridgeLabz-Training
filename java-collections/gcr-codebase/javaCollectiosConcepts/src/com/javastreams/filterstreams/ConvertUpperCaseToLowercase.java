package com.javastreams.filterstreams;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class ConvertUpperCaseToLowercase {
	
    public static void main(String[] args) {

        String sourceFile = "C:\\Users\\ronit\\Desktop\\Java Programming Workspace\\java-collections\\gcr-codebase\\javaCollections\\src\\com\\javastreams\\filterstreams\\input.txt";
        String destinationFile ="C:\\Users\\ronit\\Desktop\\Java Programming Workspace\\java-collections\\gcr-codebase\\javaCollections\\src\\com\\javastreams\\filterstreams\\output.txt";
        // try-with-resources ensures automatic closing of streams
        try (BufferedReader reader =
                     new BufferedReader(new FileReader(sourceFile));
             BufferedWriter writer =
                     new BufferedWriter(new FileWriter(destinationFile))) {

            int character;

            // Read character by character
            while ((character = reader.read()) != -1) {

                // Convert uppercase characters to lowercase
                char lowerChar = Character.toLowerCase((char) character);

                // Write converted character to destination file
                writer.write(lowerChar);
            }

            System.out.println("File processed successfully. Uppercase converted to lowercase.");

        } catch (IOException e) {
            System.out.println("Error while reading or writing the file.");
            e.printStackTrace();
        }
    }
}
