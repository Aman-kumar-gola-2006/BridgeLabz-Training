import java.util.Random;

// Create a class to calculate height statistics of football players
public class FootballTeamHeights {

    // Method to generate random heights for players
    public static int[] generateHeights() {
        int heights[] = new int[11];
        Random r = new Random();

        for (int i = 0; i < heights.length; i++) {
            // Random height between 150 and 250 cm
            heights[i] = 150 + r.nextInt(101);
        }
        return heights;
    }

    // Method to find sum of all heights
    public static int findSum(int heights[]) {
        int sum = 0;
        for (int i = 0; i < heights.length; i++) {
            sum = sum + heights[i];
        }
        return sum;
    }

    // Method to find mean height
    public static double findMean(int heights[]) {
        int sum = findSum(heights);
        return (double) sum / heights.length;
    }

    // Method to find shortest height
    public static int findShortest(int heights[]) {
        int min = heights[0];
        for (int i = 1; i < heights.length; i++) {
            if (heights[i] < min) {
                min = heights[i];
            }
        }
        return min;
    }

    // Method to find tallest height
    public static int findTallest(int heights[]) {
        int max = heights[0];
        for (int i = 1; i < heights.length; i++) {
            if (heights[i] > max) {
                max = heights[i];
            }
        }
        return max;
    }

    // Main method
    public static void main(String[] args) {

        // Generate heights of football players
        int heights[] = generateHeights();

        // Display heights
        System.out.println("Heights of players:");
        for (int i = 0; i < heights.length; i++) {
            System.out.print(heights[i] + " ");
        }

        System.out.println();

        // Calculate and display results
        System.out.println("Shortest Height : " + findShortest(heights) + " cm");
        System.out.println("Tallest Height  : " + findTallest(heights) + " cm");
        System.out.println("Mean Height     : " + findMean(heights) + " cm");
    }
}