package com.hashmapandhashfunction;

import java.util.*;

public class TwoSum {

    public static void main(String[] args) {

        int[] nums = {1,1,3};
        int target = 4;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int rem = target - nums[i];

            if (map.containsKey(rem)) {
                System.out.println("Indices: " + map.get(rem) + ", " + i);
                //return;
            }
            map.put(nums[i], i);
        }
    }
}
