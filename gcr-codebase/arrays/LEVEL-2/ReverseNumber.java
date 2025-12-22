// Created ReverseNumber Class to reverse the number by  
// storing the digits in array and print the array in reverse number
import java.util.*;
public class ReverseNumber{
	public static void main (String [] args){
		// Created a Scanner Object
		Scanner sc = new Scanner(System.in);
		System.out.println("welcome to Java World");
		
		// Take integer input 
		System.out.print("Enter the number : " );
		int originalNumber = sc.nextInt();
		int number = originalNumber;
		
		// counter for counting digits
		int count =0;
		
		// Counting the digits of the number by using while loop
		while(number>0){
			number = number/10;
			count++;
		}
		
		// created an array of length count to store the digits
		int array []= new int [count];
		number = originalNumber;
		
		for (int i=0; i<count; i++){
			array[i]= number%10;
			number=number/10;
		}
		
		System.out.println("The original number is " + originalNumber);
		
		System.out.print("The reversed number is : "  );
		for (int i=0; i<count; i++){
				System.out.print(array[i]);
		}
		
      // Close the Scanner Object
      sc.close();
		
	}
}