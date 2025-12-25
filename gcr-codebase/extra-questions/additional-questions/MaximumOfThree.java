import java.util.Scanner;

public class MaximumOfThree {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Taking input from user
        System.out.println("Enter three numbers:");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        // Calling function to find maximum
        int max = findMax(a, b, c);

        System.out.println("Maximum number is: " + max);

        sc.close();
    }

    // Function to find maximum of three numbers
    public static int findMax(int x, int y, int z) {

        int max = x;

        if (y > max) {
            max = y;
        }

        if (z > max) {
            max = z;
        }

        return max;
    }
}
