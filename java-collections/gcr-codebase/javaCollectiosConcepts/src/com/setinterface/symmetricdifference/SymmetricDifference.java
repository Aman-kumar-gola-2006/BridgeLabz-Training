package com.setinterface.symmetricdifference;

import java.util.HashSet;
import java.util.Set;

public class SymmetricDifference {

    public static void main(String[] args) {

        // Create first set
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        // Create second set
        Set<Integer> set2 = new HashSet<>();
        set2.add(3);
        set2.add(4);
        set2.add(5);

        /*
         * Step 1: Find UNION of both sets
         */
        Set<Integer> symmetricDiff = new HashSet<>(set1);
        symmetricDiff.addAll(set2);

        /*
         * Step 2: Find INTERSECTION of both sets
         */
        Set<Integer> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);

        /*
         * Step 3: Remove intersection from union
         * Result = Symmetric Difference
         */
        symmetricDiff.removeAll(intersection);

        // Display result
        System.out.println("Symmetric Difference: " + symmetricDiff);
    }
}
