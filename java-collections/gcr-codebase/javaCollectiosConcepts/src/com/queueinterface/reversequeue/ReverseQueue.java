package com.queueinterface.reversequeue;

import java.util.*;

public class ReverseQueue {

    // Method to reverse the queue
    public static void reverseQueue(Queue<Integer> queue) {

        // Base case: if queue is empty, stop recursion
        if (queue.isEmpty()) {
            return;
        }

        // Remove the front element
        int front = queue.remove();

        // Recursively reverse the remaining queue
        reverseQueue(queue);

        // Add the removed element to the rear
        queue.add(front);
    }

    public static void main(String[] args) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);

        System.out.println("Before Reverse: " + queue);

        reverseQueue(queue);

        System.out.println("After Reverse: " + queue);
    }
}
