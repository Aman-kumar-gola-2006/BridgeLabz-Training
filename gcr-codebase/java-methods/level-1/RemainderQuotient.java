import java.util.*;
//create a class named as RemainderQuotient
 public class RemainderQuotient
{
   //create a method to calculate Smallest and Largets among three numbers
	public static int[] findRemainderAndQuotient(int number, int divisor) 
	{
		
		//taking a variable to store remainder number
	   int remainder=number%divisor;
	   //taking a variable to store quotient number
	   int quotient=number/divisor;
	   
	   int result[]=new int [2];
	   result[0]=remainder;
	   result[1]=quotient;
	   
	   return result;
	}


  //main method for calling the other methods
	public static void main(String args[])
	{
	 // create a scanner object 	
	Scanner sc= new Scanner(System.in);
	
	//taking user input for number
	System.out.println("Enter the number1");
	int number=sc.nextInt();
	
		//taking user input for divisor
	System.out.println("Enter the number2");
	int divisor=sc.nextInt();
	
	int result[]=findRemainderAndQuotient(number,divisor);
		System.out.println("Remainder = " + result[0]);
       	System.out.println("quotient = " + result[1]);


   
     
	}

}