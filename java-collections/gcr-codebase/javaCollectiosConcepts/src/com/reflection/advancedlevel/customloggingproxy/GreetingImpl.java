package com.reflection.advancedlevel.customloggingproxy;

/**
 * Actual implementation class
 */
public class GreetingImpl implements Greeting {

    @Override
    public void sayHello() {
        System.out.println("Hello from GreetingImpl!");
    }
}