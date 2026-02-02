package com.exceptions.checkedexception;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\ronit\\Desktop\\Java Programming Workspace\\java-collections\\gcr-codebase\\javaCollections\\src\\com\\exceptions\\checkedexception\\data.txt"));
			String line;
			
			while((line = br.readLine()) != null) {
				System.out.println(line);
			}
			br.close();
		} catch (IOException e ) {
			System.out.println("File Not Found");
		}
	}
}
