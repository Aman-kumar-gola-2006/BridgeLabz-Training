package com.queueinterface.stackusingqueue;

import java.util.*;
public class StackUsingQueue {


	    Queue<Integer> q1 = new LinkedList<>();
	    Queue<Integer> q2 = new LinkedList<>();

	    // Push element
	    public void push(int x) {
	        q2.add(x);

	        // Move all elements from q1 to q2
	        while (!q1.isEmpty()) {
	            q2.add(q1.remove());
	        }

	        // Swap q1 and q2
	        Queue<Integer> temp = q1;
	        q1 = q2;
	        q2 = temp;
	    }

	    // Pop element
	    public int pop() {
	        return q1.remove();
	    }

	    // Top element
	    public int top() {
	        return q1.peek();
	    }

	    public static void main(String[] args) {
	        StackUsingQueue stack = new StackUsingQueue();

	        stack.push(1);
	        stack.push(2);
	        stack.push(3);

	        System.out.println("Pop: " + stack.pop());//3
	        System.out.println("Pop: " + stack.pop());//2
	        System.out.println("Pop: " + stack.pop());// 1
	       
	    }
	}