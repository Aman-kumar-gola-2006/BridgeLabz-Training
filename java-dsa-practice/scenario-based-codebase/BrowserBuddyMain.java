import java.util.Scanner;
import java.util.Stack;

// Node class for Doubly Linked List
class Node {
    String url;
    Node prev;
    Node next;

    Node(String url) {
        this.url = url;
    }
}

// Main Browser Class
class BrowserBuddy {

    Node current;                  // Points to currently open page
    Stack<Node> closedTabs = new Stack<>();   // Stack for recently closed tabs

    // Visit a new page
    void visitPage(String url) {
        Node newNode = new Node(url);

        // If some page already open
        if (current != null) {
            current.next = newNode;  // link next pointer
            newNode.prev = current;  // link backward pointer
        }

        current = newNode;           // Move to the new page
        System.out.println("Visited: " + url);
    }

    // Go Backward in history
    void goBack() {
        if (current != null && current.prev != null) {
            current = current.prev;    // Move pointer to previous node
            System.out.println("Back to: " + current.url);
        } else {
            System.out.println("No Back History.");
        }
    }

    // Go Forward in history
    void goForward() {
        if (current != null && current.next != null) {
            current = current.next;    // Move pointer to next node
            System.out.println("Forward to: " + current.url);
        } else {
            System.out.println("No Forward History.");
        }
    }

    // Close the current tab
    void closeCurrentTab() {
        if (current != null) {
            closedTabs.push(current);     // Save closed tab
            System.out.println("Closed: " + current.url);

            current = current.prev;       // Move to previous page after closing
        } else {
            System.out.println("No Tab to Close.");
        }
    }

    // Restore last closed tab
    void restoreTab() {
        if (!closedTabs.isEmpty()) {
            current = closedTabs.pop();   // Reopen last closed tab
            System.out.println("Restored Tab: " + current.url);
        } else {
            System.out.println("No Recently Closed Tabs.");
        }
    }
}

// Program Driver
public class BrowserBuddyMain {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BrowserBuddy browser = new BrowserBuddy();

        while (true) {

            System.out.println("\n==== BrowserBuddy Menu ====");
            System.out.println("1. Visit New Page");
            System.out.println("2. Back");
            System.out.println("3. Forward");
            System.out.println("4. Close Current Tab");
            System.out.println("5. Restore Closed Tab");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();   // consume newline

            switch (choice) {

                case 1:
                    System.out.print("Enter URL: ");
                    String url = sc.nextLine();
                    browser.visitPage(url);
                    break;

                case 2:
                    browser.goBack();
                    break;

                case 3:
                    browser.goForward();
                    break;

                case 4:
                    browser.closeCurrentTab();
                    break;

                case 5:
                    browser.restoreTab();
                    break;

                case 6:
                    System.out.println("Exiting BrowserBuddy...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid Choice. Try Again.");
            }
        }
    }
}
