package com.annotations.intermediatelevel.logexecution;

import java.lang.reflect.Method;

public class ExecutionTimeDemo {

    @LogExecutionTime
    public void heavyTask() throws InterruptedException {
        Thread.sleep(500);
    }

    public static void main(String[] args) throws Exception {
        ExecutionTimeDemo obj = new ExecutionTimeDemo();
        Method m = obj.getClass().getMethod("heavyTask");

        if (m.isAnnotationPresent(LogExecutionTime.class)) {
            long start = System.nanoTime();
            obj.heavyTask();
            long end = System.nanoTime();
            System.out.println("Execution Time: " + (end - start));
        }
    }
}