import java.util.*;

	public class IsPrime{

	public static void isPrime(int n)
	{
	    boolean isprime= true;
		for (int i=2; i<n;i++)
		{
		 if(n%i==0)
		 { 
		 isprime=false;
		   break;
		 }
		 
		}
		if(isprime){
		System.out.println(n +  " is a prime number");
		}
	   else
	  System.out.println(n +  " is not a prime number");
	}
	public static void main(String args[])
	{
	   Scanner sc=new Scanner(System.in);
		System.out.println("welcome to Java World");
	   int number=sc.nextInt();
	   
	   isPrime(number);

	   
	   
	}

	}