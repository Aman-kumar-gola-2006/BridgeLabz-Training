package com.setinterface.subset;

import java.util.HashSet;
import java.util.Set;

public class SubsetCheck {

    public static void main(String[] args) {

        // Smaller set (possible subset)
        Set<Integer> set1 = new HashSet<>();
        set1.add(2);
        set1.add(5);

        // Larger set
        Set<Integer> set2 = new HashSet<>();
        set2.add(1);
        set2.add(2);
        set2.add(3);
        set2.add(4);

        /*
         * containsAll() checks whether set2 contains
         * every element of set1
         */
        boolean isSubset = set2.containsAll(set1);

        // Display result
        System.out.println("Is Set1 a subset of Set2? " + isSubset);
    }
}
