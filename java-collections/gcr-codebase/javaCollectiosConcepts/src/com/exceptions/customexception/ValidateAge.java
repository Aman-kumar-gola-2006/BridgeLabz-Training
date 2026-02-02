package com.exceptions.customexception;

import java.util.Scanner;

public class ValidateAge {

	public static void validateAge(int age) throws InvalidAgeException {
		if(age<18) {
			throw new InvalidAgeException("Age must be greater than 18");
		}
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Age : ");
		int age=scanner.nextInt();
		try {
			validateAge(age);
			System.out.println("Valid Age");
		} catch (InvalidAgeException e) {
			System.out.println("Age is Less Than 18");
		}
	}
}
