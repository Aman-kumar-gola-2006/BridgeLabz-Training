import java.util.*;

public class SumNaturalNumbersForLoop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a number:");
        int n = sc.nextInt();

        if (n > 0) {
            // Sum using formula
            int sumByFormula = n * (n + 1) / 2;

            // Sum using for loop
            int sumByLoop = 0;

            for (int i = 1; i <= n; i++) {
                sumByLoop = sumByLoop + i;
            }

            System.out.println("Sum using formula = " + sumByFormula);
            System.out.println("Sum using for loop = " + sumByLoop);

            if (sumByFormula == sumByLoop) {
                System.out.println("Both results are correct and same.");
            } else {
                System.out.println("Results are not same.");
            }

        } else {
            System.out.println("The entered number is not a natural number.");
        }

        sc.close();
    }
}
