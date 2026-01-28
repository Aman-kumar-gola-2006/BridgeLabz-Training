package com.queueinterface.circularbuffer;

public class CircularBuffer {

    int[] buffer;
    int size;
    int front = 0;
    int count = 0;

    public CircularBuffer(int size) {
        this.size = size;
        buffer = new int[size];
    }

    // Insert element
    public void insert(int value) {
        buffer[(front + count) % size] = value;

        if (count < size) {
            count++;
        } else {
            front = (front + 1) % size; // overwrite oldest
        }
    }

    // Display buffer
    public void display() {
        for (int i = 0; i < count; i++) {
            System.out.print(buffer[(front + i) % size] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        CircularBuffer cb = new CircularBuffer(3);

        cb.insert(1);
        cb.insert(2);
        cb.insert(3);
        cb.insert(4);

        cb.display(); // 2 3 4
    }
}