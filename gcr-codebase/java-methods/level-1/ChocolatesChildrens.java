// created a program ChocolatesChildrens that takes two integer value numberOfchocolates and numberOfChildren from the 
// command line and Print the number of chocolates each child will get and also the remaining chocolates.


import java.util.Scanner;
public class ChocolatesChildrens {
	public static int[] findRemainderAndQuotient(int chocolates, int childrens ){
	
		// created an integer array to store remaining chocolates and chocolates each children got
		int result [] = new int [2];
		
		// integer variables to store remaining and each children got chocolate
		int remainder = chocolates%childrens;
		int eachChocolate = chocolates/childrens;

		// store the values into the array 
		result[0]= remainder;
		result[1]= eachChocolate;
		
		// return the resulted array
		return result;
	}
	
	public static void main(String [] args){
		
		// Created a Scanner Object
		Scanner sc = new Scanner(System.in);
	  
		//take input of chocolates from user
		System.out.println("enter the chocolates number ");
		int chocolates = sc.nextInt();
		
		//take input of childrens from user
		System.out.println("enter the childrens number ");
		int childrens = sc.nextInt();
		
		//creating object of SpringSeason class to use the function.
		ChocolatesChildrens c = new ChocolatesChildrens();
		
		// Print the remainder and each chocolate children got by
		// calling the findRemainderAndQuotient() method here
		int answer [] = c.findRemainderAndQuotient(chocolates, childrens);
		
		System.out.println("The number of remaining chocolates are : "+ answer[0]);
		System.out.println("The number of chocolates each students got are : "+ answer[1]);
		
		
		
	}
}