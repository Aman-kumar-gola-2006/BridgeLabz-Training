package com.mapinterface.mergetwomaps;

import java.util.HashMap;
import java.util.Map;

public class MergetwoMaps {

    public static void main(String[] args) {

        // First map
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("A", 1);
        map1.put("B", 2);

        // Second map
        Map<String, Integer> map2 = new HashMap<>();
        map2.put("B", 3);
        map2.put("C", 4);

        // Result map
        Map<String, Integer> result = new HashMap<>();

        // Step 1: Copy all entries from map1
        for (Map.Entry<String, Integer> entry : map1.entrySet()) {
            result.put(entry.getKey(), entry.getValue());
        }

        // Step 2: Merge map2 into result
        for (Map.Entry<String, Integer> entry : map2.entrySet()) {

            String key = entry.getKey();
            int value = entry.getValue();

            // If key exists, add values
            if (result.containsKey(key)) {
                result.put(key, result.get(key) + value);
            } else {
                // If key does not exist, add it
                result.put(key, value);
            }
        }

        // Display merged map
        System.out.println(result);
    }
}
