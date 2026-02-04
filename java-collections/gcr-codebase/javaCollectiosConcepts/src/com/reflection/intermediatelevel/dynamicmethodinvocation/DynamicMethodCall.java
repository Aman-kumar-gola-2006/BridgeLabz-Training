package com.reflection.intermediatelevel.dynamicmethodinvocation;

import java.lang.reflect.Method;
import java.util.Scanner;
public class DynamicMethodCall {
	public static void main(String[] args) throws Exception {

        MathOperations obj = new MathOperations();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter method name: ");
        String methodName = sc.next();

        Class<?> cls = obj.getClass();

        Method method = cls.getMethod(methodName, int.class, int.class);
        int result = (int) method.invoke(obj, 10, 5);

        System.out.println("Result: " + result);
    }
}