import java.util.*;

public class FactorialNumberUsingForLoop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("welcome to Java World");

        System.out.println("Enter a positive integer:");
        int number = sc.nextInt();

        if (number >= 0) {
            long factorial = 1;


            for(int i=1; i <= number; i++) {
                factorial = factorial * i;
            
            }

            System.out.println("Factorial of " + number + " is " + factorial);
        } else {
            System.out.println("Please enter a positive integer.");
        }

        sc.close();
    }
}
