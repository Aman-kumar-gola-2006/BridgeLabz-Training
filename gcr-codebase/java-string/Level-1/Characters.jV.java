import java.util.*;

    //creating a class to Characters
	public class Characters
	{
	 //creating a method to convert and return all charcters of a string    
       public static char[] tocharactersarray(String s)
	   {
		//using a char array to store the characters of a string
	    char ch[]=new char[s.length()];
           for(int i=0;i<s.length();i++)
		   {
             ch[i]=s.charAt(i);
		   }
		   
		   //return the char array
				return ch;
	   }
	   public static boolean compare(char []c1,char []c2)
	   {
		   //compare the char arrays and return the true or false 
	     return Arrays.equals(c1, c2);
	   }
	    
       public static void main(String args[])
	   {
		   //crearting the scanner object
	      Scanner sc= new Scanner(System.in);
		  
		  //taking the string as input from the user 
		  System.out.println("Enter the string");
		  String s=sc.next();
		  
		  //call the inbuilt method and store it in an char array 
		  char c2[]=s.toCharArray() ;
		  
		  //call the user defined method and store it an char array  
		  char c1[]=tocharactersarray(s);
		  System.out.println(compare(c1,c2));
	   
	   }
	}