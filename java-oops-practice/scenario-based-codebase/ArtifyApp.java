import java.util.Scanner;

// Interface
interface IPurchasable {
    void purchase(User user);
    void licenseArt();
}

// Base Class
class Artwork implements IPurchasable {
    protected String title;
    protected String artist;
    protected double price;
    protected String licenseType;   // Encapsulated (protected)

    // Constructor without preview
    Artwork(String title, String artist, double price, String licenseType) {
        this.title = title;
        this.artist = artist;
        this.price = price;
        this.licenseType = licenseType;
    }

    // Constructor with preview (simple message)
    Artwork(String title, String artist, double price, String licenseType, String preview) {
        this(title, artist, price, licenseType);
        System.out.println("Preview: " + preview);
    }

    public void purchase(User user) {
        if (user.getWalletBalance() >= price) {
            user.deductBalance(price);
            System.out.println("Purchase successful! " + title + " bought by " + user.getName());
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    public void licenseArt() {
        System.out.println("General license applied: " + licenseType);
    }
}

// Digital Art Class
class DigitalArt extends Artwork {

    DigitalArt(String title, String artist, double price, String licenseType) {
        super(title, artist, price, licenseType);
    }

    public void licenseArt() {
        System.out.println("Digital License: Can be used online with watermark rules.");
    }
}

// Print Art Class
class PrintArt extends Artwork {

    PrintArt(String title, String artist, double price, String licenseType) {
        super(title, artist, price, licenseType);
    }

    public void licenseArt() {
        System.out.println("Print License: Can print physical copies for personal use.");
    }
}

// User Class
class User {
    private String name;
    private double walletBalance;

    User(String name, double walletBalance) {
        this.name = name;
        this.walletBalance = walletBalance;
    }

    public String getName() {
        return name;
    }

    public double getWalletBalance() {
        return walletBalance;
    }

    public void deductBalance(double amount) {
        walletBalance -= amount;
    }
}

// Main Class
public class ArtifyApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // User Input
        System.out.print("Enter your name: ");
        String userName = sc.nextLine();

        System.out.print("Enter your wallet balance: ");
        double balance = sc.nextDouble();
        sc.nextLine();

        User user = new User(userName, balance);

        // Artwork Input
        System.out.print("Enter artwork title: ");
        String title = sc.nextLine();

        System.out.print("Enter artist name: ");
        String artist = sc.nextLine();

        System.out.print("Enter price: ");
        double price = sc.nextDouble();
        sc.nextLine();

        System.out.print("Enter license type: ");
        String license = sc.nextLine();

        System.out.print("Choose art type (1=Digital, 2=Print): ");
        int type = sc.nextInt();

        Artwork art;

        if (type == 1) {
            art = new DigitalArt(title, artist, price, license);
        } else {
            art = new PrintArt(title, artist, price, license);
        }

        // Purchase Flow
        System.out.println("\nAttempting purchase...");
        art.purchase(user);

        // Licensing Polymorphism
        System.out.println("Applying license:");
        art.licenseArt();
    }
}
