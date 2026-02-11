package com.csvhandling.intermediatelevel.filterstudent;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FilterStudents {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("/Users/macbookair/Desktop/Al/JAVA WORKSPACE/java-iostreams/gcr-codebase/JavaIOStreamsPractice/src/com/csvhandling/intermediatelevel/filterstudent/studentmarks.csv"));
		br.readLine();
		
		String line;
		
		while((line = br.readLine())!=null) {
			String [] data = line.split(",");
			int marks = Integer.parseInt(data[3]);
			
			if(marks>80) {
				System.out.println(Arrays.toString(data));
			}
		}
		
		br.close();
	}
}
