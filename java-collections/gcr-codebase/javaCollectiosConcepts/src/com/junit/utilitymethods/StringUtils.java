package com.junit.utilitymethods;

public class StringUtils {
	public String reverse(String s) {
		String reversed = "";
		for(int i=s.length()-1; i>=0; i--) {
			reversed+=s.charAt(i);
		}
		return reversed;
	}
	
	public boolean isPalindrome(String string) {
		if (string.equalsIgnoreCase(reverse(string))) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public String toUpperCase(String string) {
		return string.toUpperCase();
	}
}
