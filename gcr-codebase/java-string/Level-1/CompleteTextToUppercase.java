// program to convert the complete text to uppercase and compare the results

import java.util.*;
public class CompleteTextToUppercase {
	public static String convertCompleteTextToUppercase(String s ) {
		String uppercase = "";
		for (int i=0; i<s.length(); i++){
			char ch=s.charAt(i);
			 if (ch >= 'a' && ch <= 'z') {
                ch = (char)(ch - 32);
            }
            uppercase += ch;
        }
        return uppercase;
	}
	
	public static void main(String [] args){
	   // Created a Scanner Object
      Scanner sc = new Scanner(System.in);
	  
	  //take input of String from user
	  System.out.println("enter the String ");
	  String s  = sc.nextLine();
	  
	  String upperUserDefined = convertCompleteTextToUppercase(s);
	  String upperBuiltIn = s.toUpperCase();
	  
	  System.out.println("The uppercase string using user defined method convertCompleteTextToUppercase() is : "+ upperUserDefined);
	  
	  
	   System.out.println("The uppercase string using built-in toUpperCase() method is : "+ upperBuiltIn);
	  
	  
	  
		
	}
}