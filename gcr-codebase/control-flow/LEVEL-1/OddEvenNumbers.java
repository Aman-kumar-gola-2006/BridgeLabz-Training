import java.util.*;

public class OddEvenNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("welcome to Java World");

        System.out.println("Enter a natural number:");
        int number = sc.nextInt();

        if (number > 0) {
            for (int i = 1; i <= number; i++) {
                if (i % 2 == 0) {
                    System.out.println(i + " is an Even number");
                } else {
                    System.out.println(i + " is an Odd number");
                }
            }
        } else {
            System.out.println("Please enter a natural number greater than 0.");
        }

        sc.close();
    }
}
