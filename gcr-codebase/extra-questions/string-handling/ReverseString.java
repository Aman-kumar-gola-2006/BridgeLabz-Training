// Write a Java program to reverse a given string without 
// using any built-in reverse functions.

import java.util.*;

class ReverseString{

		public static String StringReverse (String s){
			char ch [] = s.toCharArray();
			int left =0;
			int right =s.length()-1;
			
			while(left<right){
				char temp = ch[right];
				ch[right]= ch[left];
				ch[left]= temp;
				left++;
				right--;
			}
			
			return new String(ch);
		}
		public static void main(String [] args ){
			// Creating the scanner object
			Scanner sc = new Scanner (System.in);
			
			// Take input from the user 
			System.out.println("Enter the string");
			String s = sc.next();
			
			
			System.out.println("The reversed String is : "+ StringReverse(s));
			
		}
}