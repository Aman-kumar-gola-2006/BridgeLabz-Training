package com.javastreams.bufferedstreams;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.*;

public class EfficientFileCopy {

	public static void fileInput(File sourcefile,File destinationfile) throws IOException {
		FileInputStream fis=new FileInputStream(sourcefile);
		FileOutputStream fout=new FileOutputStream(destinationfile);
		
		
		int line;
		while((line=fis.read())!=-1)
		{
			fout.write(line);
		}
		System.out.println("File copied successfully");
	
	}

	// Efficient file copy using Buffered Streams
    public static void bufferedInput(File sourceFile, File destinationFile) throws IOException {

        try (BufferedInputStream bis =
                     new BufferedInputStream(new FileInputStream(sourceFile));
             BufferedOutputStream bos =
                     new BufferedOutputStream(new FileOutputStream(destinationFile))) {

            byte[] buffer = new byte[1024];
            int bytesRead;

            // Read chunks instead of byte-by-byte
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
            System.out.println("File copied using Buffered Streams.");
        }
    }
	public static void main(String[] args) throws IOException{
		File sourcefile=new File("C:\\Users\\ronit\\Desktop\\Java Programming Workspace\\java-collections\\gcr-codebase\\javaCollections\\src\\com\\javastreams\\bufferedstreams\\Textfile.txt");
		File destinationfile=new File("C:\\Users\\ronit\\Desktop\\Java Programming Workspace\\java-collections\\gcr-codebase\\javaCollections\\src\\com\\javastreams\\bufferedstreams\\outputfile.txt");
		
		
		File sourcefile2=new File("C:\\Users\\ronit\\Desktop\\Java Programming Workspace\\java-collections\\gcr-codebase\\javaCollections\\src\\com\\javastreams\\bufferedstreams\\Textfile2.txt");
		File destinationfile2=new File("C:\\Users\\ronit\\Desktop\\Java Programming Workspace\\java-collections\\gcr-codebase\\javaCollections\\src\\com\\javastreams\\bufferedstreams\\outputfile2.txt");
		
		
		long start=System.nanoTime();
		fileInput(sourcefile, destinationfile);
		long end=System.nanoTime();
		System.out.println(end-start);
		
		start=System.nanoTime();
		bufferedInput(sourcefile2, destinationfile2);
		end=System.nanoTime();
		System.out.println(end-start);
	}
}