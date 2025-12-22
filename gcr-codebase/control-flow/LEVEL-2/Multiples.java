import java.util.*;

	public class Multiples{

	public static void multiples(int n)
	{
	  if(n>0 && n<100)
	  {
	  for(int i=100 ;i>=1;i--)
	  {
	    if(n%i==0)
		{
		  System.out.println( i );
			System.out.println("welcome to Java World");
		}
	  }
	  }
	  else{
	  System.out.println("Enter a valid number between 1 to 100" );
	  }
	}
	public static void main(String args[])
	{
	   Scanner sc=new Scanner(System.in); 
	   System.out.println("Enter the number");
	   int number=sc.nextInt();
	   
	   multiples(number);

	   
	   
	}

	}