import java.util.*;

// Program to demonstrate NullPointerException
public class NullPointerDemo {

    // Method to generate NullPointerException
    public static void generateException() {

        String text = null;          // text initialized to null
        System.out.println(text.length());   // causes NullPointerException
    }

    // Method to handle NullPointerException
    public static void handleException() {

        String text = null;          // text initialized to null

        try {
            System.out.println(text.length());   // risky code
        } catch (NullPointerException e) {
            System.out.println("NullPointerException handled");
        }
    }

    // Main method
    public static void main(String[] args) {

        // Calling method that generates exception
        System.out.println("Generating Exception:");
        generateException();

        // Refactored code to handle exception
        System.out.println("\nHandling Exception:");
        handleException();
    }
}