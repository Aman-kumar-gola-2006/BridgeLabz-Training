import java.util.Scanner;   // Import Scanner class for user input

public class MeanHeight {
    public static void main(String[] args) {
        System.out.println("welcome to Java World");
        Scanner sc = new Scanner(System.in);  
        // Create Scanner object

        double[] heights = new double[11];  
        // Declare double array of size 11 to store heights of players

        double sum = 0.0;  
        // Variable to store sum of all heights

        // Take input for heights of 11 players
        System.out.println("Enter height of 11 football players:");
        for (int i = 0; i < heights.length; i++) {
            heights[i] = sc.nextDouble();  
            // Store each height in the array
        }

        // Calculate sum of all elements in the array
        for (int i = 0; i < heights.length; i++) {
            sum = sum + heights[i];  
            // Add each height to sum
        }

        // Calculate mean height
        double mean = sum / heights.length;  
        // Mean = sum of heights / number of players

        // Display the mean height
        System.out.println("Mean height of the football team = " + mean);

        sc.close();  
        // Close Scanner
    }
}
