import java.util.ArrayList;
import java.util.Scanner;

// Class representing a Line
class Line {

    private double x1, y1, x2, y2;   // encapsulated data

    // Constructor to initialize line coordinates
    Line(double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    // Method to calculate length of the line
    double getLength() {
        double dx = x2 - x1;
        double dy = y2 - y1;
        return Math.sqrt((dx * dx) + (dy * dy));
    }
}

public class GeoMeasureLineComparison {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<String> results = new ArrayList<>();

        System.out.print("Enter number of line comparisons: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {

            System.out.println("\nEnter coordinates for Line 1:");
            double x1 = sc.nextDouble();
            double y1 = sc.nextDouble();
            double x2 = sc.nextDouble();
            double y2 = sc.nextDouble();

            System.out.println("Enter coordinates for Line 2:");
            double x3 = sc.nextDouble();
            double y3 = sc.nextDouble();
            double x4 = sc.nextDouble();
            double y4 = sc.nextDouble();

            // Creating objects using constructor
            Line line1 = new Line(x1, y1, x2, y2);
            Line line2 = new Line(x3, y3, x4, y4);

            double len1 = line1.getLength();
            double len2 = line2.getLength();

            String result;

            if (len1 == len2) {
                result = "Both lines are equal in length";
            } else if (len1 > len2) {
                result = "Line 1 is longer";
            } else {
                result = "Line 2 is longer";
            }

            results.add(result);
            System.out.println(result);
        }

        // Display all comparison results
        System.out.println("\nSummary of Comparisons:");
        for (int i = 0; i < results.size(); i++) {
            System.out.println("Comparison " + (i + 1) + ": " + results.get(i));
        }

        sc.close();
    }
}
