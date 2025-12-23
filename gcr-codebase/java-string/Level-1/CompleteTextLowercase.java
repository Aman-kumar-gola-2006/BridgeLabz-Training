// program to convert the complete text to lowercase and compare the results

import java.util.*;
public class CompleteTextLowercase {
	
	// Method to convert text to lowercase
	public static String convertCompleteTextToLowercase(String s ) {
		String lowercase = "";
		for (int i=0; i<s.length(); i++){
			char ch=s.charAt(i);
			 if (ch >= 'A' && ch <= 'Z') {
                ch = (char)(ch + 32);
            }
            lowercase+= ch;
        }
        return lowercase;
	}
	
	public static void main(String [] args){
	   // Created a Scanner Object
      Scanner sc = new Scanner(System.in);
	  
	  //take input of String from user
	  System.out.println("enter the String ");
	  String s  = sc.nextLine();
	  
	  String lowerUserDefined = convertCompleteTextToLowercase(s);
	  String lowerBuiltIn = s.toLowerCase();
	  
	  System.out.println("The lowercase string using user defined method convertCompleteTextToLowercase() is : "+ lowerUserDefined);
	   System.out.println("The lowercase string using built-in toLowerCase() method is : "+ lowerBuiltIn);
	  
	  
	  
		
	}
}