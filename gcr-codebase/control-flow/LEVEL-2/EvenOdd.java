import java.util.*;

public class EvenOdd{

	public static void evenOdd(int n)
	{
       for(int i=1;i<=n;i++)
	   {
	     if(i%2==0)
		 {
		  System.out.println(i + " is an even number"); 
		 }
		 else
		  System.out.println(i + " is an odd number"); 

		 
	   }
	 
	}
public static void main(String args[])
{

   Scanner sc=new Scanner(System.in);
	System.out.println("welcome to Java World");
      System.out.println("Enter the number");
   int number=sc.nextInt();
   evenOdd(number);

   
   
}

}