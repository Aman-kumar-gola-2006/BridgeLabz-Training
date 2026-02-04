package com.reflection.basiclevel.accessprivatefield;
import java.lang.reflect.Field;

public class PrivateFieldDemo {
	 public static void main(String[] args) throws Exception {

	        Person person = new Person();

	        // Get Class object
	        Class<?> cls = person.getClass();

	        // Access private field
	        Field ageField = cls.getDeclaredField("age");
	        ageField.setAccessible(true); // bypass private access

	        // Set value
	        ageField.set(person, 25);

	        // Get value
	        int age = (int) ageField.get(person);
	        System.out.println("Age: " + age);
	    }
}