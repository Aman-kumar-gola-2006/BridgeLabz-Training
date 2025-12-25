// Java program to count how many times a given substring occurs in a string.

import java.util.*;

public class SubStringOccurrence {

    public static void subStringOccurrence(String s,String s2) {
		int wordcount=1;
        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i)==' ') {
               wordcount++;
            }
        }
		 int index=0;
		 String word ="";
         String sa[]=new String[wordcount];
		 for (int i = 0; i < s.length(); i++) {
		     if(s.charAt(i)!=' ')
			 {
				word+=s.charAt(i);
			 }
			 else
			 {
				 sa[index]=word;
				 word="";
				 ind++;
			 }
		 }
		 
		 sa[ind] = word;
		 int count=0;
		 
		  for (int i = 0; i < wordcount; i++) {
			  if(sa[i].equals(s2))
			  {
				  count++; 
			  }
		  }
      System.out.println("word " + s2 + " = "+count);
         
    }
	
	 public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the sentence:");
        String s = sc.nextLine();
		
	    System.out.println("Enter the substring:");
        String s2 = sc.next();
		
        subStringOccurrence(s,s2);
        sc.close();
    }
}