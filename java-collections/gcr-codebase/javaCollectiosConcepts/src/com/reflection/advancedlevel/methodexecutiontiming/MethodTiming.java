package com.reflection.advancedlevel.methodexecutiontiming;

import java.lang.reflect.Method;

public class MethodTiming {


    public static void main(String[] args) throws Exception {

        Task task = new Task();
        Method method = Task.class.getMethod("execute");

        long start = System.nanoTime();
        method.invoke(task);
        long end = System.nanoTime();

        System.out.println("Execution Time (ns): " + (end - start));
    }
}