import java.util.Scanner;

public class BmiStatus {

    // Method to find the BMI of every person 
    public static void findBMI(double[][] data) {
        for (int i = 0; i < data.length; i++) {
            double weight = data[i][0];
            double heightInMeters = data[i][1] / 100.0;
            data[i][2] = weight / (heightInMeters * heightInMeters);
        }
    }

    // Method to determine the BMI status 
    public static String[] findBMIStatus(double[][] data) {
        String[] statusArray = new String[data.length];
        for (int i = 0; i < data.length; i++) {
            double bmi = data[i][2];
            if (bmi < 18.5) {
                statusArray[i] = "Underweight";
            } else if (bmi >= 18.5 && bmi < 25) {
                statusArray[i] = "Normal weight";
            } else if (bmi >= 25 && bmi < 30) {
                statusArray[i] = "Overweight";
            } else {
                statusArray[i] = "Obesity";
            }
        }
        return statusArray;
    }

    public static void main(String[] args) {
        // Created a Scanner Object
        Scanner sc = new Scanner(System.in);
        System.out.println("welcome to Java World");

        // Updated size to 10 as per organization requirements
        double[][] data = new double[4][3];
        String[] statuses = new String[4];

        for (int i = 0; i < 4; i++) {
            System.out.println("Enter details for person : " + (i + 1) + ":");

            System.out.print("Weight (kg): ");
            data[i][0] = sc.nextDouble();

            System.out.print("Height (cm): ");
            data[i][1] = sc.nextDouble();
        }

        // Call methods
        findBMI(data);
        statuses = findBMIStatus(data);

        // Display results
        System.out.println("\n--------------------------------------------------------------");
        System.out.printf("%-10s %-12s %-12s %-10s %-15s\n", "Person", "Weight(kg)", "Height(cm)", "BMI", "Status");
        System.out.println("--------------------------------------------------------------");
        for (int i = 0; i < 4; i++) {
            System.out.printf("%-10d %-12.2f %-12.2f %-10.2f %-15s\n",
                (i + 1), data[i][0], data[i][1], data[i][2], statuses[i]);
        }
        
		// close the scanner
        sc.close(); 
    }
}