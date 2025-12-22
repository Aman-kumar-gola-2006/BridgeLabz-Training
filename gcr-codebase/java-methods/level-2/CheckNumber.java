// Create CheckNumber Class to check whether the numbers are positive, negative  
// or zero by using an array
import java.util.Scanner;

public class CheckNumber {
   public static void main(String[] args) {
      // Create a Scanner Object
      Scanner sc = new Scanner(System.in);
	  
	  // Creating an Array of length 5  
	  int array[] = new int[5];
	  
		System.out.println("Enter the Array elements or Numbers");
		
	  // For loop to take input from the user and store 
	  // them into the Array
	  for(int i=0; i<array.length; i++){
			array[i] = sc.nextInt();
			if(isPositive(array[i])){
				if(isEven(array[i]))
				{
					System.out.println(" Number is positive and even");
				}
				else
		        	System.out.println(" Number is positive but not even");
			}
			else
				System.out.println(" Number is negative");
		}
		int ans=compare(array);
		if(ans==1)
		{
			 
			System.out.println("The First element is greater than last element");
		}
	  else if(ans==0){
			System.out.println("The First element & last element are equal");
		}
		else {
			System.out.println("The Last element is greater than First element");
		}
		 // Close the Scanner Object
      sc.close();
		}
   	
		
	public static boolean isPositive(int n){	
	  // the number is positive, negative and zero
		if (n>0){
          return true;
     	}
		else{
			return false;
	  }
	}

    public static boolean isEven(int n){	
	  // the number is even or odd
		if (n%2==0){
          return true;
     	}
		else{
			return false;
	  }
	}
	 
   	
	public static int compare(int array[]){	
	  // Compare first and last element 
	  if (array[0] > array[(array.length)-1] ){
              return 1;
		}
	  else if(array[0]==array[(array.length)-1]){
                 return 0;  
              }
		else {
              return -1;
		}
		
		
     
   }
}