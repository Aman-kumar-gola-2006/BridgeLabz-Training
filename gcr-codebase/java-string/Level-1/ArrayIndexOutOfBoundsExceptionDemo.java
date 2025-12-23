import java.util.*;

// Program to demonstrate ArrayIndexOutOfBoundsException
public class ArrayIndexOutOfBoundsExceptionDemo {

    // Method to generate ArrayIndexOutOfBoundsException
    public static void generateException(String[] names) {

        // Accessing index greater than array length
        System.out.println(names[10]);   // causes exception
    }

    // Method to handle ArrayIndexOutOfBoundsException
    public static void handleException(String[] names) {

        try {
            System.out.println(names[10]);   // risky code
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException handled");
        } catch (RuntimeException e) {
            System.out.println("RuntimeException handled");
        }
    }

    // Main method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Taking input for array size
        System.out.println("Enter number of names:");
        int n = sc.nextInt();
        sc.nextLine();

        String[] names = new String[n];

        // Taking input for names
        for (int i = 0; i < n; i++) {
            System.out.println("Enter name " + (i + 1) + ":");
            names[i] = sc.nextLine();
        }

        // Calling method that generates exception
        System.out.println("\nGenerating Exception:");
        // generateException(names);   // Uncomment to see abrupt termination

        // Calling method that handles exception
        System.out.println("\nHandling Exception:");
        handleException(names);

        sc.close();
    }
}