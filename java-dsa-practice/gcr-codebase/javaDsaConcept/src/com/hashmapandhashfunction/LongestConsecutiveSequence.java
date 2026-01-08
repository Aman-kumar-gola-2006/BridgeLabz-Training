package com.hashmapandhashfunction;

import java.util.HashMap;

public class LongestConsecutiveSequence {

    public static void main(String[] args) {

        int[] arr = {100, 4, 200, 1, 3, 2};

        HashMap<Integer, Boolean> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], true);
        }

        int longest = 0;

        for (int num : arr) {

            if (!map.containsKey(num - 1)) {

                int count = 1;
                int next = num + 1;

                while (map.containsKey(next)) {
                    count++;
                    next++;
                }

                if (count > longest) {
                    longest = count;
                }
            }
        }

        System.out.println("Longest Consecutive Length: " + longest);
    }
}
