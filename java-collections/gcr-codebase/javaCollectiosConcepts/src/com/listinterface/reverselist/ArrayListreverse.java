package com.listinterface.reverselist;

import java.util.ArrayList;
import java.util.List;

public class ArrayListreverse {

	public static void reverseList(List<Integer> list) {
		int start=0;
		int end =list.size()-1;
		
		while(start<end) {
			int temp=list.get(start);
			list.set(start, list.get(end));
			list.set(end, temp);
			
			start++;
			end--;
		}
	}
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		
		list.add(10);
		list.add(50);
		list.add(20);
		list.add(10);
		list.add(30);
		list.add(40);
		list.add(20);
		
		System.out.println(list);
		reverseList(list);
		System.out.println(list);
	}

}
