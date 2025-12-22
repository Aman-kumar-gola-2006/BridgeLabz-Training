import java.util.*;

public class SumUntilZero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("welcome to Java World");

        double total = 0.0;
        double number;

        System.out.println("Enter numbers (0 to stop):");
        number = sc.nextDouble();

        while (number != 0) {
            total = total + number;
            number = sc.nextDouble();
        }

        System.out.println("Total sum = " + total);

        sc.close();
    }
}
