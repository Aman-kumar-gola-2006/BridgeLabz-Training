package com.setinterface.unionandintersection;

import java.util.HashSet;
import java.util.Set;

public class CheckUnionAndIntersection {
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
		 * UNION: - Create a new set to avoid modifying original sets - addAll() adds
		 * all elements from both sets
		 */
		Set<Integer> union = new HashSet<>(set1);
		union.addAll(set2);

		/*
		 * INTERSECTION: - retainAll() keeps only common elements
		 */
		Set<Integer> intersection = new HashSet<>(set1);
		intersection.retainAll(set2);

		// Display results
		System.out.println("Set1: " + set1);
		System.out.println("Set2: " + set2);
		System.out.println("Union: " + union);
		System.out.println("Intersection: " + intersection);
	}
}
