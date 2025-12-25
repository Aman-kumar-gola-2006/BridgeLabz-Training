// Write a Java program to count the number of vowels and consonants in a given string.

import java.util.*;

class VowelsAndConsonants{

		public static int [] countVowelsAndConsonants(String s){
			int vowels =0;
			int consonants=0;
			
			for (int i=0; i<s.length(); i++){
				if (s.charAt(i) == 'a' || s.charAt(i) == 'e' ||s.charAt(i) == 'i' ||s.charAt(i) == 'o' ||s.charAt(i) == 'u' ){
					vowels++;
				}
				else{
					consonants++;
				}
			}
			
			int answer [] = new int [2];
			answer[0]=vowels;
			answer[1]=consonants;
			
			return answer;
			
		}
		public static void main(String [] args ){
			// Creating the scanner object
			Scanner sc = new Scanner (System.in);
			
			// Take input from the user 
			System.out.println("Enter the string");
			String s = sc.next();
			
			int result [] = countVowelsAndConsonants(s);
			
			System.out.println("The numbers of vowels in String is : "+ result[0]);
			System.out.println("The numbers of consonants in String is : "+ result[1]);
			
			
			
		}
}