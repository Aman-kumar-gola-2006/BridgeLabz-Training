// created a program SpringSeason that takes two int values month and day from the 
// command line and prints “Its a Spring Season” otherwise prints “Not a Spring Season”. 

import java.util.Scanner;
public class SpringSeason {
	public static boolean checkSpring(int m, int d){
		if (m==3 && d>=20 || m==4 ||  m==5 || m==6 && d<=20){
				return true;
		}
		return false;
	}
	
	public static void main(String [] args){
		
		// Created a Scanner Object
		Scanner sc = new Scanner(System.in);
	  
		//take input of month from user
		System.out.println("enter the Month number ");
		int month = sc.nextInt();
		if (month<1 || month>12){
			System.out.println("Invalid Month, Please enter value from 1-12 only ");
			return;
		}
		
		//take input of day from user
		System.out.println("enter the day number ");
		int day = sc.nextInt();
		if (day<1 || day>31){
			System.out.println("Invalid day, Please enter value from 1-31 only ");
			return;
		}
		
		// creating object of SpringSeason class to use the function.
		SpringSeason sp = new SpringSeason();
		
		// Print if the season is Spring or not
		// calling the checkSpring()  method here
		System.out.print("The entered date is Spring  : "+ sp.checkSpring(month, day));
	}
}