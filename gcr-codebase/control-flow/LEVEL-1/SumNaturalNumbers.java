import java.util.*;

public class SumNaturalNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("welcome to Java World");
        System.out.println("Enter a number:");
        int n = sc.nextInt();

        if (n > 0) {
            int sumByFormula = n * (n + 1) / 2;

            int sumByLoop = 0;
            int i = 1;

            while (i <= n) {
                sumByLoop = sumByLoop + i;
                i++;
            }

            System.out.println("Sum using formula = " + sumByFormula);
            System.out.println("Sum using while loop = " + sumByLoop);

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
