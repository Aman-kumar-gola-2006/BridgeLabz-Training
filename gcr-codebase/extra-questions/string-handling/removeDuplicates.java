// Write a Java program to remove all duplicate characters 
// from a given string and return the modified string.
import java.util.*;

class Duplicates{

		public static String removeDuplicates (String s){
			String newString = " ";
			boolean visited [] = new boolean[256]; 
			for (int i=0; i<s.length(); i++){
				char ch = s.charAt(i);
				if(!visited[ch]){
					visited[ch]= true;
					newString+=ch;
				}
			}
			
			return newString;
		}
		public static void main(String [] args ){
			// Creating the scanner object
			Scanner sc = new Scanner (System.in);
			
			// Take input from the user 
			System.out.println("Enter the string");
			String s = sc.next();
		
			System.out.println("The Unique characters in Strings are : "+ removeDuplicates(s));
		}
}