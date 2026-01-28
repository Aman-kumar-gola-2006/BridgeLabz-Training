package com.listinterface.rotateelements;

import java.util.LinkedList;
import java.util.List;

public class RotateElementInList {
	
	public static void rotateElements(List<Integer> list, int position ) {
		int size=list.size();
		position=position%size;
		
		
		for(int i=0; i<position; i++) {
			int first = list.get(0);
			
			for(int j=0; j<size-1; j++) {
				list.set(j, list.get(j+1));
			}
			list.set(size-1, first);
		}
	}
	public static void main(String[] args) {
		List<Integer> list = new LinkedList<Integer>();
		int position=1;
		
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		
		System.out.println(list);
		rotateElements(list, position);
		System.out.println(list);
	}
}
