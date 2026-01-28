package com.queueinterface.binarynumberusingqueue;

import java.util.LinkedList;
import java.util.Queue;

public class GenerateBinaryNumbers {

	public static void generateBinary(int n) {

		// Create a queue to store binary numbers
		Queue<String> queue = new LinkedList<>();

		// Add first binary number
		queue.add("1");

		// Generate first N binary numbers
		for (int i = 0; i < n; i++) {

			// Remove front binary number
			String current = queue.remove();

			// Print current binary number
			System.out.print(current + " ");

			// Add next two binary numbers to queue
			queue.add(current + "0");
			queue.add(current + "1");
		}
	}

	public static void main(String[] args) {

		int n = 10;
		generateBinary(n);

	}

}
