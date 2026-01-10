package com.reader.inputstreamreader;

import java.io.*;

public class ConsoleToFile {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FileWriter fw = new FileWriter("C:\\Users\\HP\\Desktop\\Java Programming Workspace\\java-dsa-practice\\gcr-codebase\\javaDsaConcepts\\src\\com\\inputstreamreader\\output.txt");

        String input;
        while (!(input = br.readLine()).equalsIgnoreCase("exit")) {
            fw.write(input + "\n");
        }

        fw.close();
        br.close();
    }
}
