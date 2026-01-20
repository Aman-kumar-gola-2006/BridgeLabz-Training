import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

// Address class (composition)
class Address {
    private String city;
    private String state;
    private String zip;

    Address(String city, String state, String zip) {
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }
}

// Contact class
class Contact {

    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private Address address;

    // Constructor to initialize contact
    Contact(String firstName, String lastName, String phone, String email, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public Address getAddress() {
        return address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void display() {
        System.out.println(getFullName() + " | " + phone + " | " + email +
                " | " + address.getCity() + ", " + address.getState());
    }
}

public class DigiContactAddressBook {

    static ArrayList<Contact> contacts = new ArrayList<>();

    // Check duplicate contact by name
    static boolean isDuplicate(String name) {
        for (Contact c : contacts) {
            if (c.getFullName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1. Add Contact");
            System.out.println("2. Edit Contact");
            System.out.println("3. Delete Contact");
            System.out.println("4. Search by City/State");
            System.out.println("5. Display All Contacts");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("First Name: ");
                    String fn = sc.nextLine();
                    System.out.print("Last Name: ");
                    String ln = sc.nextLine();
                    String fullName = fn + " " + ln;

                    if (isDuplicate(fullName)) {
                        System.out.println("Contact already exists.");
                        break;
                    }

                    System.out.print("Phone: ");
                    String phone = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    System.out.print("City: ");
                    String city = sc.nextLine();
                    System.out.print("State: ");
                    String state = sc.nextLine();
                    System.out.print("Zip: ");
                    String zip = sc.nextLine();

                    Address addr = new Address(city, state, zip);
                    contacts.add(new Contact(fn, ln, phone, email, addr));
                    System.out.println("Contact added successfully.");
                    break;

                case 2:
                    System.out.print("Enter full name to edit: ");
                    String editName = sc.nextLine();

                    for (Contact c : contacts) {
                        if (c.getFullName().equalsIgnoreCase(editName)) {
                            System.out.print("New Phone: ");
                            c.setPhone(sc.nextLine());
                            System.out.print("New Email: ");
                            c.setEmail(sc.nextLine());
                            System.out.println("Contact updated.");
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter full name to delete: ");
                    String delName = sc.nextLine();

                    contacts.removeIf(c -> c.getFullName().equalsIgnoreCase(delName));
                    System.out.println("Contact deleted (if existed).");
                    break;

                case 4:
                    System.out.print("Enter City or State: ");
                    String key = sc.nextLine();

                    for (Contact c : contacts) {
                        if (c.getAddress().getCity().equalsIgnoreCase(key) ||
                            c.getAddress().getState().equalsIgnoreCase(key)) {
                            c.display();
                        }
                    }
                    break;

                case 5:
                    // Sort contacts alphabetically
                    Collections.sort(contacts, Comparator.comparing(Contact::getFullName));

                    System.out.println("\nAll Contacts:");
                    for (Contact c : contacts) {
                        c.display();
                    }
                    break;

                case 6:
                    System.out.println("Exiting Address Book.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 6);

        sc.close();
    }
}
