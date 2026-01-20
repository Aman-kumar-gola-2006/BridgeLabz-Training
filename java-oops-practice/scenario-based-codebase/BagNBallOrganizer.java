import java.util.ArrayList;
import java.util.Scanner;

// Interface for bonus requirement
interface Storable {
    String getId();
}

// Ball class
class Ball implements Storable {

    private String id;
    private String color;
    private String size;

    Ball(String id, String color, String size) {
        this.id = id;
        this.color = color;
        this.size = size;
    }

    public String getId() {
        return id;
    }

    public String getColor() {
        return color;
    }

    public String getSize() {
        return size;
    }
}

// Bag class
class Bag implements Storable {

    private String id;
    private String color;
    private int capacity;
    private ArrayList<Ball> balls;

    Bag(String id, String color, int capacity) {
        this.id = id;
        this.color = color;
        this.capacity = capacity;
        this.balls = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    // Add ball to bag
    void addBall(Ball ball) {
        if (balls.size() < capacity) {
            balls.add(ball);
            System.out.println("Ball added successfully.");
        } else {
            System.out.println("Bag is full. Cannot add more balls.");
        }
    }

    // Remove ball by ID
    void removeBall(String ballId) {
        for (int i = 0; i < balls.size(); i++) {
            if (balls.get(i).getId().equals(ballId)) {
                balls.remove(i);
                System.out.println("Ball removed successfully.");
                return;
            }
        }
        System.out.println("Ball not found in this bag.");
    }

    // Display balls in bag
    void showBalls() {
        if (balls.isEmpty()) {
            System.out.println("No balls in this bag.");
            return;
        }

        for (Ball b : balls) {
            System.out.println("Ball ID: " + b.getId() +
                               ", Color: " + b.getColor() +
                               ", Size: " + b.getSize());
        }
    }

    // Get ball count
    int getBallCount() {
        return balls.size();
    }
}

public class BagNBallOrganizer {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Bag> bags = new ArrayList<>();

        System.out.print("Enter number of bags: ");
        int bagCount = sc.nextInt();
        sc.nextLine();

        // Create bags
        for (int i = 0; i < bagCount; i++) {
            System.out.println("\nEnter Bag details:");
            System.out.print("Bag ID: ");
            String bagId = sc.nextLine();
            System.out.print("Bag Color: ");
            String bagColor = sc.nextLine();
            System.out.print("Bag Capacity: ");
            int capacity = sc.nextInt();
            sc.nextLine();

            bags.add(new Bag(bagId, bagColor, capacity));
        }

        // Menu-driven operations
        int choice;
        do {
            System.out.println("\n1. Add Ball to Bag");
            System.out.println("2. Remove Ball from Bag");
            System.out.println("3. Display Balls in a Bag");
            System.out.println("4. Display All Bags and Ball Count");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter Bag ID: ");
                    String addBagId = sc.nextLine();

                    for (Bag bag : bags) {
                        if (bag.getId().equals(addBagId)) {

                            System.out.print("Ball ID: ");
                            String ballId = sc.nextLine();
                            System.out.print("Ball Color: ");
                            String ballColor = sc.nextLine();
                            System.out.print("Ball Size (small/medium/large): ");
                            String ballSize = sc.nextLine();

                            bag.addBall(new Ball(ballId, ballColor, ballSize));
                        }
                    }
                    break;

                case 2:
                    System.out.print("Enter Bag ID: ");
                    String removeBagId = sc.nextLine();
                    System.out.print("Enter Ball ID: ");
                    String removeBallId = sc.nextLine();

                    for (Bag bag : bags) {
                        if (bag.getId().equals(removeBagId)) {
                            bag.removeBall(removeBallId);
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter Bag ID: ");
                    String showBagId = sc.nextLine();

                    for (Bag bag : bags) {
                        if (bag.getId().equals(showBagId)) {
                            bag.showBalls();
                        }
                    }
                    break;

                case 4:
                    for (Bag bag : bags) {
                        System.out.println("Bag ID: " + bag.getId() +
                                           ", Balls Count: " + bag.getBallCount());
                    }
                    break;

                case 5:
                    System.out.println("Exiting system.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 5);

        sc.close();
    }
}
