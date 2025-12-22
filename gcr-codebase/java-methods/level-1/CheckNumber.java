import java.util.*;
//create a class named as Athleteruns
public class CheckNumber{

public static int checknumber(int n)

//checking the number 
{
    if(n<0)
	{
      return -1; 
 }
	
	else if(n>0)
	{
		return -1; 
	}
	
	 else
	{
		return 0; 	}
	
}

  //main method 
public static void main(String args[])
{
  
  // create a scanner object 	
   Scanner sc=new Scanner(System.in);
  
// taking input from user  
 System.out.println("Enter the number");
   int number=sc.nextInt();
   
   //creating object of CheckNumber class
   CheckNumber c=new CheckNumber();
   
   System.out.println(c.checknumber(number));

   
   
}

}