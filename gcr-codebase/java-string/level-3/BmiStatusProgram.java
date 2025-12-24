import java.util.Scanner;

public class BmiStatusProgram {

    // Method to calculate BMI and status and return 2D String array
    public static String[][] calculateBMI(double[][] data) {

        String[][] result = new String[10][4];

        for (int i = 0; i < data.length; i++) {

            double weight = data[i][0];
            double heightCm = data[i][1];
            double heightM = heightCm / 100;

            double bmi = weight / (heightM * heightM);

            String status;
            if (bmi < 18.5) {
                status = "Underweight";
            } else if (bmi < 25) {
                status = "Normal";
            } else if (bmi < 30) {
                status = "Overweight";
            } else {
                status = "Obese";
            }

            result[i][0] = String.valueOf(heightCm);
            result[i][1] = String.valueOf(weight);
            result[i][2] = String.valueOf(bmi);
            result[i][3] = status;
        }

        return result;
    }

    // Method to display result in table format
    public static void displayResult(String[][] result) {

        System.out.println("\nPerson\tHeight\tWeight\tBMI\tStatus");
        System.out.println("-------------------------------------------");

        for (int i = 0; i < result.length; i++) {
            System.out.println(
                    (i + 1) + "\t" +
                    result[i][0] + "\t" +
                    result[i][1] + "\t" +
                    result[i][2] + "\t" +
                    result[i][3]
            );
        }
    }

    // Main method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 2D array to store weight and height
        double[][] data = new double[10][2];

        // Taking input for 10 persons
        for (int i = 0; i < 10; i++) {
            System.out.println("Enter details for person " + (i + 1));

            System.out.print("Weight (kg): ");
            data[i][0] = sc.nextDouble();

            System.out.print("Height (cm): ");
            data[i][1] = sc.nextDouble();
        }

        // Call methods
        String[][] result = calculateBMI(data);
        displayResult(result);

        sc.close();
    }
}
