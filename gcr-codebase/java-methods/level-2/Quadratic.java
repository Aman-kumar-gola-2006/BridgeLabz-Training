// created a program to find the roots of the equation ax2+ bx + c

import java.util.*;

public class Quadratic {
	
	// Method to generate the 4 digit random numbers in array
	public static int[] rootsOfQuadratic (int a,int b,int c){
		
		// Integer array to store the roots of quadratic equation
		int roots[] = new int [2];
		
		//calculating the delta by using formula
		int delta=(b*b) - (4*a *c);
		
		//check the delta if positive, negative, or zero
		if(delta>0)
		{
		roots[0] = (int)((-b + Math.sqrt(delta)) / (2 * a));
		roots[1] = (int)((-b - Math.sqrt(delta)) / (2 * a));
			return roots;
		}
		else if(delta==0)
		{
			roots[0]= -b/(2*a);
			return roots;
		}
		else
			return roots;
		
	}
	
	public static void main(String [] args){
		
		// Created a Scanner Object
		Scanner sc = new Scanner(System.in);
	  
		//take input of a
		System.out.println("enter the value of a ");
		int a = sc.nextInt();
	    
		//take input of b
		System.out.println("enter the value of b ");
		int b = sc.nextInt();
		
	    //take input of a
     	System.out.println("enter the value of c ");
		int c = sc.nextInt();
		int ans[]=rootsOfQuadratic(a,b,c);
		
		//display the roots
		for(int i=0;i<ans.length;i++){
		 System.out.print(ans[i] + ","); 
		}
	}
}