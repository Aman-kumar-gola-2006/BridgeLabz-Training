//  program to create a substring from a String using the charAt() method. Also, use the String built-in method substring()
// 	to find the substring of the text. Finally Compare the the two strings and display the results

import java.util.*;
public class SubstringFromString{
	public static String findSubstring(String s, int si, int ei) {
		String result = "";
		for(int i=si; i<ei; i++){
			result+=s.charAt(i);
		}
		return result;
	}
	
	public static void main(String [] args){
		// Created a Scanner Object
      Scanner sc = new Scanner(System.in);
	  
		//take input of String from user
	  System.out.println("enter the String ");
	  String s = sc.next();
	  
	  //take input of starting index from user
	  System.out.println("enter the starting index of substring ");
	  int  startingIndex = sc.nextInt();
	  
	   //take input of starting index from user
	  System.out.println("enter the ending index of substring ");
	  int  endingIndex = sc.nextInt();
	  
	  // substring using charAt
	  String sub1 =  findSubstring(s, startingIndex, endingIndex);
	  
	  // substring using built-in substring() function
	  String sub2 = s.substring(startingIndex, endingIndex);
	  
	  System.out.println("Substring using charAt(i) is : " + sub1 );
	  System.out.println("Substring using built-in substring() method is : " + sub2 );
	  
	   // Compare both substrings
        if (sub1.equals(sub2)) {
            System.out.println("Both substrings are equal");
        } else {
            System.out.println("Substrings are NOT equal");
        }
	  
	}
}