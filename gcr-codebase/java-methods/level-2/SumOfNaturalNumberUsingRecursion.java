
import java.util.*;
public class SumOfNaturalNumberUsingRecursion {
	
	//create a method to calculate the sum by using recursion
	public static int sum(int n ){
		//given a base condition for exit
	     if(n==0)
		 {
			 return 0;
		 }  
		 //call method itself until the base condition is true
		 return n+ sum(n-1); 
	}
	
	//create a method to sum all the natural number with the help of formula
	public static int sum2(int n ){
		int sum=n*(n+1)/2 ;
		
		 return sum;
	}

	//main method
	public static void main(String [] args){
		
		// Created a Scanner Object
		Scanner sc = new Scanner(System.in);
	  
		//take input of the number from user
		System.out.println("enter the number ");
		int number = sc.nextInt();
		
		
		 //display the sum 
		 System.out.println("sum   = " + sum(number));
		 System.out.println("sum   = " + sum2(number));
		 
		 //compare both the sum
		 if(sum(number)==sum2(number)){
			  System.out.println("Both are equal ");
		 }
		 else
			  System.out.println("Both are not equal ");
		 
		
		
		
		
	}
}