package com.javastreams.pipedstreams;

import java.io.IOException;
import java.io.PipedInputStream;

/**
 * ReaderThread reads data from PipedInputStream
 */
class ReaderThread extends Thread {

    private PipedInputStream pis;

    public ReaderThread(PipedInputStream pis) {
        this.pis = pis;
    }

    @Override
    public void run() {
        try {
            int data;

            // Read data from the pipe
            while ((data = pis.read()) != -1) {
                System.out.print((char) data);
            }

            System.out.println("\nReader finished reading.");

            pis.close();

        } catch (IOException e) {
            System.out.println("Error in Reader Thread");
            e.printStackTrace();
        }
    }
}