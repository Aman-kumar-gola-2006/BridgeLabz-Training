package com.annotations.beginnerlevel.todo;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Todo {
    String task();
    String assignedTo();
    String priority() default "MEDIUM";
}