package com.stacksandqueues.queueusingstack;

import java.util.Stack;
import java.util.Scanner;

public class QueueUsingStack {

    // Stack used for enqueue operation
    Stack<Integer> s1 = new Stack<>();

    // Stack used for dequeue operation
    Stack<Integer> s2 = new Stack<>();

    // Method to insert elements into the queue
    public void enQueue() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter elements to enqueue (Enter 0 to stop):");

        while (true) {
            int num = sc.nextInt();

            // Stop condition
            if (num == 0) {
                break;
            }

            // Push element into stack s1
            s1.push(num);
            System.out.println(num + " enqueued successfully");
        }
    }

    // Method to remove an element from the queue
    public void deQueue() {

        // If both stacks are empty, queue is empty
        if (s1.isEmpty() && s2.isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return;
        }

        // If s2 is empty, move all elements from s1 to s2
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }

        // Pop the top element from s2 (FIFO behavior)
        int removedElement = s2.pop();
        System.out.println("Dequeued element: " + removedElement);
    }

    // Method to display queue elements
    public void displayQueue() {

        if (s1.isEmpty() && s2.isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }

        System.out.println("Queue elements:");

        // Print elements in s2 (front of queue)
        for (int i = s2.size() - 1; i >= 0; i--) {
            System.out.print(s2.get(i) + " ");
        }

        // Print elements in s1 (rear of queue)
        for (int i = 0; i < s1.size(); i++) {
            System.out.print(s1.get(i) + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {

        QueueUsingStack q1 = new QueueUsingStack();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Display Queue");
            System.out.println("4. Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> q1.enQueue();
                case 2 -> q1.deQueue();
                case 3 -> q1.displayQueue();
                case 4 -> {
                    System.out.println("Exiting program...");
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
