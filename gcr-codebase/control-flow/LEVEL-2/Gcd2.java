import java.util.*;

	public class Gcd2{

	public static void gcd(int n)
	{
	  int greatestfactor=1;
	  int counter=n-1;
	  while(counter>=1)
	  {
	    if(n%counter==0)
		{
		  if(greatestfactor < counter)
		  {
		    greatestfactor=counter;
		  }
		}
		counter--;
	  }
	  System.out.println("Greatest factor is = " + greatestfactor);
	}
	public static void main(String args[])
	{
	   Scanner sc=new Scanner(System.in); 
	   System.out.println("Enter the number");
	   int number=sc.nextInt();
	   
	   gcd(number);

	   
	   
	}

	}