import java.util.Scanner;

public class TemperatureLogger {

    // Method to calculate average temperature
    public static double calculateAverage(double[] temp) {
        double sum = 0;
        for (int i = 0; i < temp.length; i++) {
            sum += temp[i];
        }
        return sum / temp.length;
    }

    // Method to find maximum temperature
    public static double findMaximum(double[] temp) {
        double max = temp[0];

        for (int i = 1; i < temp.length; i++) {
            if (temp[i] > max) {
                max = temp[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        double[] temperature = new double[7];

        System.out.println("Enter temperature for 7 days:");

        // Input temperatures
        for (int i = 0; i < 7; i++) {
            System.out.print("Day " + (i + 1) + " temperature: ");
            temperature[i] = sc.nextDouble();
        }

        // Calculate average and maximum
        double average = calculateAverage(temperature);
        double maximum = findMaximum(temperature);

        // Display result
        System.out.println("\n--- Temperature Report ---");
        System.out.println("Average Temperature: " + average + " °C");
        System.out.println("Maximum Temperature: " + maximum + " °C");

        sc.close();
    }
}
