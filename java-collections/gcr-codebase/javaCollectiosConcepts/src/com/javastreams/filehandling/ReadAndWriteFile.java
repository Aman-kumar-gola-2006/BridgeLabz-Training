package com.javastreams.filehandling;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
public class ReadAndWriteFile {

	public static void main(String[] args) throws IOException {
		File sourcefile=new File("C:\\Users\\ronit\\Desktop\\Java Programming Workspace\\java-collections\\gcr-codebase\\javaCollections\\src\\com\\javastreams\\filehandling\\Textfile.txt");
		File destinationfile=new File("C:\\Users\\ronit\\Desktop\\Java Programming Workspace\\java-collections\\gcr-codebase\\javaCollections\\src\\com\\javastreams\\filehandling\\outputfile.txt");
		
		if(!sourcefile.exists())
		{
			System.out.println("Source file does not exist");
			return;
		}
		
		FileInputStream fis=new FileInputStream(sourcefile);
		FileOutputStream fout=new FileOutputStream(destinationfile);
		
		
		int line;
		while((line=fis.read())!=-1)
		{
			fout.write(line);
		}
		System.out.println("File copied successfully");
	}
}
