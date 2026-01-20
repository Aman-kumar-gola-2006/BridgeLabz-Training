package com.algorithmsruntimeanalysis;

import java.util.*;

public class ComparingDifferentDataStructures {
 
	 public static void main(String[] args) {

	        int N = 1_000_000;
	        int target = N - 1;

	        int[] array = new int[N];
	        HashSet<Integer> hashSet = new HashSet<>();
	        TreeSet<Integer> treeSet = new TreeSet<>();

	        // Fill data structures
	        for (int i = 0; i < N; i++) {
	            array[i] = i;
	            hashSet.add(i);
	            treeSet.add(i);
	        }

	        // -------- Array Search --------
	        long start = System.nanoTime();
	        for (int i = 0; i < array.length; i++) {
	            if (array[i] == target) break;
	        }
	        long end = System.nanoTime();
	        System.out.println("Array Search Time (ms): " + (end - start) / 1_000_000);

	        // -------- HashSet Search --------
	        start = System.nanoTime();
	        hashSet.contains(target);
	        end = System.nanoTime();
	        System.out.println("HashSet Search Time (ms): " + (end - start) / 1_000_000);

	        // -------- TreeSet Search --------
	        start = System.nanoTime();
	        treeSet.contains(target);
	        end = System.nanoTime();
	        System.out.println("TreeSet Search Time (ms): " + (end - start) / 1_000_000);
	    }
}
