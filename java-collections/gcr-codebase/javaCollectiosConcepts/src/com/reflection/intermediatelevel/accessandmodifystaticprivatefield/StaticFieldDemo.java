package com.reflection.intermediatelevel.accessandmodifystaticprivatefield;

import java.lang.reflect.Field;

public class StaticFieldDemo {

	public static void main(String[] args) throws Exception {

		Class<?> cls = Configuration.class;

		Field field = cls.getDeclaredField("API_KEY");
		field.setAccessible(true);

		// Modify static field (null object)
		field.set(null, "NEW_SECRET_KEY");

		System.out.println("Updated API Key: " + field.get(null));
	}
}