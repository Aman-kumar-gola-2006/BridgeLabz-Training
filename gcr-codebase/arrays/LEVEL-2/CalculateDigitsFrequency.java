//calculate digits frequency
import java.util.Scanner;

public class CalculateDigitsFrequency {
   public static void main(String[] args) {

      // Create a Scanner Object
      Scanner sc = new Scanner(System.in);
	  
	  //take input of number from user
	  System.out.println("enter the number ");
	  long n = sc.nextLong();
	  
	  //creating a variable  
	  int maxDigit = 10;
	  
	  // Creating an Array of maxDigit 
	  int digits[] = new int[maxDigit];
	  
	  // Creating a variable index  
	  int index = 0;
		
	  int temp[];

	  // extracting digits from the given number 
	  while (n > 0) {
		  if (index == maxDigit) {
			  maxDigit = maxDigit + 10;
			  temp = new int[maxDigit];

			  for (int j = 0; j < index; j++)
				  temp[j] = digits[j];

			  digits = temp;
		  }
		  digits[index] = (int)(n % 10);
		  n = n / 10;
		  index++;
	  }

	  // frequency array
	  int frequency[] = new int[10];

	  // calculate frequency
	  //the initial value frequency={0,0,0,0,0,0,0,0,0}
	  
	  for (int i = 0; i < index; i++) {
		  
     //frequency[digits[i]]= frequency[digits[0]]= frequency[3]++
     // Means we are incrementing the value at frequency [3] index which is 0
     //frequency{0,0,0,1,0,0,0,0,0}	 
		  frequency[digits[i]]++;
	  }

	  // display frequency
	  for (int i = 0; i < frequency.length; i++) {
		  if (frequency[i] > 0) {
			  System.out.println("Digit " + i + " occurs " + frequency[i] + " times");
		  }
	  }

      // Close the Scanner Object
      sc.close();
   }
}