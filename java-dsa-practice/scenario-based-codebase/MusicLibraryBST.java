import java.util.Scanner;

public class MusicLibraryBST {

    // Song Node
    static class Node {
        int trackId;
        String title;
        Node left, right;

        Node(int trackId, String title) {
            this.trackId = trackId;
            this.title = title;
            left = right = null;
        }
    }

    static Node root = null;

    // Insert song (based on title for alphabetical order)
    static Node insert(Node root, int trackId, String title) {
        if (root == null) {
            return new Node(trackId, title);
        }

        if (title.compareToIgnoreCase(root.title) < 0) {
            root.left = insert(root.left, trackId, title);
        } else {
            root.right = insert(root.right, trackId, title);
        }

        return root;
    }

    // Search song by Track ID
    static Node searchByTrackId(Node root, int trackId) {
        if (root == null) {
            return null;
        }

        if (root.trackId == trackId) {
            return root;
        }

        Node leftResult = searchByTrackId(root.left, trackId);
        if (leftResult != null) {
            return leftResult;
        }

        return searchByTrackId(root.right, trackId);
    }

    // Display playlist alphabetically (inorder traversal)
    static void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.println("Track ID: " + root.trackId +
                               " | Title: " + root.title);
            inorder(root.right);
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Music Library System ---");
            System.out.println("1. Insert New Track");
            System.out.println("2. Search Track by ID");
            System.out.println("3. Show Playlist Alphabetically");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Track ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Song Title: ");
                    String title = sc.nextLine();

                    root = insert(root, id, title);
                    System.out.println("Track added successfully.");
                    break;

                case 2:
                    System.out.print("Enter Track ID to search: ");
                    int searchId = sc.nextInt();

                    Node song = searchByTrackId(root, searchId);
                    if (song != null) {
                        System.out.println("Song Found:");
                        System.out.println("Track ID: " + song.trackId);
                        System.out.println("Title: " + song.title);
                    } else {
                        System.out.println("Song not found.");
                    }
                    break;

                case 3:
                    System.out.println("Playlist (Alphabetical Order):");
                    inorder(root);
                    break;

                case 4:
                    System.out.println("Exiting music app...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
