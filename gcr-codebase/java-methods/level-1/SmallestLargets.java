import java.util.*;
//create a class named as SmallestLargets
 public class SmallestLargets
{
   //create a method to calculate Smallest and Largets among three numbers
	public static int[] findSmallestAndLargest(int number1, int number2, int number3)
	{
		
		//taking a variable to store largest number
	int largest=0;
	    if(number1>number2 && number1>number3)
		{
		  largest=number1;
		}
		else if(number1<number2 && number2>number3)
		{
		  largest=number2;
		}
		else
		{
		largest=number3;
		}
		
		//checking the same logic for smallest number
		//taking among variable to store smallest number
		int smallest=0;
	    if(number1<number2 && number1<number3)
		{
		  smallest=number1;
		}
		else if(number1<number2 && number2>number3)
		{
		  smallest=number2;
		}
		else
		{
		smallest=number3;
		}
		
		int result[]=new int[2];
		result[0]=largest;
		result[1]=smallest;
		return result;
		
	}


  //main method for calling the other methods
	public static void main(String args[])
	{
	 // create a scanner object 	
	Scanner sc= new Scanner(System.in);
		System.out.println("welcome to Java World");
	//taking user input for number1
	System.out.println("Enter the number1");
	int number1=sc.nextInt();
	
		//taking user input for number2
	System.out.println("Enter the number2");
	int number2=sc.nextInt();
	
		//taking user input for number3
	System.out.println("Enter the number3");
	int number3=sc.nextInt();

   //create an object of SimpleInterest class to call method
     SmallestLargets s = new SmallestLargets();
	 int result[]= s.findSmallestAndLargest(number1, number2,number3);
     System.out.println("largest = " + result[0]);	 
	      System.out.println("smallest = " + result[1]);	 

	}

}