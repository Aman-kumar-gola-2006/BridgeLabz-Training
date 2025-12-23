import java.util.*;

// Program to demonstrate StringIndexOutOfBoundsException
public class  StringIndexOutOfBoundsExceptionDemo
 {

    // Method to generate StringIndexOutOfBoundsException
    public static void generateException(String s) {
            
          // causes StringIndexOutOfBoundsException
		  System.out.println(s.charAt(100));
    }

    // Method to handle StringIndexOutOfBoundsException
    public static void handleException(String s) {

        try {
            System.out.println(s.charAt(100)); // risky code
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("StringIndexOutOfBoundsException handled");
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