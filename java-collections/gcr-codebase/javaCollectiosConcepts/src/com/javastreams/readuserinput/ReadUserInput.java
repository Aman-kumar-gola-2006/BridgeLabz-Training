package com.javastreams.readuserinput;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadUserInput {

	    public static void main(String[] args) {

	       
	        try (BufferedReader br =
	                     new BufferedReader(new InputStreamReader(System.in));
	             FileWriter writer =
	                     new FileWriter("C:\\Users\\ronit\\Desktop\\Java Programming Workspace\\java-collections\\gcr-codebase\\javaCollections\\src\\com\\javastreams\\readuserinput\\Textfile.txt")) {

	            // Read user name
	            System.out.print("Enter your name: ");
	            String name = br.readLine();

	            // Read user age
	            System.out.print("Enter your age: ");
	            String age = br.readLine();

	            // Read favorite programming language
	            System.out.print("Enter your favorite programming language: ");
	            String language = br.readLine();

	            // Write data to file
	            writer.write("Name: " + name + "\n");
	            writer.write("Age: " + age + "\n");
	            writer.write("Favorite Programming Language: " + language + "\n");

	            System.out.println("User information saved successfully!");

	        } catch (IOException e) {
	            System.out.println("Error occurred while reading input or writing to file.");
	            e.printStackTrace();
	        }
	    }
	}
