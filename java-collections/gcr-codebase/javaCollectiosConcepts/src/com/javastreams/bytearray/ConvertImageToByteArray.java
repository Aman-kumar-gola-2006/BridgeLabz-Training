package com.javastreams.bytearray;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ConvertImageToByteArray {

	    public static void main(String[] args) {

	        File originalImage = new File("C:\\Users\\ronit\\Downloads\\demo.jpg");
	        File copiedImage = new File("C:\\Users\\ronit\\Downloads\\demo.jpg");

	        try {
	            // Convert image to byte array
	            byte[] imageBytes = convertImageToByteArray(originalImage);

	            // Write byte array back to image
	            writeByteArrayToImage(imageBytes, copiedImage);

	            // Verify if both images are identical
	            if (verifyImages(originalImage, copiedImage)) {
	                System.out.println("Images are identical.");
	            } else {
	                System.out.println("Images are NOT identical.");
	            }

	        } catch (IOException e) {
	            System.out.println("Error occurred during image processing.");
	            e.printStackTrace();
	        }
	    }

	    /**
	     * Converts an image file into a byte array
	     */
	    private static byte[] convertImageToByteArray(File image) throws IOException {

	        try (FileInputStream fis = new FileInputStream(image);
	             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

	            byte[] buffer = new byte[4096];
	            int bytesRead;

	            // Read image and write to ByteArrayOutputStream
	            while ((bytesRead = fis.read(buffer)) != -1) {
	                baos.write(buffer, 0, bytesRead);
	            }

	            return baos.toByteArray();
	        }
	    }

	    /**
	     * Writes a byte array back into an image file
	     */
	    private static void writeByteArrayToImage(byte[] imageBytes, File outputImage)
	            throws IOException {

	        try (ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
	             FileOutputStream fos = new FileOutputStream(outputImage)) {

	            byte[] buffer = new byte[4096];
	            int bytesRead;

	            // Read from byte array and write to image
	            while ((bytesRead = bais.read(buffer)) != -1) {
	                fos.write(buffer, 0, bytesRead);
	            }
	        }
	    }

	    /**
	     * Verifies whether two image files are identical
	     */
	    private static boolean verifyImages(File img1, File img2) throws IOException {

	        if (img1.length() != img2.length()) {
	            return false;
	        }

	        try (FileInputStream fis1 = new FileInputStream(img1);
	             FileInputStream fis2 = new FileInputStream(img2)) {

	            int b1, b2;
	            while ((b1 = fis1.read()) != -1) {
	                b2 = fis2.read();
	                if (b1 != b2) {
	                    return false;
	                }
	            }
	        }
	        return true;
	    }
	}