package com.javastreams.datastreams;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class StoreAndRetrievePrimitiveData {


	    private static final String FILE_NAME = "C:\\Users\\ronit\\Desktop\\Java Programming Workspace\\java-collections\\gcr-codebase\\javaCollections\\src\\com\\javastreams\\datastreams\\data.txt";

	    /**
	     * Writes student details to a binary file using DataOutputStream
	     */
	    private static void writeStudentData() {

	        // try-with-resources ensures streams are closed automatically
	        try (DataOutputStream dos =
	                     new DataOutputStream(new FileOutputStream(FILE_NAME))) {

	            int rollNumber = 101;
	            String name = "Shifa";
	            double gpa = 8.7;

	            // Writing primitive data
	            dos.writeInt(rollNumber);
	            dos.writeUTF(name);
	            dos.writeDouble(gpa);

	            System.out.println("Student data written successfully.");

	        } catch (IOException e) {
	            System.out.println("Error while writing student data.");
	            e.printStackTrace();
	        }
	    }

	    /**
	     * Reads student details from a binary file using DataInputStream
	     */
	    private static void readStudentData() {

	        try (DataInputStream dis =
	                     new DataInputStream(new FileInputStream(FILE_NAME))) {

	            // Reading data in the SAME order
	            int rollNumber = dis.readInt();
	            String name = dis.readUTF();
	            double gpa = dis.readDouble();

	            System.out.println("\nRetrieved Student Data:");
	            System.out.println("Roll Number: " + rollNumber);
	            System.out.println("Name: " + name);
	            System.out.println("GPA: " + gpa);

	        } catch (IOException e) {
	            System.out.println("Error while reading student data.");
	            e.printStackTrace();
	        }
	    }
	    
	    
	    public static void main(String[] args) {

	        // Write student data to file
	        writeStudentData();

	        // Read student data from file
	        readStudentData();
	    }
	}