
import java.util.*;
public class Factors {
	public static int[] findFactor(int n ){
	
		// created a count variable to store the count of factors
		 int count=0;
		 for (int i=1;i<=n;i++)
		 { 
	        if(n%i==0)
			{
				count++;
			}
		 }
		 // created an integer array to store the factors
		int []factor=new int[count];
		//take an index 
		int ind=0;
		
		//use for loop to iteration and find factors/
		//by checking the number is completely devided by i
		 for(int i=1;i<=n;i++)
		 { 
	        if(n%i==0)
			{
				factor[ind]=i;
				ind++;
			}
		 }
		 return factor;
	}
	
	//create a method to sum all the factors
	public static int sum(int number[] ){
		int sum=0;
		 for (int i=0;i<number.length;i++)
		 { 
	       sum+=number[i];
		 }
		 return sum;
	}
	
	//create a method to sum all the square of factors
	public static int sum(double number[] ){
		int sum=0;
		 for (int i=0;i<number.length;i++)
		 { 
	       sum+=number[i];
		 }
		 return sum;
	}
	//create a method to product all factors
	public static int product(int number[] ){
		int product=1;
		 for (int i=0;i<number.length;i++)
		 { 
	       product*=number[i];
		 }
		 return product;
	}
	
	//create a method to calculate the square of each factor by using Math class 
	 public static double[] square(int number[] ){
		 
		 //create a new array to store the square of factor
		 double fac[]=new double [number.length];
		 for (int i=0;i<number.length;i++)
		 { 
	       fac[i]=Math.pow(number[i],2);
		 }
		 return fac;
	}
	
	
	//main method
	public static void main(String [] args){
		
		// Created a Scanner Object
		Scanner sc = new Scanner(System.in);
	  
		//take input of the number from user
		System.out.println("enter the number ");
		int number = sc.nextInt();
		
		//call the method and store it in an array
		int a[]=findFactor(number);
		
		//display the factors 
		System.out.print("Factors of the number" + number + " is = ");
	    
		for (int i=0;i<a.length;i++)
		 {
			 System.out.print(a[i] + " , " );
		 }
		 
		 System.out.println();
		 //call the square method to calculate squares and store it in an double array
         double b[]=square(a);
		 //display the sum of all factors 
		 System.out.println("sum of all factors  = " + sum(a));
		 //display the product of all factors
		 System.out.println("productof all factors  = " + product(a));
		 //By using the sum method for double array
		 //give square array input to sum method 
		 System.out.println("sum =" + sum(b));
 
		
		
		
		
	}
}