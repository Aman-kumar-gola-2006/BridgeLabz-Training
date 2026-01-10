package com.reader.filereader;

import java.io.*;

public class ReadFile {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\HP\\Desktop\\Java Programming Workspace\\java-dsa-practice\\gcr-codebase\\javaDsaConcepts\\src\\com\\filereader\\sample.txt"));
        String line;

        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br.close();
    }
}