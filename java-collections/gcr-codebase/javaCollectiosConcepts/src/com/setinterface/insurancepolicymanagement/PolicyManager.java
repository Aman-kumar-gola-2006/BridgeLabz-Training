package com.setinterface.insurancepolicymanagement;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ForkJoinPool;

public class PolicyManager {
	Set<Policy> hashSet = new HashSet<Policy>();
	Set<Policy> linkedHashSet = new LinkedHashSet<Policy>();

	Set<Policy> treeSet = new TreeSet<Policy>((p1, p2) -> p1.expiryDate.compareTo(p2.expiryDate));

	// Add policy to all sets
	void addPolicy(Policy p) {
		hashSet.add(p);
		linkedHashSet.add(p);
		treeSet.add(p);
	}

	// Display all policies
	void showAllPolicies() {
	for(Policy p:hashSet){
		System.out.println(p);
		}
	}

	// policies exirirng in 30 days
	void expiringSoon() {
		LocalDate today = LocalDate.now();
		LocalDate next30 = today.plusDays(30);

		for (Policy p : hashSet) {
			if (p.expiryDate.isAfter(today) && p.expiryDate.isBefore(next30)) {
				System.out.println(p);
			}

		}
	}

	void byCoverage(String type) {
		for (Policy p : hashSet) {
			if (p.coverageType.equalsIgnoreCase(type)) {
				System.out.println(p);
			}
		}
	}
}