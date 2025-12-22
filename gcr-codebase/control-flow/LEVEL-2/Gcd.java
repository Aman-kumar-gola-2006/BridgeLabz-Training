import java.util.*;

	public class Gcd{

	public static void gcd(int n)
	{
	  int greatestfactor=1;
	  for(int i=1;i<n;i++)
	  {
	    if(n%i==0)
		{
		  if(greatestfactor < i)
		  {
		    greatestfactor=i;
		  }
		}
	  }
	  System.out.println("Greatest factor is = " + greatestfactor);
	}
	public static void main(String args[])
	{
	   Scanner sc=new Scanner(System.in);
		System.out.println("welcome to Java World");
	   System.out.println("Enter the number");
	   int number=sc.nextInt();
	   
	   gcd(number);

	   
	   
	}

	}