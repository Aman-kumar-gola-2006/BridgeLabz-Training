package com.javastreams.pipedstreams;
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class InterThreadCommunication {
	
	    public static void main(String[] args) {

	        try {
	            // Create piped streams
	            PipedOutputStream pos = new PipedOutputStream();
	            PipedInputStream pis = new PipedInputStream(pos); // connect streams

	            // Create threads
	            WriterThread writer = new WriterThread(pos);
	            ReaderThread reader = new ReaderThread(pis);

	            // Start threads
	            reader.start();  // start reader first (good practice)
	            writer.start();

	        } catch (IOException e) {
	            System.out.println("Error connecting piped streams");
	            e.printStackTrace();
	        }
	    }
	

}