// program to compare two strings using the charAt() method and 
// check the result with the built-in String equals() method

import java.util.*;
public class StringComparison{
	public static boolean compareStrings (String s1, String s2) {
		
		boolean b = false;
		if(s1.length() != s2.length()){
			System.out.println("The strings are not equal" );
		}
		else {
			for(int i=0; i<s1.length(); i++){
				if(s1.charAt(i) == s2.charAt(i)){
					b=true;
				}
				else{
					b=false;
				}
			}
		}
		return b;
	}
	
	public static void main(String [] args){
	 // Created a Scanner Object
      Scanner sc = new Scanner(System.in);
	  
	  //take input of 1st String from user
	  System.out.println("enter the 1st String ");
	  String s1 = sc.next();
	  
	   //take input of 2nd String from user
	  System.out.println("enter the 2nd String ");
	  String s2 = sc.next();
	  
		
		System.out.println("BY using charAt(i) method The two strings are equal : " + compareStrings(s1, s2));
		System.out.println("BY using built-in .equals() method The two strings are equal : " + s1.equals(s2));
	}
}