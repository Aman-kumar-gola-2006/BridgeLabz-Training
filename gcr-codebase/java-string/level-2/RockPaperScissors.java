import java.util.*;

public class RockPaperScissors {

    // Method to get computer choice using Math.random()
    public static String getComputerChoice() {
        int choice = (int)(Math.random() * 3);

        if (choice == 0)
            return "Rock";
        else if (choice == 1)
            return "Paper";
        else
            return "Scissors";
    }

    // Method to find winner of one game
    public static String findWinner(String user, String computer) {

        if (user.equals(computer)) {
            return "Draw";
        }

        if ((user.equals("Rock") && computer.equals("Scissors")) ||
            (user.equals("Paper") && computer.equals("Rock")) ||
            (user.equals("Scissors") && computer.equals("Paper"))) {
            return "User";
        } else {
            return "Computer";
        }
    }

    // Method to calculate wins and percentages
    public static String[][] calculateStats(int userWins, int compWins, int totalGames) {

        String[][] stats = new String[2][3];

        double userPercent = (userWins * 100.0) / totalGames;
        double compPercent = (compWins * 100.0) / totalGames;

        stats[0][0] = "User";
        stats[0][1] = String.valueOf(userWins);
        stats[0][2] = String.valueOf(userPercent);

        stats[1][0] = "Computer";
        stats[1][1] = String.valueOf(compWins);
        stats[1][2] = String.valueOf(compPercent);

        return stats;
    }

    // Method to display game results and stats
    public static void displayResults(String[][] games, String[][] stats) {

        System.out.println("\nGame Results:");
        System.out.println("Game\tUser\tComputer\tWinner");

        for (int i = 0; i < games.length; i++) {
            System.out.println((i + 1) + "\t" +
                    games[i][0] + "\t" +
                    games[i][1] + "\t\t" +
                    games[i][2]);
        }

        System.out.println("\nFinal Statistics:");
        System.out.println("Player\tWins\tWin %");

        for (int i = 0; i < stats.length; i++) {
            System.out.println(stats[i][0] + "\t" +
                    stats[i][1] + "\t" +
                    stats[i][2]);
        }
    }

    // Main method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of games:");
        int n = sc.nextInt();

        String[][] games = new String[n][3];

        int userWins = 0;
        int compWins = 0;

        for (int i = 0; i < n; i++) {

            System.out.println("\nGame " + (i + 1));
            System.out.println("Enter your choice (Rock / Paper / Scissors):");
            String userChoice = sc.next();

            String computerChoice = getComputerChoice();
            String winner = findWinner(userChoice, computerChoice);

            if (winner.equals("User"))
                userWins++;
            else if (winner.equals("Computer"))
                compWins++;

            games[i][0] = userChoice;
            games[i][1] = computerChoice;
            games[i][2] = winner;
        }

        String[][] stats = calculateStats(userWins, compWins, n);
        displayResults(games, stats);
    }
}
