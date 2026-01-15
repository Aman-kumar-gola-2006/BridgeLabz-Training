import java.util.*;

// Interface
interface IPayable {
    void pay();
    void sendReminder();
}

// Base Bill class with Encapsulation
abstract class Bill implements IPayable {
    protected String type;
    protected double amount;
    protected String dueDate;

    private boolean isPaid = false;        // Encapsulated
    private String paymentLog = "";        // Internal use only

    public Bill(String type, double amount, String dueDate) {
        this.type = type;
        this.amount = amount;
        this.dueDate = dueDate;
    }

    // Encapsulated method to update payment status
    protected void updatePaymentStatus() {
        isPaid = true;
        paymentLog += "Paid on system.\n";
    }

    public boolean getStatus() {
        return isPaid;
    }

    protected void addLog(String msg) {
        paymentLog += msg + "\n";
    }

    public void showLog() {
        System.out.println(paymentLog);
    }

    // Operator usage: calculate late fee
    public double calculateLateFee(double penalty) {
        return amount + penalty;
    }
}

// Electricity Bill
class ElectricityBill extends Bill {
    public ElectricityBill(double amt, String date) {
        super("Electricity", amt, date);
    }

    public void pay() {
        updatePaymentStatus();
        addLog("Electricity bill paid.");
        System.out.println("Electricity Bill Paid Successfully!");
    }

    public void sendReminder() {
        System.out.println("Reminder: Pay your Electricity bill before " + dueDate);
    }
}

// Water Bill
class WaterBill extends Bill {
    public WaterBill(double amt, String date) {
        super("Water", amt, date);
    }

    public void pay() {
        updatePaymentStatus();
        addLog("Water bill paid.");
        System.out.println("Water Bill Paid Successfully!");
    }

    public void sendReminder() {
        System.out.println("Reminder: Water bill due on " + dueDate + ". Avoid disruption.");
    }
}

// Internet Bill
class InternetBill extends Bill {
    public InternetBill(double amt, String date) {
        super("Internet", amt, date);
    }

    public void pay() {
        updatePaymentStatus();
        addLog("Internet bill paid.");
        System.out.println("Internet Bill Paid Successfully!");
    }

    public void sendReminder() {
        System.out.println("Reminder: Internet bill due on " + dueDate + ". Avoid service suspension.");
    }
}

// Main System
public class PayXpress {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Bill> bills = new ArrayList<>();

        // Sample recurring bills created via constructors
        bills.add(new ElectricityBill(1200, "10-Feb"));
        bills.add(new WaterBill(500, "12-Feb"));
        bills.add(new InternetBill(799, "15-Feb"));

        while (true) {
            System.out.println("\n--- PayXpress Menu ---");
            System.out.println("1. View Bills");
            System.out.println("2. Pay Bill");
            System.out.println("3. Send Reminder");
            System.out.println("4. View Payment Logs");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");
            int ch = sc.nextInt();

            if (ch == 5) break;

            switch (ch) {

                case 1:
                    System.out.println("Available Bills:");
                    for (int i = 0; i < bills.size(); i++) {
                        Bill b = bills.get(i);
                        System.out.println((i + 1) + ". " + b.type + " | Amount: " + b.amount + " | Due: " + b.dueDate + " | Paid: " + b.getStatus());
                    }
                    break;

                case 2:
                    System.out.print("Enter bill index to pay: ");
                    int idx = sc.nextInt() - 1;

                    System.out.print("Enter penalty if late (0 if no penalty): ");
                    double pen = sc.nextDouble();

                    double finalAmt = bills.get(idx).calculateLateFee(pen);
                    System.out.println("Final Amount: " + finalAmt);

                    bills.get(idx).pay();
                    break;

                case 3:
                    System.out.print("Enter bill index for reminder: ");
                    int remIdx = sc.nextInt() - 1;
                    bills.get(remIdx).sendReminder();
                    break;

                case 4:
                    System.out.print("Enter bill index to view logs: ");
                    int logIdx = sc.nextInt() - 1;
                    bills.get(logIdx).showLog();
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
