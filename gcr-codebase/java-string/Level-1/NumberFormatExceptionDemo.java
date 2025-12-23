import java.util.*;

// Program to demonstrate NumberFormatException
public class  NumberFormatExceptionDemo
 {

    // Method to generate  NumberFormatException
    public static void generateException(String s) {
            
          // causes  NumberFormatException
		  System.out.println(Integer.parseInt(s));
    }

    // Method to handle  NumberFormatException
    public static void handleException(String s) {

        try {
            System.out.println(Integer.parseInt(s)); // risky code
        } catch (NumberFormatException e) {
            System.out.println(" NumberFormatException handled");
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