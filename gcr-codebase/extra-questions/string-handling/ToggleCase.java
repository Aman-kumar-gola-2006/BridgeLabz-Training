// program to convert the complete text to lowercase and uppercase.

import java.util.*;

public class ToggleCase {
	
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
	
	// Method to convert text to uppercase
	public static String convertCompleteTextToUppercase(String s ) {
		String uppercase = "";
		for (int i=0; i<s.length(); i++){
			char ch=s.charAt(i);
			 if (ch >= 'a' && ch <= 'z') {
                ch = (char)(ch - 32);
            }
            uppercase+= ch;
        }
        return uppercase;
	}

	
	public static void main(String [] args){
	   // Created a Scanner Object
      Scanner sc = new Scanner(System.in);
	  
	  //take input of String from user
	  System.out.println("enter the String ");
	  String s  = sc.nextLine();
	  
	  String lowerUserDefined = convertCompleteTextToLowercase(s);
	  String upperUserDefined = convertCompleteTextToUppercase(s);
	  
	  
	  System.out.println("The lowercase string using user defined method convertCompleteTextToLowercase() is : "+ lowerUserDefined);
	  System.out.println("The Uppercase string using user defined method convertCompleteTextToUppercase() is : "+ upperUserDefined);
	  
	  
	  
	  
		
	}
}