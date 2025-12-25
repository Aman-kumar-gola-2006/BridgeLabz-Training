// Write a Java program to remove all occurrences of a specific character from a string.
import java.util.*;

public class SpecificCharacter{

		public static String removeSpecificCharacter (String s, char c){
			String newString = "";
			for(int i=0; i<s.length(); i++){
				if(s.charAt(i) !=c){
					newString+=s.charAt(i);
				}
			}
			return newString;
		}
		public static void main(String [] args ){
			// Creating the scanner object
			Scanner sc = new Scanner (System.in);
			
			// Take String input from the user 
			System.out.println("Enter the string");
			String s = sc.nextLine();
			
			// Take the input of the character to remove from the string
			System.out.println("Enter the character to remove from the string");
			char c = sc.next().charAt(0);
			
			System.out.println("The String after removing " + c + " is : "+ removeSpecificCharacter(s, c));
		}
}