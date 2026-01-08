package com.hashmapandhashfunction;

import java.util.HashMap;

public class PairWithGivenSum {

    public static void main(String[] args) {

        int[] arr = {8, 7, 2, 5, 3, 1};
        int target = 10;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {

            int needed = target - arr[i];

            if (map.containsKey(needed)) {
                System.out.println("Pair Found: " + needed + " and " + arr[i]);
                //return;
            }

            map.put(arr[i], i);
        }

        System.out.println("No Pair Found");
    }
}
