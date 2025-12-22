// seperate the digits and find the largest and secondlargest
import java.util.Scanner;

public class CalculateDigitsAndLargest {
   public static void main(String[] args) {
      // Create a Scanner Object
      Scanner sc = new Scanner(System.in);
	  
	  //take input of number from user
	  System.out.println("enter the number ");
	  int n=sc.nextInt();
	  
	 //creating a variable  
	  int maxDigit=10;
	  
	  // Creating an Array of maxDigit 
	  int digits[] = new int[maxDigit];
	  
	  // Creating a variable index  
	  int index = 0;
	  
		
		
	  // For loop to iterate
	   while(n>0)
	{
	    if(index==maxDigit)
	   {
	    break;
	   } 
       digits[index]=n%10;
	   n=n/10;
	   index++;
	}	   
	 
	//intializing the largest and secondlargest as inter min value 
	int largest=Integer.MIN_VALUE; 
	int secondlargest=Integer.MIN_VALUE; 

  
    //using for loop for iteration and finding the largest and secondlargest 
	 for(int i=0;i<digits.length;i++)
	 {
	   if(digits[i]>largest)
	   {
	     largest=digits[i];
	   }
	  else if(digits[i]>secondlargest && digits[i]!=largest)
	   {
	    secondlargest=digits[i];
	   }
	 
	 }
	 
	 
	 System.out.println("Largest digit is = " + largest);
	 System.out.println("secondlargest digit is = " + secondlargest);
	 
		
      // Close the Scanner Object
      sc.close();
   }
}