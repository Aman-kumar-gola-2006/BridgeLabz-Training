import java.util.*;

// Interface
interface IDownloadable {
    void download();
    void playDemo();
}

// Base Game class
abstract class Game implements IDownloadable {
    protected String title;
    protected String genre;
    protected double price;
    protected double rating;

    // Constructor for free or paid games
    public Game(String title, String genre, double price, double rating) {
        this.title = title;
        this.genre = genre;
        this.price = price;
        this.rating = rating;
    }

    // Apply seasonal discount (operator usage)
    public void applyOffer(double discountPercent) {
        price = price - (price * discountPercent / 100);
    }

    public String getTitle() {
        return title;
    }
}

// ArcadeGame – Inheritance
class ArcadeGame extends Game {

    public ArcadeGame(String title, double price, double rating) {
        super(title, "Arcade", price, rating);
    }

    public void download() {
        System.out.println("Downloading Arcade game: " + title);
    }

    // Polymorphism: different demo style
    public void playDemo() {
        System.out.println("Playing a fast-paced Arcade demo for: " + title);
    }
}

// StrategyGame – Inheritance
class StrategyGame extends Game {

    public StrategyGame(String title, double price, double rating) {
        super(title, "Strategy", price, rating);
    }

    public void download() {
        System.out.println("Downloading Strategy game: " + title);
    }

    // Polymorphism: different demo style
    public void playDemo() {
        System.out.println("Trying strategic demo level for: " + title);
    }
}

// User class with Encapsulation
class User {
    private String name;
    private ArrayList<Game> ownedGames = new ArrayList<>();

    public User(String name) {
        this.name = name;
    }

    // Protected add method
    public void buyGame(Game game) {
        ownedGames.add(game);
        System.out.println(name + " purchased " + game.getTitle());
    }

    // Encapsulated view
    public void showOwnedGames() {
        System.out.println("Owned Games:");
        for (Game g : ownedGames) {
            System.out.println("- " + g.getTitle());
        }
    }
}

// Main GameBox System
public class GameBox {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // User Setup
        System.out.print("Enter user name: ");
        String uname = sc.nextLine();
        User user = new User(uname);

        ArrayList<Game> store = new ArrayList<>();

        // Adding sample games
        store.add(new ArcadeGame("Speed Rush", 200, 4.5));
        store.add(new StrategyGame("Empire Build", 350, 4.7));

        while (true) {
            System.out.println("\n--- GameBox Menu ---");
            System.out.println("1. View Store Games");
            System.out.println("2. Apply Seasonal Offer");
            System.out.println("3. Download Demo");
            System.out.println("4. Buy Game");
            System.out.println("5. View Owned Games");
            System.out.println("6. Exit");
            System.out.print("Choose: ");

            int ch = sc.nextInt();

            if (ch == 6) break;

            switch (ch) {
                case 1:
                    System.out.println("Available Games:");
                    for (int i = 0; i < store.size(); i++) {
                        Game g = store.get(i);
                        System.out.println((i + 1) + ". " + g.title + " | Price: " + g.price);
                    }
                    break;

                case 2:
                    System.out.print("Enter discount percentage: ");
                    double d = sc.nextDouble();
                    for (Game g : store) g.applyOffer(d);
                    System.out.println("Offer applied!");
                    break;

                case 3:
                    System.out.print("Enter game index to play demo: ");
                    int demoIndex = sc.nextInt() - 1;
                    store.get(demoIndex).playDemo();
                    break;

                case 4:
                    System.out.print("Enter game index to buy: ");
                    int buyIndex = sc.nextInt() - 1;
                    user.buyGame(store.get(buyIndex));
                    break;

                case 5:
                    user.showOwnedGames();
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
