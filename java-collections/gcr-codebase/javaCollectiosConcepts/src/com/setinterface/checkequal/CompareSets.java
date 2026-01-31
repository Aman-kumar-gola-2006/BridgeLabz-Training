package com.setinterface.checkequal;

import java.util.HashSet;
import java.util.Set;

public class CompareSets {

    public static void main(String[] args) {

        // Create first set and add elements
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        // Create second set and add elements (order is different)
        Set<Integer> set2 = new HashSet<>();
        set2.add(3);
        set2.add(2);
        set2.add(1);

        /*
         * The equals() method of Set:
         * - Returns true if both sets contain the same elements
         * - Order of elements does NOT matter
         * - Internally checks size and element equality
         */
        boolean isEqual = set1.equals(set2);

        // Print the result
        System.out.println("Are both sets equal? " + isEqual);
    }
}
