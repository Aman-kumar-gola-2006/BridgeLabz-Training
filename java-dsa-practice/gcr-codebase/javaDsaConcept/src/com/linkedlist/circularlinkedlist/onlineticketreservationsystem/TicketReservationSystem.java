package com.linkedlist.circularlinkedlist.onlineticketreservationsystem;

public class TicketReservationSystem {
	private TicketNode last;   // last node (tail)

    /* ---------------- ADD TICKET ---------------- */

    public void addTicket(int id, String customer, String movie,
                          String seat, String time) {

        TicketNode newTicket = new TicketNode(id, customer, movie, seat, time);

        if (last == null) {
            last = newTicket;
            last.next = last; // circular link
        } else {
            newTicket.next = last.next;
            last.next = newTicket;
            last = newTicket;
        }

        System.out.println("Ticket booked successfully");
    }

    /* ---------------- REMOVE TICKET ---------------- */

    public void removeTicket(int id) {
        if (last == null) {
            System.out.println("No tickets to remove");
            return;
        }

        TicketNode curr = last.next;
        TicketNode prev = last;

        do {
            if (curr.ticketId == id) {

                // only one node
                if (curr == last && curr.next == last) {
                    last = null;
                } else {
                    prev.next = curr.next;
                    if (curr == last) {
                        last = prev;
                    }
                }

                System.out.println("Ticket removed successfully");
                return;
            }

            prev = curr;
            curr = curr.next;

        } while (curr != last.next);

        System.out.println("Ticket not found");
    }

    /* ---------------- DISPLAY TICKETS ---------------- */

    public void displayTickets() {
        if (last == null) {
            System.out.println("No tickets booked");
            return;
        }

        TicketNode temp = last.next;
        System.out.println("\n--- BOOKED TICKETS ---");

        do {
            displayTicket(temp);
            temp = temp.next;
        } while (temp != last.next);
    }

    /* ---------------- SEARCH TICKET ---------------- */

    public void searchByCustomer(String customerName) {
        if (last == null) {
            System.out.println("No tickets available");
            return;
        }

        TicketNode temp = last.next;
        boolean found = false;

        do {
            if (temp.customerName.equalsIgnoreCase(customerName)) {
                displayTicket(temp);
                found = true;
            }
            temp = temp.next;
        } while (temp != last.next);

        if (!found)
            System.out.println("No ticket found for this customer");
    }

    public void searchByMovie(String movieName) {
        if (last == null) {
            System.out.println("No tickets available");
            return;
        }

        TicketNode temp = last.next;
        boolean found = false;

        do {
            if (temp.movieName.equalsIgnoreCase(movieName)) {
                displayTicket(temp);
                found = true;
            }
            temp = temp.next;
        } while (temp != last.next);

        if (!found)
            System.out.println("No tickets found for this movie");
    }

    /* ---------------- COUNT TICKETS ---------------- */

    public int countTickets() {
        if (last == null) return 0;

        int count = 0;
        TicketNode temp = last.next;

        do {
            count++;
            temp = temp.next;
        } while (temp != last.next);

        return count;
    }

    /* ---------------- HELPER ---------------- */

    private void displayTicket(TicketNode t) {
        System.out.println(
                "Ticket ID: " + t.ticketId +
                ", Customer: " + t.customerName +
                ", Movie: " + t.movieName +
                ", Seat: " + t.seatNumber +
                ", Time: " + t.bookingTime
        );
    }
}
