package com.algorithmsruntimeanalysis;

public class StringConcatenation {
	public static void main(String[] args) {

        int N = 10000; // SAFE value

        long start, end;

        // -------- Using String --------
        start = System.nanoTime();
        String s = "";
        for (int i = 0; i < N; i++) {
            s = s + "a";
        }
        end = System.nanoTime();
        System.out.println("String Time (ms): " + (end - start) / 1_000_000);

        // -------- Using StringBuilder --------
        start = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append("a");
        }
        end = System.nanoTime();
        System.out.println("StringBuilder Time (ms): " + (end - start) / 1_000_000);

        // -------- Using StringBuffer --------
        start = System.nanoTime();
        StringBuffer sbuf = new StringBuffer();
        for (int i = 0; i < N; i++) {
            sbuf.append("a");
        }
        end = System.nanoTime();
        System.out.println("StringBuffer Time (ms): " + (end - start) / 1_000_000);
    }
}
