package com.queueinterface.hospitaltriagesystem;

import java.util.PriorityQueue;

public class HospitalTriage {

    public static void main(String[] args) {

        // PriorityQueue with custom comparison (higher severity first)
        PriorityQueue<Patient> queue =
            new PriorityQueue<>((p1, p2) -> p2.severity - p1.severity);

        // Add patients
        queue.add(new Patient("John", 3));
        queue.add(new Patient("Alice", 5));
        queue.add(new Patient("Bob", 2));

        // Treat patients
        while (!queue.isEmpty()) {
            Patient p = queue.poll();
            System.out.println("Treating: " + p.name);
        }
    }
}
