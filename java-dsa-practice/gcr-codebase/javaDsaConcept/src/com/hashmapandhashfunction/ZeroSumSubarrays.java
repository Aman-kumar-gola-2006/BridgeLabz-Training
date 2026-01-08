package com.hashmapandhashfunction;

import java.util.*;

public class ZeroSumSubarrays {

    public static void main(String[] args) {

        int[] arr = {3, 4, -7, 1, 3, -4, -2, -2};

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        int sum = 0;

        ArrayList<Integer> list = new ArrayList<>();
        list.add(-1);
        map.put(0, list);

        for (int i = 0; i < arr.length; i++) {

            sum = sum + arr[i];

            if (map.containsKey(sum)) {

                ArrayList<Integer> indexes = map.get(sum);

                for (int start : indexes) {
                    System.out.println("Subarray from " + (start + 1) + " to " + i);
                }

                indexes.add(i);
            } else {

                ArrayList<Integer> newList = new ArrayList<>();
                newList.add(i);
                map.put(sum, newList);
            }
        }
    }
}
