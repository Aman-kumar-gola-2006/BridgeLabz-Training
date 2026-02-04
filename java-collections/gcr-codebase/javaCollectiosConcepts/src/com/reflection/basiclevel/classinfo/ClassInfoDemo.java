package com.reflection.basiclevel.classinfo;

import java.lang.reflect.*;

public class ClassInfoDemo {

    public static void main(String[] args) throws Exception {

        // Fully qualified class name
        String className = "java.util.ArrayList";

        // Load class dynamically
        Class<?> cls = Class.forName(className);

        System.out.println("Class Name: " + cls.getName());

        // Display methods
        System.out.println("\n--- Methods ---");
        for (Method method : cls.getDeclaredMethods()) {
            System.out.println(method.getName());
        }

        // Display fields
        System.out.println("\n--- Fields ---");
        for (Field field : cls.getDeclaredFields()) {
            System.out.println(field.getName());
        }

        // Display constructors
        System.out.println("\n--- Constructors ---");
        for (Constructor<?> constructor : cls.getDeclaredConstructors()) {
            System.out.println(constructor);
        }
    }
}