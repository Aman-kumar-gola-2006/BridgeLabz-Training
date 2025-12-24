import java.util.Scanner;

public class DeckOfCards {

    // Method to initialize the deck
    public static String[] initializeDeck(String[] suits, String[] ranks) {

        int numOfCards = suits.length * ranks.length;
        String[] deck = new String[numOfCards];

        int index = 0;
        for (int i = 0; i < suits.length; i++) {
            for (int j = 0; j < ranks.length; j++) {
                deck[index] = ranks[j] + " of " + suits[i];
                index++;
            }
        }
        return deck;
    }

    // Method to shuffle the deck
    public static String[] shuffleDeck(String[] deck) {

        int n = deck.length;

        for (int i = 0; i < n; i++) {
            int randomCardNumber = i + (int)(Math.random() * (n - i));

            // swap cards
            String temp = deck[i];
            deck[i] = deck[randomCardNumber];
            deck[randomCardNumber] = temp;
        }
        return deck;
    }

    // Method to distribute cards to players
    public static String[][] distributeCards(String[] deck, int players, int cardsPerPlayer) {

        int totalCards = players * cardsPerPlayer;

        if (totalCards > deck.length) {
            System.out.println("Cards cannot be distributed.");
            return null;
        }

        String[][] result = new String[players][cardsPerPlayer];

        int cardIndex = 0;
        for (int i = 0; i < players; i++) {
            for (int j = 0; j < cardsPerPlayer; j++) {
                result[i][j] = deck[cardIndex];
                cardIndex++;
            }
        }
        return result;
    }

    // Method to print players and their cards
    public static void printPlayers(String[][] players) {

        for (int i = 0; i < players.length; i++) {
            System.out.println("\nPlayer " + (i + 1) + ":");
            for (int j = 0; j < players[i].length; j++) {
                System.out.println(players[i][j]);
            }
        }
    }

    // Main method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9",
                          "10", "Jack", "Queen", "King", "Ace"};

        String[] deck = initializeDeck(suits, ranks);
        deck = shuffleDeck(deck);

        System.out.println("Enter number of players:");
        int players = sc.nextInt();

        System.out.println("Enter number of cards per player:");
        int cardsPerPlayer = sc.nextInt();

        String[][] distributed = distributeCards(deck, players, cardsPerPlayer);

        if (distributed != null) {
            printPlayers(distributed);
        }

        sc.close();
    }
}
