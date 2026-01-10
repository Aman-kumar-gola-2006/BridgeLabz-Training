package com.reader.inputstreamreader;

import java.io.*;

public class InputStreamReaderDemo {
	public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream("C:\\Users\\HP\\Desktop\\Java Programming Workspace\\java-dsa-practice\\gcr-codebase\\javaDsaConcepts\\src\\com\\sample.txt"), "UTF-8"));

        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br.close();
    }
}
