package com.stacksandqueues.circulartourproblem;

import java.util.*;

public class CircularTourProblem {

    static int findStart(PetrolPump[] pumps) {

        Queue<Integer> queue = new LinkedList<>();
        int fuel = 0;
        int start = 0;

        for (int i = 0; i < pumps.length; i++) {

            fuel += pumps[i].petrol - pumps[i].distance;
            queue.add(i);

            while (fuel < 0 && !queue.isEmpty()) {
                int removed = queue.poll();
                fuel -= pumps[removed].petrol - pumps[removed].distance;
                start = removed + 1;
            }
        }
        return (queue.size() == pumps.length) ? start : -1;
    }

    public static void main(String[] args) {

        PetrolPump[] pumps = {
            new PetrolPump(4, 6),
            new PetrolPump(6, 5),
            new PetrolPump(7, 3),
            new PetrolPump(4, 5)
        };

        int result = findStart(pumps);

        if (result == -1)
            System.out.println("No Possible Tour");
        else
            System.out.println("Start at petrol pump: " + result);
    }
}
