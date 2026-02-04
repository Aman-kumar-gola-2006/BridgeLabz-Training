package com.reflection.advancedlevel.dependencyinjection;

import java.lang.annotation.*;
import java.lang.reflect.*;
public class SimpleDI {

	public static void injectDependencies(Object obj) throws Exception {

        for (Field field : obj.getClass().getDeclaredFields()) {

            if (field.isAnnotationPresent(Inject.class)) {
                Object dependency = field.getType()
                        .getDeclaredConstructor().newInstance();

                field.setAccessible(true);
                field.set(obj, dependency);
            }
        }
    }

    public static void main(String[] args) throws Exception {

        Car car = new Car();
        injectDependencies(car);
        car.drive();
    }
}