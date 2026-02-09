package com.csvhandling.advancedlevel.validatecsv;


import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

public class ValidateCSV {

    static Pattern emailPattern =
            Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");

    static Pattern phonePattern =
            Pattern.compile("\\d{10}");

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("/Users/macbookair/Desktop/Al/JAVA WORKSPACE/java-iostreams/gcr-codebase/JavaIOStreamsPractice/src/com/csvhandling/advancedlevel/validatecsv/users.csv"));
        br.readLine(); // header

        String line;
        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");
            String email = data[2];
            String phone = data[3];

            if (!emailPattern.matcher(email).matches()
                    || !phonePattern.matcher(phone).matches()) {
                System.out.println("Invalid Row: " + line);
            }
        }
        br.close();
    }
}