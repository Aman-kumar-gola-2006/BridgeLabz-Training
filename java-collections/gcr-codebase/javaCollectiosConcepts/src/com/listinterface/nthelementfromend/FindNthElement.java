package com.listinterface.nthelementfromend;

import java.util.LinkedList;
import java.util.List;

public class FindNthElement {
	 public static Integer findNthFromEnd(List<Integer> list, int n) {

	        if (list == null || n <= 0) {
	            throw new IllegalArgumentException("Invalid input");
	        }

	        int fast = 0;
	        int slow = 0;

	        // Move fast pointer n steps ahead
	        for (int i = 0; i < n; i++) {
	            if (fast >= list.size()) {
	                throw new IllegalArgumentException("N is greater than list size");
	            }
	            fast++;
	        }

	        // Move both pointers until fast reaches end
	        while (fast < list.size()) {
	            fast++;
	            slow++;
	        }

	        return list.get(slow);
	    }

	    public static void main(String[] args) {

	        List<Integer> list = new LinkedList<>();
	        list.add(10);
	        list.add(10);
	        list.add(20);
	        list.add(30);
	        list.add(30);
	        list.add(40);

	        int n = 5;
	        System.out.println("Nth element from end: " + findNthFromEnd(list, n));
	    }
}

