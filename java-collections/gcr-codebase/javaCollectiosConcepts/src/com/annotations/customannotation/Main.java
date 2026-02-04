package com.annotations.customannotation;

import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws Exception {

        Method method = TaskManager.class.getMethod("completeTask");
        TaskInfo info = method.getAnnotation(TaskInfo.class);

        System.out.println("Priority: " + info.priority());
        System.out.println("Assigned To: " + info.assignedTo());
    }
}