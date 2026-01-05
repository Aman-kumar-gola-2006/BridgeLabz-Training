package com.linkedlist.circularlinkedlist.onlineticketreservationsystem;
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
    static TicketReservationSystem system = new TicketReservationSystem();

    public static void main(String[] args) {

        int choice;
        do {
            menu();
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> addTicket();
                case 2 -> removeTicket();
                case 3 -> system.displayTickets();
                case 4 -> searchTicket();
                case 5 -> System.out.println("Total Tickets: " + system.countTickets());
                case 0 -> System.out.println("Exiting Ticket System...");
                default -> System.out.println("Invalid choice");
            }

        } while (choice != 0);
    }

    static void menu() {
        System.out.println("\n--- ONLINE TICKET RESERVATION MENU ---");
        System.out.println("1. Book Ticket");
        System.out.println("2. Cancel Ticket");
        System.out.println("3. Display All Tickets");
        System.out.println("4. Search Ticket");
        System.out.println("5. Count Total Tickets");
        System.out.println("0. Exit");
        System.out.print("Enter choice: ");
    }

    static void addTicket() {
        System.out.print("Ticket ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Customer Name: ");
        String customer = sc.nextLine();

        System.out.print("Movie Name: ");
        String movie = sc.nextLine();

        System.out.print("Seat Number: ");
        String seat = sc.nextLine();

        System.out.print("Booking Time: ");
        String time = sc.nextLine();

        system.addTicket(id, customer, movie, seat, time);
    }

    static void removeTicket() {
        System.out.print("Enter Ticket ID: ");
        system.removeTicket(sc.nextInt());
    }

    static void searchTicket() {
        System.out.println("1. Search by Customer Name");
        System.out.println("2. Search by Movie Name");
        int ch = sc.nextInt();
        sc.nextLine();

        if (ch == 1) {
            System.out.print("Enter Customer Name: ");
            system.searchByCustomer(sc.nextLine());
        } else if (ch == 2) {
            System.out.print("Enter Movie Name: ");
            system.searchByMovie(sc.nextLine());
        } else {
            System.out.println("Invalid search option");
        }
    }
}
