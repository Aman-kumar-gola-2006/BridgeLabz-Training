package com.junit.filehandling;

import static org.junit.Assert.*;
import org.junit.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

// JUnit 4 test class for FileProcessor
public class FileProcessorTest {

	FileProcessor processor = new FileProcessor();

	@Test
	public void testWriteAndReadFile() throws IOException {
		String file = "test.txt";
		processor.writeToFile(file, "JUnit4");
		assertTrue(Files.exists(Path.of(file)));
		assertEquals("JUnit4", processor.readFromFile(file));
	}

	@Test(expected = IOException.class)
	public void testFileNotFound() throws IOException {
		processor.readFromFile("missing.txt");
	}
}
