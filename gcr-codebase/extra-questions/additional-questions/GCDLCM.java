import java.util.Scanner;

public class GCDLCM {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Taking inputs
        System.out.println("Enter first number:");
        int a = sc.nextInt();

        System.out.println("Enter second number:");
        int b = sc.nextInt();

        // Calling functions
        int gcd = findGCD(a, b);
        int lcm = findLCM(a, b);

        System.out.println("GCD is: " + gcd);
        System.out.println("LCM is: " + lcm);

        sc.close();
    }

    // Function to find GCD
    public static int findGCD(int x, int y) {

        while (y != 0) {
            int temp = y;
            y = x % y;
            x = temp;
        }
        return x;
    }

    // Function to find LCM
    public static int findLCM(int x, int y) {
        return (x * y) / findGCD(x, y);
    }
}
