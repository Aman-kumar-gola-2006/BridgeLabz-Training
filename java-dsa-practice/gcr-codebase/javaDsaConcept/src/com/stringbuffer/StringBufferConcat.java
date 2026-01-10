package com.stringbuffer;

public class StringBufferConcat {
	public static void main(String[] args) {
        String[] arr = {"Java", " ", "is", " ", "powerful"};
        StringBuffer sb = new StringBuffer();

        for (String s : arr) {
            sb.append(s);
        }
        System.out.println(sb.toString());
    }
}
