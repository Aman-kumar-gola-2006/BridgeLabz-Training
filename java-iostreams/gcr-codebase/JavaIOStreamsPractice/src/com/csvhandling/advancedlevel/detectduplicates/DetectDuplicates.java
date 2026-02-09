package com.csvhandling.advancedlevel.detectduplicates;

import java.io.*;
import java.util.*;


public class DetectDuplicates {

    public static void main(String[] args) throws IOException {
        Set<String> ids = new HashSet<>();
        BufferedReader br = new BufferedReader(new FileReader("/Users/macbookair/Desktop/Al/JAVA WORKSPACE/java-iostreams/gcr-codebase/JavaIOStreamsPractice/src/com/csvhandling/advancedlevel/detectduplicates/duplicates (1).csv"));
        br.readLine();

        String line;
        while ((line = br.readLine()) != null) {
            String id = line.split(",")[0];

            if (!ids.add(id)) {
                System.out.println("Duplicate: " + line);
            }
        }
        br.close();
    }
}
