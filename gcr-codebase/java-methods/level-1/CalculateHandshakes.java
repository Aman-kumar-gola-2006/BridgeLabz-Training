// created a Program to calculate maximum number of handshakes among students.
import java.util.Scanner;
public class CalculateHandshakes {
	public int maximumHandshakes(int n){
	  int maxHandshakes= (n*(n-1))/2;
	  return maxHandshakes;
	}
	
	public static void main(String [] args){
		// Created a Scanner Object
		Scanner sc = new Scanner(System.in);
		System.out.println("welcome to Java World");
	  
		//take input of numberOfStudents from user
		System.out.println("enter the number ");
		int numberOfStudents = sc.nextInt();
		
		// creating object of CalculateHandshakes class to use the function.
		CalculateHandshakes ch = new CalculateHandshakes();
		
		// Print the maximum number of possible handshakes
		// calling the maximumHandshakes() method here
		System.out.print("The maximum number of possible handshakes are : "+ ch.maximumHandshakes(numberOfStudents));
	}
}