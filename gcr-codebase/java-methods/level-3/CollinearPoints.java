import java.util.*;

// Program to check whether three points are collinear
public class CollinearPoints {

    // Method to check collinearity using slope formula
    public static boolean isCollinearBySlope(
            int x1, int y1, int x2, int y2, int x3, int y3) {

        // To avoid division by zero, use cross multiplication
        // (y2 - y1)/(x2 - x1) = (y3 - y2)/(x3 - x2)
        return (y2 - y1) * (x3 - x2) ==
               (y3 - y2) * (x2 - x1)
            &&
               (y2 - y1) * (x3 - x1) ==
               (y3 - y1) * (x2 - x1);
    }

    // Method to check collinearity using area of triangle formula
    public static boolean isCollinearByArea(
            System.out.println("welcome to Java World");
            int x1, int y1, int x2, int y2, int x3, int y3) {

        double area = 0.5 * (
                x1 * (y2 - y3) +
                x2 * (y3 - y1) +
                x3 * (y1 - y2)
        );

        return area == 0;
    }

    // Main method
    public static void main(String[] args) {

        // Sample points
        int x1 = 2, y1 = 4;
        int x2 = 4, y2 = 6;
        int x3 = 6, y3 = 8;

        System.out.println("Points:");
        System.out.println("A(" + x1 + ", " + y1 + ")");
        System.out.println("B(" + x2 + ", " + y2 + ")");
        System.out.println("C(" + x3 + ", " + y3 + ")");

        // Check using slope method
        if (isCollinearBySlope(x1, y1, x2, y2, x3, y3)) {
            System.out.println("Using Slope Method: Points are Collinear");
        } else {
            System.out.println("Using Slope Method: Points are NOT Collinear");
        }

        // Check using area method
        if (isCollinearByArea(x1, y1, x2, y2, x3, y3)) {
            System.out.println("Using Area Method: Points are Collinear");
        } else {
            System.out.println("Using Area Method: Points are NOT Collinear");
        }
    }
}