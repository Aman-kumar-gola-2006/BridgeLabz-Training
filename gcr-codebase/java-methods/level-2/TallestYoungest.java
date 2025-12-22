// Find tallest and youngest among Amar, Akbar ,Anthony
import java.util.Scanner;

public class TallestYoungest {
	
	public static void tallest(int height[])
   {  
	 String[] names = {"Amar", "Akbar", "Anthony"};
	  int tallestIndex = 0;

      for (int i = 1; i < 3; i++) {
         if (height[i] > height[tallestIndex]) {
            tallestIndex = i;
         }
      }
      System.out.println(names[tallestIndex] + " is tallest");
   }
   
   public static void youngest(int age[])
   {  
	 String[] names = {"Amar", "Akbar", "Anthony"};
      int youngestIndex = 0;

      for (int i = 1; i < 3; i++) {
         if (age[i] < age[youngestIndex]) {
            youngestIndex = i;
         }
      }
      System.out.println(names[youngestIndex] + " is youngest");
   }
   
	
   public static void main(String[] args) {
      // Create a Scanner Object
      Scanner sc = new Scanner(System.in);
	  
	  // Creating an Array of length 3 for height 
	  int height[] = new int[3];
	  
	  // Creating an Array of length 3 for age 
	  int age[] = new int[3];
	  
		System.out.println("Enter their heights");

	  // For loop to take input from the user and store 
	  // them into the Array
	  for(int i=0; i<height.length; i++){
			height[i] = sc.nextInt();
		}
    System.out.println("Enter their ages");		
		for(int i=0; i<age.length; i++){
			age[i] = sc.nextInt();
		}
		
		
      tallest(height);
	  youngest(age);
		
      // Close the Scanner Object
      sc.close();
   }
}