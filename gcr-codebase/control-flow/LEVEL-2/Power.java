import java.util.*;

	public class Power{

	public static void numpower(int n, int power)
	{
	   int result=1;
	  
	    for(int i=1; i<=power;i++)
		{
		  result*=n;
		}
	  
	  System.out.println(result);
	}
	public static void main(String args[])
	{
	   Scanner sc=new Scanner(System.in); 
	   System.out.println("Enter the number");
	   int number=sc.nextInt();
	   System.out.println("Enter the power");
	   int power=sc.nextInt();
	   
	   numpower(number , power);

	   
	   
	}

	}