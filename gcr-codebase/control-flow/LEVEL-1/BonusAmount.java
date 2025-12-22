import java.util.*;

public class BonusAmount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter employee salary:");
        double salary = sc.nextDouble();

        System.out.println("Enter years of service:");
        int yearsOfService = sc.nextInt();

        if (yearsOfService > 5) {
            double bonus = salary * 0.05;
            System.out.println("Bonus amount = " + bonus);
        } else {
            System.out.println("No bonus applicable.");
        }

        sc.close();
    }
}
