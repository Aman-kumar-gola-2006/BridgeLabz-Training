// Interface
interface Transferrable {
    void transferTo(User receiver, double amount);
}

// ---------------- User ----------------
class User {
    String name;
    Transferrable wallet;

    User(String name, Transferrable wallet) {
        this.name = name;
        this.wallet = wallet;
    }

    void showBalance() {
        if (wallet instanceof Wallet) {
            Wallet w = (Wallet) wallet;
            System.out.println(name + "'s Balance: ₹" + w.getBalance());
        }
    }
}

// ---------------- Wallet ---------------------
class Wallet {
    private double balance;

    Wallet(double balance) {
        this.balance = balance;
    }
 
    public double getBalance() {
        return balance;
    }

    protected boolean deduct(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    protected void add(double amount) {
        balance += amount;
    }
}

// ---------------- Personal Wallet ----------------
class PersonalWallet extends Wallet implements Transferrable {

    PersonalWallet(double balance) {
        super(balance);
    }

    public void transferTo(User receiver, double amount) {
        if (deduct(amount)) {
            ((Wallet) receiver.wallet).add(amount);
            System.out.println("Transfer successful (Personal Wallet)");
        } else {
            System.out.println("Insufficient balance");
        }
    }
}

// ---------------- Business Wallet ----------------
class BusinessWallet extends Wallet implements Transferrable {

    BusinessWallet(double balance) {
        super(balance);
    }

    public void transferTo(User receiver, double amount) {
        double tax = amount * 0.05;
        double total = amount + tax;

        if (deduct(total)) {
            ((Wallet) receiver.wallet).add(amount);
            System.out.println("Transfer successful (Business Wallet)");
            System.out.println("Tax deducted: ₹" + tax);
        } else {
            System.out.println("Insufficient balance");
        }
    }
}

// ---------------- Main --------------------
public class EWalletApp {
    public static void main(String[] args) {

        User u1 = new User("Aman", new PersonalWallet(5000));
        User u2 = new User("Rohit", new BusinessWallet(8000));

        System.out.println("Before Transfer:"); 
        u1.showBalance();
        u2.showBalance();

        System.out.println("\nTransferring Money...");
        u1.wallet.transferTo(u2, 1000);

        System.out.println("\nAfter Transfer:");
        u1.showBalance();
        u2.showBalance();
    }
}
 