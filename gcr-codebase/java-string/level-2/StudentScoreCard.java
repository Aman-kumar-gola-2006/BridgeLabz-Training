import java.util.*;

// Program to calculate total, average, percentage and grade of students
public class StudentScoreCard {

    // Method to generate random PCM marks for students
    // Column 0 -> Physics, Column 1 -> Chemistry, Column 2 -> Maths
    public static int[][] generatePCMScores(int students) {

        int scores[][] = new int[students][3];

        for (int i = 0; i < students; i++) {
            scores[i][0] = (int)(Math.random() * 90) + 10;
            scores[i][1] = (int)(Math.random() * 90) + 10;
            scores[i][2] = (int)(Math.random() * 90) + 10;
        }
        return scores;
    }

    // Method to calculate total, average and percentage
    // Column 0 -> Total, Column 1 -> Average, Column 2 -> Percentage
    public static double[][] calculateResults(int[][] scores) {

        double result[][] = new double[scores.length][3];

        for (int i = 0; i < scores.length; i++) {

            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double average = total / 3.0;
            double percentage = (total / 300.0) * 100;

            average = Math.round(average * 100.0) / 100.0;
            percentage = Math.round(percentage * 100.0) / 100.0;

            result[i][0] = total;
            result[i][1] = average;
            result[i][2] = percentage;
        }
        return result;
    }

    // Method to calculate grade based on percentage
    public static String grade(double percentage) {

        if (percentage >= 80)
            return "A";
        else if (percentage >= 70)
            return "B";
        else if (percentage >= 60)
            return "C";
        else if (percentage >= 50)
            return "D";
        else if (percentage >= 40)
            return "E";
        else
            return "R";
    }

    // Method to display scorecard
    public static void displayScoreCard(int[][] scores, double[][] result) {

        System.out.println("Stu\tPhy\tChem\tMath\tTotal\tAvg\tPercent\tGrade");
        System.out.println("---------------------------------------------------------------------");

        for (int i = 0; i < scores.length; i++) {

            String grade = grade(result[i][2]);

            System.out.println(
                (i + 1) + "\t" +
                scores[i][0] + "\t" +
                scores[i][1] + "\t" +
                scores[i][2] + "\t" +
                (int)result[i][0] + "\t" +
                result[i][1] + "\t" +
                result[i][2] + "\t" +
                grade
            );
        }
    }

    // Main method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of students:");
        int students = sc.nextInt();

        int[][] scores = generatePCMScores(students);
        double[][] results = calculateResults(scores);

        displayScoreCard(scores, results);

        sc.close();
    }
}