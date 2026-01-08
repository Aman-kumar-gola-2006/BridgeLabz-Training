package com.hashmapandhashfunction.implementcustomhashmap;

import java.util.*;
public class Main {
	

	    public static void main(String[] args) {

	        MyHashMap map = new MyHashMap();
	        map.put(1, 100);
	        map.put(6, 200);

	        System.out.println(map.get(1));
	        map.remove(1);
	        System.out.println(map.get(1));
	    }
	
}
