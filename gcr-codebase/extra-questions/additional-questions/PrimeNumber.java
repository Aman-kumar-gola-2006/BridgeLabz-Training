import java.util.Scanner;

public class PrimeNumber {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Taking number input
        System.out.println("Enter a number:");
        int num = sc.nextInt();

        // Checking prime
        if (isPrime(num)) {
            System.out.println(num + " is a Prime number.");
        } else {
            System.out.println(num + " is NOT a Prime number.");
        }

        sc.close();
    }

    // Function to check prime number
    public static boolean isPrime(int n) {

        // Numbers less than or equal to 1 are not prime
        if (n <= 1) {
            return false;
        }

        // Checking divisibility
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}
