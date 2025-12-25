// Write a Java program that takes a sentence as input 
// and returns the longest word in the sentence.
import java.util.*;

class LongestWord{

		public static String findLongestWord (String s){
			String longestWord = " ";
			String currentWord = " ";
			
			for (int i=0; i<s.length(); i++){
				char ch = s.charAt(i);
				if( ch !=' '){
					currentWord= currentWord+ch;
				}
				else {
					if (currentWord.length() > longestWord.length()){
						longestWord= currentWord;
					}
					currentWord= " ";
				}
			}
			
			if (currentWord.length() > longestWord.length()){
						longestWord= currentWord;
				}
			return longestWord;
		}
		public static void main(String [] args ){
			// Creating the scanner object
			Scanner sc = new Scanner (System.in);
			
			// Take input from the user 
			System.out.println("Enter the string");
			String s = sc.nextLine();
		
			System.out.println("The longest Word in the String is : "+ findLongestWord(s));
		}
}