package com.stringbuffer;

public class CompareSBandSBuffer {
	 public static void main(String[] args) {

	        int n = 1000000;

	        long start = System.nanoTime();
	        StringBuilder sb = new StringBuilder();
	        for (int i = 0; i < n; i++) sb.append("hello");
	        long end = System.nanoTime();
	        System.out.println("StringBuilder Time: " + (end - start));

	        start = System.nanoTime();
	        StringBuffer sbuf = new StringBuffer();
	        for (int i = 0; i < n; i++) sbuf.append("hello");
	        end = System.nanoTime();
	        System.out.println("StringBuffer Time: " + (end - start));
	    }
}
