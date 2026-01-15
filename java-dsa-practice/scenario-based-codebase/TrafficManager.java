import java.util.*;

class TrafficManager {

    // Node class for Circular Linked List
    static class Car {
        int carNumber;
        Car next;

        Car(int carNumber) {
            this.carNumber = carNumber;
            this.next = null;
        }
    }

    private Car head = null;
    private int maxCars;       // Maximum cars allowed in roundabout
    private int currentCars = 0;

    Queue<Integer> waitingQueue;
    int queueLimit;

    // Constructor
    TrafficManager(int maxCars, int queueLimit) {
        this.maxCars = maxCars;
        this.queueLimit = queueLimit;
        this.waitingQueue = new LinkedList<>();
    }

    // Add car to roundabout
    public void addCar(int carNumber) {
        if (currentCars == maxCars) {
            // Check for Queue Overflow
            if (waitingQueue.size() == queueLimit) {
                System.out.println("Queue Overflow! No more cars can wait.");
            } else {
                waitingQueue.add(carNumber);
                System.out.println("Roundabout full. Car " + carNumber + " added to waiting queue.");
            }
            return;
        }

        Car newCar = new Car(carNumber);

        if (head == null) {
            head = newCar;
            head.next = head; // Point to itself (circular)
        } else {
            Car temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newCar;
            newCar.next = head;
        }

        currentCars++;
        System.out.println("Car " + carNumber + " entered the roundabout.");
    }

    // Remove a car from roundabout
    public void removeCar(int carNumber) {
        if (head == null) {
            System.out.println("Roundabout is empty.");
            return;
        }

        Car temp = head;
        Car prev = null;

        // Traverse to find the car
        do {
            if (temp.carNumber == carNumber) {
                if (prev == null) {  
                    // Removing head car
                    Car last = head;
                    while (last.next != head) {
                        last = last.next;
                    }
                    head = head.next;
                    last.next = head;
                } else {
                    prev.next = temp.next;
                }

                currentCars--;
                System.out.println("Car " + carNumber + " exited the roundabout.");

                // Check waiting queue
                if (!waitingQueue.isEmpty()) {
                    int nextCar = waitingQueue.poll();
                    addCar(nextCar);
                }
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);

        System.out.println("Car " + carNumber + " not found.");
    }

    // Print roundabout state
    public void printRoundabout() {
        if (head == null) {
            System.out.println("Roundabout is empty.");
            return;
        }

        Car temp = head;
        System.out.print("Cars in roundabout: ");
        do {
            System.out.print(temp.carNumber + " ");
            temp = temp.next;
        } while (temp != head);

        System.out.println();
    }

    // Main method (Take user input)
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter max cars allowed in roundabout: ");
        int maxCars = sc.nextInt();

        System.out.print("Enter waiting queue limit: ");
        int queueLimit = sc.nextInt();

        TrafficManager tm = new TrafficManager(maxCars, queueLimit);

        while (true) {
            System.out.println("\n1. Add Car");
            System.out.println("2. Remove Car");
            System.out.println("3. Print Roundabout");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter car number to add: ");
                    tm.addCar(sc.nextInt());
                    break;

                case 2:
                    System.out.print("Enter car number to remove: ");
                    tm.removeCar(sc.nextInt());
                    break;

                case 3:
                    tm.printRoundabout();
                    break;

                case 4:
                    System.out.println("Exiting system.");
                    return;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
