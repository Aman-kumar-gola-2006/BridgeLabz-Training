package com.mapinterface.frequencycounter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordFrequency {

	public static Map<String, Integer> frquency(List<String> list) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (String string : list) {
			map.put(string, map.getOrDefault(string, 0) + 1);
		}
		return map;

	}

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("apple");
		list.add("banana");
		list.add("apple");
		list.add("orange");
		list.add("orange");
		list.add("grapes");

		System.out.println(frquency(list));

	}
}
