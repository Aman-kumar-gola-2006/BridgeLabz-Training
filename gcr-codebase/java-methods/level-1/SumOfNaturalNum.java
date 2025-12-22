import java.util.*;

//create a class of Sum of natural number
public class SumOfNaturalNum{

//create a method of Sum of natural number
		public int  sum(int n)
		{
	
  // create a variable to calculate the sum 	
		  int sum=0;
			
    // validate the user input			
		  if(n>=0)
		  {
			  
		//calculating sum by using while loop
        // decrement the number in each iteration		
			  while(n>=1)
			  {
			   sum+=n;
			   n--;
			  }
			
		  }
		  else {
		   System.out.println("Enter valid number");
		  }
		  
		  //return the sum
		  return sum;
		  
		}
		public static void main(String args[])
		{
       // create a scanner object
		   Scanner sc=new Scanner(System.in);
			System.out.println("welcome to Java World");
		 //take input from user 
		 
		 System.out.println("Enter the number");  
		   int number=sc.nextInt();
		  
		  //create an object of SumOfNaturalNum class
		 SumOfNaturalNum s=new SumOfNaturalNum();  
		 //call and print the sum
		 System.out.println(s. sum(number));  

		   
		   
		}

}