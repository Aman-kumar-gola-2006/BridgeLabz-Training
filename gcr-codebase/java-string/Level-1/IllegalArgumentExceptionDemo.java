import java.util.*;

// Program to demonstrate IllegalArgumentException
public class  IllegalArgumentExceptionDemo
 {

    // Method to generate  IllegalArgumentException
    public static void generateException(String s) {
            
          // causes  IllegalArgumentException
		  System.out.println(s.substring(100));
    }

    // Method to handle  IllegalArgumentException
    public static void handleException(String s) {

        try {
            System.out.println(s.substring(500)); // risky code
        } catch (IllegalArgumentException e) {
            System.out.println(" IllegalArgumentException handled");
        }
    }

    // Main method
    public static void main(String[] args) {
      
		Scanner sc= new Scanner(System.in); 
        String text = sc.next();// taking user input for text

        // Calling method that generates exception
        System.out.println("Generating Exception:");
      // generateException(text);

        // Refactored code to handle exception
        System.out.println("\nHandling Exception:");
        handleException(text);
    }
}