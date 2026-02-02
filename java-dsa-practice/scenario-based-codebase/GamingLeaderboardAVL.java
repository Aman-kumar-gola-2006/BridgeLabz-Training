import java.util.Scanner;

public class GamingLeaderboardAVL {

    // AVL Tree Node
    static class Node {
        int playerId;
        int points;
        int height;
        Node left, right;

        Node(int playerId, int points) {
            this.playerId = playerId;
            this.points = points;
            height = 1;
        }
    }

    static Node root = null;
    static int count = 0;

    // Get height
    static int height(Node n) {
        if (n == null)
            return 0;
        return n.height;
    }

    // Get balance factor
    static int getBalance(Node n) {
        if (n == null)
            return 0;
        return height(n.left) - height(n.right);
    }

    // Right rotation
    static Node rightRotate(Node y) {
        Node x = y.left;
        Node t2 = x.right;

        x.right = y;
        y.left = t2;

        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    // Left rotation
    static Node leftRotate(Node x) {
        Node y = x.right;
        Node t2 = y.left;

        y.left = x;
        x.right = t2;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    // Insert or update player
    static Node insert(Node node, int playerId, int points) {

        if (node == null)
            return new Node(playerId, points);

        if (points < node.points)
            node.left = insert(node.left, playerId, points);
        else if (points > node.points)
            node.right = insert(node.right, playerId, points);
        else
            node.points = points; // update points

        node.height = 1 + Math.max(height(node.left), height(node.right));

        int balance = getBalance(node);

        // AVL balancing
        if (balance > 1 && points < node.left.points)
            return rightRotate(node);

        if (balance < -1 && points > node.right.points)
            return leftRotate(node);

        if (balance > 1 && points > node.left.points) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        if (balance < -1 && points < node.right.points) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    // Find minimum node
    static Node minValueNode(Node node) {
        Node current = node;
        while (current.left != null)
            current = current.left;
        return current;
    }

    // Remove player
    static Node delete(Node root, int points) {

        if (root == null)
            return root;

        if (points < root.points)
            root.left = delete(root.left, points);
        else if (points > root.points)
            root.right = delete(root.right, points);
        else {
            if ((root.left == null) || (root.right == null)) {
                Node temp = (root.left != null) ? root.left : root.right;

                if (temp == null) {
                    root = null;
                } else {
                    root = temp;
                }
            } else {
                Node temp = minValueNode(root.right);
                root.points = temp.points;
                root.playerId = temp.playerId;
                root.right = delete(root.right, temp.points);
            }
        }

        if (root == null)
            return root;

        root.height = Math.max(height(root.left), height(root.right)) + 1;

        int balance = getBalance(root);

        if (balance > 1 && getBalance(root.left) >= 0)
            return rightRotate(root);

        if (balance > 1 && getBalance(root.left) < 0) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        if (balance < -1 && getBalance(root.right) <= 0)
            return leftRotate(root);

        if (balance < -1 && getBalance(root.right) > 0) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

    // Display top players (reverse inorder)
    static void showTopPlayers(Node root) {
        if (root != null && count < 10) {
            showTopPlayers(root.right);
            if (count < 10) {
                System.out.println("Player ID: " + root.playerId + 
                                   " | Points: " + root.points);
                count++;
            }
            showTopPlayers(root.left);
        }
    }

    // Main
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Gaming Leaderboard ---");
            System.out.println("1. Insert / Update Player");
            System.out.println("2. Display Top 10 Players");
            System.out.println("3. Remove Player");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Player ID: ");
                    int id = sc.nextInt();
                    System.out.print("Enter Points: ");
                    int points = sc.nextInt();
                    root = insert(root, id, points);
                    System.out.println("Player added/updated.");
                    break;

                case 2:
                    System.out.println("Top Players:");
                    count = 0;
                    showTopPlayers(root);
                    break;

                case 3:
                    System.out.print("Enter points of player to remove: ");
                    int delPoints = sc.nextInt();
                    root = delete(root, delPoints);
                    System.out.println("Player removed (if existed).");
                    break;

                case 4:
                    System.out.println("Exiting leaderboard...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
