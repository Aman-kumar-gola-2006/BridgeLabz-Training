package com.reflection.basiclevel.invokeprivatefields;

import java.lang.reflect.Method;

public class PrivateMethodDemo {
	public static void main(String[] args) throws Exception {

		Calculator calculator = new Calculator();

		// Get class
		Class<?> cls = calculator.getClass();

		// Get private method
		Method method = cls.getDeclaredMethod("multiply", int.class, int.class);
		method.setAccessible(true);

		// Invoke method
		int result = (int) method.invoke(calculator, 5, 4);
		System.out.println("Result: " + result);
	}
}