package com.csvhandling.advancedlevel.mergecsv;

import java.io.*;
import java.util.*;

public class MergeCSV {

    public static void main(String[] args) {

        String file1 = "/Users/macbookair/Desktop/Al/JAVA WORKSPACE/java-iostreams/gcr-codebase/JavaIOStreamsPractice/src/com/csvhandling/advancedlevel/mergecsv/student1.csv";
        String file2 = "/Users/macbookair/Desktop/Al/JAVA WORKSPACE/java-iostreams/gcr-codebase/JavaIOStreamsPractice/src/com/csvhandling/advancedlevel/mergecsv/student2.csv";
        String output = "/Users/macbookair/Desktop/Al/JAVA WORKSPACE/java-iostreams/gcr-codebase/JavaIOStreamsPractice/src/com/csvhandling/advancedlevel/mergecsv/merged.csv";

        Map<String, String[]> studentMap = new HashMap<>();

        try (
                BufferedReader br1 = new BufferedReader(new FileReader(file1));
                BufferedReader br2 = new BufferedReader(new FileReader(file2));
                BufferedWriter bw = new BufferedWriter(new FileWriter(output))
        ) {

            // Skip header of first CSV
            br1.readLine();
            String line;

            // Load students1.csv into map
            while ((line = br1.readLine()) != null) {
                String[] data = line.split(",");
                studentMap.put(data[0], data);
            }

            // Write merged CSV header
            bw.write("ID,Name,Age,Marks,Grade");
            bw.newLine();

            // Skip header of second CSV
            br2.readLine();

            // Merge using ID
            while ((line = br2.readLine()) != null) {
                String[] data2 = line.split(",");
                String[] data1 = studentMap.get(data2[0]);

                if (data1 != null) {
                    bw.write(
                            data1[0] + "," +
                            data1[1] + "," +
                            data1[2] + "," +
                            data2[1] + "," +
                            data2[2]
                    );
                    bw.newLine();
                }
            }

            System.out.println(" CSV files merged successfully!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}