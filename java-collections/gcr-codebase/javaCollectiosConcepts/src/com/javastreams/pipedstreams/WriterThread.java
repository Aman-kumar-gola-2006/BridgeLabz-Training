package com.javastreams.pipedstreams;

import java.io.IOException;
import java.io.PipedOutputStream;

/**
 * WriterThread writes data into PipedOutputStream
 */
class WriterThread extends Thread {

    private PipedOutputStream pos;

    public WriterThread(PipedOutputStream pos) {
        this.pos = pos;
    }

    @Override
    public void run() {
        try {
            String message = "Hello from Writer Thread!";

            // Write data to the pipe
            pos.write(message.getBytes());

            System.out.println("Writer sent: " + message);

            pos.close(); // Close after writing

        } catch (IOException e) {
            System.out.println("Error in Writer Thread");
            e.printStackTrace();
        }
    }
}