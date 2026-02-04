package com.reflection.basiclevel.dynamicallycreatedobjects;

public class DynamicObjectCreation {
	  public static void main(String[] args) throws Exception {

	        // Load class dynamically
	        Class<?> cls = Class.forName("com.reflection.basiclevel.dynamicallycreatedobjects.Student");

	        // Create object
	        Object obj = cls.getDeclaredConstructor().newInstance();

	        System.out.println("Object Type: " + obj.getClass().getName());
	    }
}