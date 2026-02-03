package com.junit.listoperations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;


import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ListManagerTest {
	private	ListManager lm;
	private	List< Integer> list;
	
	@Before
	public void setUp() {
		lm = new ListManager();
		list = new ArrayList<Integer>();
	}
	@Test
	public void testAddElement() {
		lm.addElement(list, 3847379);
		
		assertEquals(1, list.size());
		assertEquals(Integer.valueOf(3847379), list.get(0));
	}
	
	@Test
	public void testRemoveElement() {
		list.add(10);
		list.add(20);
		
		lm.removeElement(list, 10);
		
		assertEquals(1, list.size());
		assertFalse(list.contains(10));
		
	}
	
	@Test
	public void testGetSize() {
		lm.addElement(list, 5);
		lm.addElement(list, 15);
		
		int size = lm.getSize(list);
		
		assertEquals(2, size);
	}
	
	
}
