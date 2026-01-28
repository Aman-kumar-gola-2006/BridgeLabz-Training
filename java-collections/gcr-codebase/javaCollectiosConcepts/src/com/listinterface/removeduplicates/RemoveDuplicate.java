package com.listinterface.removeduplicates;

	import java.util.*;

	public class RemoveDuplicate {

		public static List<Integer> removeDuplicates(List<Integer> list) {
			List<Integer> result = new ArrayList<>();

			for (Integer element : list) {
				if (!result.contains(element)) {
					result.add(element);
				}
			}
			return result;
		}

		public static void main(String[] args) {
			List<Integer> list = new LinkedList<>();
			list.add(10);
			list.add(10);
			list.add(20);
			list.add(30);
			list.add(30);
			list.add(40);
			System.out.println(removeDuplicates(list));
		}
	}