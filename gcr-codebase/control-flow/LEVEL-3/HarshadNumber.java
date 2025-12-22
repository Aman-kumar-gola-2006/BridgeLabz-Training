
import java.util.*;

	public class HarshadNumber{

	public static void harshad(int n)
	{
	 int sum=0;
	 int on=n;
	  while(n>0)
	  {
	    sum+=n%10;
		n=n/10;
		
	  }
	  if(on%sum==0)
	   System.out.println(on + " is a Harshad Number");
	   else
	   System.out.println(on + " is not a Harshad Number");

	   
	}
	
	
	public static void main(String args[])
	{
	   Scanner sc=new Scanner(System.in); 
	  System.out.println(" Enter number ");

	   int number=sc.nextInt();
	   
	   harshad(number);
	}

	}
