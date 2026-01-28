package com.listinterface.reverselist;

import java.util.LinkedList;
import java.util.List;

public class LinkedListReverse {
	
	public static void reverseLinkedList(List<Integer> list) {
		int start =0;
		int end = list.size()-1;
		
		while(start<end) {
			
			int temp=list.get(start);
			list.set(start, list.get(end));
			list.set(end, temp);
			
			start++;
			end--;
		}
	}
	public static void main(String[] args) {
		List<Integer> list = new LinkedList<Integer>();
		
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		
		System.out.println(list);
		reverseLinkedList(list);
		System.out.println(list);
	}
}
