package com.csvhandling.intermediatelevel.searchemployee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SearchEmployee {
	public static void main(String[] args) throws IOException {
		String searchName = "Abhay";
		BufferedReader br = new BufferedReader(new FileReader("/Users/macbookair/Desktop/Al/JAVA WORKSPACE/java-iostreams/gcr-codebase/JavaIOStreamsPractice/src/com/csvhandling/intermediatelevel/searchemployee/SearchEmployees.csv"));
		br.readLine();
		
		String line;
		while((line = br.readLine())!=null) {
			String data [] = line.split(",");
			
			if(data[1].equalsIgnoreCase(searchName)) {
				  System.out.println("Department: " + data[2]);
	                System.out.println("Salary: " + data[3]);
	                break;
			}
		}
		br.close();
	}
}
