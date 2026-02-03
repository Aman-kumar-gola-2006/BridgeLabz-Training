package com.junit.utilitymethods;

import org.junit.Assert;
import org.junit.Test;

public class StringUtilsTest {
	StringUtils s = new StringUtils();
	@Test
	public void testReverse() {
		Assert.assertEquals("yahba", s.reverse("abhay"));
	}
	
	@Test
	public void testPalindrom() {
		Assert.assertEquals(true, s.isPalindrome("Aba"));
	}
	
	@Test
	public void testUppercase() {
		Assert.assertEquals("ABHAY", s.toUpperCase("Abhay"));
	}
	
	
}
