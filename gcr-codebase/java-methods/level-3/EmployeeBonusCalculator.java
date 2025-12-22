import java.util.*;

// Program to calculate bonus and salary details of employees
public class EmployeeBonusCalculator {

    // Method to generate salary and years of service
    // Column 0 -> Old Salary
    // Column 1 -> Years of Service
    public static double[][] generateEmployeeData() {

        double data[][] = new double[10][2];

        for (int i = 0; i < 10; i++) {
            // Generate 5-digit salary (10000 to 99999)
            data[i][0] = (int)(Math.random() * 90000) + 10000;

            // Generate years of service (1 to 10)
            data[i][1] = (int)(Math.random() * 10) + 1;
        }
        return data;
    }

    // Method to calculate new salary and bonus
    // Column 0 -> Old Salary
    // Column 1 -> Years of Service
    // Column 2 -> Bonus
    // Column 3 -> New Salary
    public static double[][] calculateBonusAndNewSalary(double[][] data) {

        double result[][] = new double[10][4];

        for (int i = 0; i < 10; i++) {

            double oldSalary = data[i][0];
            int years = (int)data[i][1];
            double bonus;

            if (years > 5) {
                bonus = oldSalary * 0.05;
            } else {
                bonus = oldSalary * 0.02;
            }

            double newSalary = oldSalary + bonus;

            result[i][0] = oldSalary;
            result[i][1] = years;
            result[i][2] = bonus;
            result[i][3] = newSalary;
        }
        return result;
    }

    // Method to calculate totals and display in tabular format
    public static void displaySalaryDetails(double[][] result) {

        double totalOldSalary = 0;
        double totalNewSalary = 0;
        double totalBonus = 0;

        System.out.println("Emp\tOldSalary\tYears\tBonus\t\tNewSalary");
        System.out.println("----------------------------------------------------------");

        for (int i = 0; i < 10; i++) {

            System.out.printf("%d\t%.0f\t\t%d\t%.2f\t%.2f\n",
                    (i + 1),
                    result[i][0],
                    (int)result[i][1],
                    result[i][2],
                    result[i][3]);

            totalOldSalary += result[i][0];
            totalBonus += result[i][2];
            totalNewSalary += result[i][3];
        }

        System.out.println("----------------------------------------------------------");
        System.out.printf("TOTAL\t%.0f\t\t-\t%.2f\t%.2f\n",
                totalOldSalary, totalBonus, totalNewSalary);
    }

    // Main method
    public static void main(String[] args) {

        // Generate employee salary and service data
        double[][] employeeData = generateEmployeeData();

        // Calculate bonus and new salary
        double[][] finalData = calculateBonusAndNewSalary(employeeData);

        // Display results
        displaySalaryDetails(finalData);
    }
}