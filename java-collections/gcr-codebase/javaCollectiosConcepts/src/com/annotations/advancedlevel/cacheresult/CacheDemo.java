package com.annotations.advancedlevel.cacheresult;

import java.util.HashMap;
import java.util.Map;

public class CacheDemo {

    static Map<Integer, Integer> cache = new HashMap<>();

    @CacheResult
    public int expensiveCalculation(int n) {
        if (cache.containsKey(n)) {
            System.out.println("Returning cached result");
            return cache.get(n);
        }
        System.out.println("Computing result");
        int result = n * n;
        cache.put(n, result);
        return result;
    }

    public static void main(String[] args) {
        CacheDemo demo = new CacheDemo();
        System.out.println(demo.expensiveCalculation(5));
        System.out.println(demo.expensiveCalculation(5));
    }
}