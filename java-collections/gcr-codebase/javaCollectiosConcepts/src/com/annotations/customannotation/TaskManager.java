package com.annotations.customannotation;
public class TaskManager {

    @TaskInfo(priority = "HIGH", assignedTo = "Abhay")
    public void completeTask() {
        System.out.println("Task completed");
    }
}