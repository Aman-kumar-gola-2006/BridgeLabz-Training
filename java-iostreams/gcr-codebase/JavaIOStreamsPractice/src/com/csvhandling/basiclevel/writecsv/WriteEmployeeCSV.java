package com.csvhandling.basiclevel.writecsv;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteEmployeeCSV {
	public static void main(String[] args) {
		String filePath = "/Users/macbookair/Desktop/Al/JAVA WORKSPACE/java-iostreams/gcr-codebase/JavaIOStreamsPractice/src/com/csvhandling/basiclevel/writecsv/employees.csv";
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));
	
			bw.write("ID, Name, Department, Salary");
			bw.newLine();

			// Write Records
			bw.write("1, John, IT, 60000");
			bw.newLine();
			bw.write("2,Alice,HR,50000");
			bw.newLine();
			bw.write("3,Bob,Finance,70000");
			bw.newLine();
			bw.write("4,Eva,IT,80000");
			bw.newLine();
			bw.write("5,Tom,Sales,45000");
			
			System.out.println("CSV File Written Successfully");
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
}
