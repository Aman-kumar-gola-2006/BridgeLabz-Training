import java.util.*;

public class Table{

	public static void table(int n)
	{
      if(n>=6 && n<=9)
	  {
		   for(int i=1;i<=10;i++)
	   {
	      int mul=n*i;   
	      System.out.println( n + "*" + i + " = " + mul);
		 
	   }
	  }
	  else
	  System.out.println("Enter digit between 6 to 9");
	 
	}
public static void main(String args[])
{

   Scanner sc=new Scanner(System.in); 
      System.out.println("Enter the number"); 
   int number=sc.nextInt();
   table(number);

   
   
}

}