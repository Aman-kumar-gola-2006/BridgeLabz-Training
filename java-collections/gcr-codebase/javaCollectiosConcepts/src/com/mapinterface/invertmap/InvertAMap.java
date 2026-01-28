package com.mapinterface.invertmap;

import java.util.*;

public class InvertAMap {

    public static void main(String[] args) {

        // Original map
        Map<String, Integer> originalMap = new HashMap<>();
        originalMap.put("A", 1);
        originalMap.put("B", 2);
        originalMap.put("C", 1);

        // Inverted map: value -> list of keys
        Map<Integer, List<String>> invertedMap = new HashMap<>();

        /*
         * Traverse original map
         */
        for (Map.Entry<String, Integer> entry : originalMap.entrySet()) {

            String key = entry.getKey();
            Integer value = entry.getValue();

            // If value not present, create a new list
            if (!invertedMap.containsKey(value)) {
                invertedMap.put(value, new ArrayList<>());
            }

            // Add key to the list
            invertedMap.get(value).add(key);
        }

        // Display result
        System.out.println(invertedMap);
    }

}
