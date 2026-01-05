package com.linkedlist.circularlinkedlist.taskschedular;

public class TaskNode {

    int id;
    String name;
    int dueDate;
    String priority;

    TaskNode next; // circular link

    public TaskNode(int id, String name, int dueDate, String priority) {
        this.id = id;
        this.name = name;
        this.dueDate = dueDate;
        this.priority = priority;
        this.next = null;
    }
}
