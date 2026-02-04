package com.reflection.advancedlevel.customloggingproxy;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class LoggingProxy {

    public static void main(String[] args) {

        // Target object
        Greeting target = new GreetingImpl();

        // Creating proxy object
        Greeting proxy = (Greeting) Proxy.newProxyInstance(
                Greeting.class.getClassLoader(),   // Class loader
                new Class<?>[]{Greeting.class},    // Interface array
                (Object proxyObj, Method method, Object[] methodArgs) -> {

                    // Logging before method execution
                    System.out.println("Calling method: " + method.getName());

                    // Invoke actual method on target
                    return method.invoke(target, methodArgs);
                }
        );

        // Calling method via proxy
        proxy.sayHello();
    }
}