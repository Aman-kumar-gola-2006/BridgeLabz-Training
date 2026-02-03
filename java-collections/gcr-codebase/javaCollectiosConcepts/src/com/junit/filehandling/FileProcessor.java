package com.junit.filehandling;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

// Handles file read/write operations
public class FileProcessor {

    public void writeToFile(String filename, String content) throws IOException {
        Files.write(Path.of(filename), content.getBytes());
    }

    public String readFromFile(String filename) throws IOException {
        return Files.readString(Path.of(filename));
    }
}
