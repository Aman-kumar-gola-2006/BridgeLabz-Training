import java.util.*;

public class CalculateBMI2D {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input for number of persons 
        System.out.println("Enter number of persons");
        int number = sc.nextInt();

        // Multi-dimensional array to store [weight, height, BMI]
        double[][] personData = new double[number][3];
        // Array to store the weight status
        String[] weightStatus = new String[number];

        // for loop to take input of weight and height
        for (int i = 0; i < number; i++) {
            System.out.println("Enter weight of " + (i + 1) + " person");
            double w = sc.nextDouble();

            System.out.println("Enter the height of " + (i + 1) + " person");
            double h = sc.nextDouble();

            // check for error inputs
            if (w <= 0 || h <= 0) {
                System.out.println("Invalid input! Please enter positive values.");
                i--; // decrement index as required
                continue;
            }
            
            personData[i][0] = w; // weight
            personData[i][1] = h; // height
        }

        // for loop to calculate the BMI and Weight Status
        for (int i = 0; i < number; i++) {
            // Calculate BMI: weight / (height * height)
            personData[i][2] = personData[i][0] / (personData[i][1] * personData[i][1]);

            // check table for status
            if (personData[i][2] <= 18.4) {
                weightStatus[i] = "Underweight";
            } else if (personData[i][2] >= 18.5 && personData[i][2] <= 24.9) {
                weightStatus[i] = "Normal";
            } else if (personData[i][2] >= 25.0 && personData[i][2] <= 39.9) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obese";
            }
        }

        // for loop to display the output in the original format
        for (int i = 0; i < number; i++) {
            System.out.println("The " + (i + 1) + " person's weight is : " + personData[i][0]);
            System.out.println("The " + (i + 1) + " person's height is : " + personData[i][1]);
            System.out.println("The " + (i + 1) + " person's Bmi is : " + personData[i][2]);
            System.out.println("The " + (i + 1) + " person's weight status is " + weightStatus[i]);
            System.out.println(); // empty line for readability
        }

        sc.close();
    }
}