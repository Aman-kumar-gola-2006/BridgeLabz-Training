package com.csvhandling.intermediatelevel.modifycsv;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class UpdateSalary {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("/Users/macbookair/Desktop/Al/JAVA WORKSPACE/java-iostreams/gcr-codebase/JavaIOStreamsPractice/src/com/csvhandling/intermediatelevel/modifycsv/employee.csv"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("/Users/macbookair/Desktop/Al/JAVA WORKSPACE/java-iostreams/gcr-codebase/JavaIOStreamsPractice/src/com/csvhandling/intermediatelevel/modifycsv/updated_employee.csv"));
		
		String line=br.readLine();
		bw.write(line);
		bw.newLine();
		
		while((line= br.readLine())!=null) {
			String [] data = line.split(",");
			
			if(data[2].equalsIgnoreCase("IT")){
				double salary = Double.parseDouble(data[3]);
				salary = salary + salary*0.10;
				data[3]=String.valueOf(salary);
			}
			
			bw.write(String.join(",", data));
			bw.newLine();
		}
		
		br.close();
		bw.close();
	}
}
