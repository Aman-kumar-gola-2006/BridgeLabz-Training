package com.mapinterface.highestvaluekey;

import java.util.HashMap;
import java.util.Map;

public class HighestValueKey {
	public static void main(String[] args) {

		// Create map
		Map<String, Integer> map = new HashMap<>();
		map.put("A", 10);
		map.put("B", 20);
		map.put("C", 15);

		String maxKey = null;
		int maxValue = Integer.MIN_VALUE;

		/*
		 * Traverse the map
		 */
		for (Map.Entry<String, Integer> entry : map.entrySet()) {

			// If current value is greater than maxValue
			if (entry.getValue() > maxValue) {
				maxValue = entry.getValue();
				maxKey = entry.getKey();
			}
		}

		// Display result
		System.out.println("Key with highest value: " + maxKey);
	}
}
