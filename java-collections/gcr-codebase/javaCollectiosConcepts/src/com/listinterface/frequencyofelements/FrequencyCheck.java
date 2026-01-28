package com.listinterface.frequencyofelements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrequencyCheck {
	public static void checkFrequncy(List<String> list) {
		Map<String, Integer> map= new HashMap<String, Integer>();
		
		for (String string : list) {
			map.put(string, map.getOrDefault(string, 0)+1);
		}
		
		System.out.println(map);
	}
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("Apple");
		list.add("Banana");
		list.add("Apple");
		list.add("Orange");
		checkFrequncy(list);
	
	}
}
