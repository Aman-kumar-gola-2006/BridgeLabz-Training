// Write a Java program to check if a given string is 
// a palindrome (a string that reads the same forward and backward).

import java.util.*;

class Palindrome{

		public static boolean checkPalindrome (String s){
			int start =0; 
			int end = s.length()-1;
			
			while(start <end){
				if(s.charAt(start) != s.charAt(end)){
					return false;
				}
				start ++;
				end--;
			}
			return true;
		}
		public static void main(String [] args ){
			// Creating the scanner object
			Scanner sc = new Scanner (System.in);
			
			// Take input from the user 
			System.out.println("Enter the string");
			String s = sc.next();
		
			System.out.println("The given String is Palindrome ? : "+ checkPalindrome(s));
		}
}