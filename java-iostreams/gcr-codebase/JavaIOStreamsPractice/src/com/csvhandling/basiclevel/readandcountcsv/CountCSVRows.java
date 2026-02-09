package com.csvhandling.basiclevel.readandcountcsv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountCSVRows {
	public static void main(String[] args) {
		int count =0;
		
		try (BufferedReader br = new BufferedReader(new FileReader("/Users/macbookair/Desktop/Al/JAVA WORKSPACE/java-iostreams/gcr-codebase/JavaIOStreamsPractice/src/com/csvhandling/basiclevel/readandcountcsv/student.csv"))){
			br.readLine(); // Skip header
			
			while((br.readLine())!=null) {
				count++;
			}
			
			System.out.println("Total Records : "+ count);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
