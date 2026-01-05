package com.linkedlist.circularlinkedlist.taskschedular;

public class TaskScheduler {

    private TaskNode head;
    private TaskNode current; 

    // Add at beginning
    public void addAtBeginning(int id, String name, int dueDate, String priority) {
        TaskNode newNode = new TaskNode(id, name, dueDate, priority);

        if (head == null) {
            head = newNode;
            newNode.next = head;
            current = head;
        } else {
            TaskNode temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            newNode.next = head;
            temp.next = newNode;
            head = newNode;
        }
        System.out.println("Task added at beginning.");
    }

    // Add at end
    public void addAtEnd(int id, String name, int dueDate, String priority) {
        TaskNode newNode = new TaskNode(id, name, dueDate, priority);

        if (head == null) {
            head = newNode;
            newNode.next = head;
            current = head;
            return;
        }

        TaskNode temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.next = head;

        System.out.println("Task added at end.");
    }

    // Add at position
    public void addAtPosition(int pos, int id, String name, int dueDate, String priority) {
        if (pos <= 0 || head == null) {
            addAtBeginning(id, name, dueDate, priority);
            return;
        }

        TaskNode temp = head;
        for (int i = 1; i < pos && temp.next != head; i++) {
            temp = temp.next;
        }

        TaskNode newNode = new TaskNode(id, name, dueDate, priority);
        newNode.next = temp.next;
        temp.next = newNode;

        System.out.println("Task added at position " + pos);
    }

    // Remove task by ID
    public void removeById(int id) {
        if (head == null) {
            System.out.println("Task list is empty.");
            return;
        }

        // Single node case
        if (head.id == id && head.next == head) {
            head = current = null;
            System.out.println("Task removed.");
            return;
        }

        TaskNode temp = head;
        TaskNode prev = null;

        do {
            if (temp.id == id) {
                if (temp == head) {
                    TaskNode last = head;
                    while (last.next != head)
                        last = last.next;

                    head = head.next;
                    last.next = head;
                } else {
                    prev.next = temp.next;
                }
                System.out.println("Task removed.");
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);

        System.out.println("Task not found.");
    }

    // View current task & move to next
    public void viewNextTask() {
        if (current == null) {
            System.out.println("No tasks available.");
            return;
        }

        displayTask(current);
        current = current.next;
    }

    // Display all tasks
    public void displayAll() {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }

        TaskNode temp = head;
        do {
            displayTask(temp);
            temp = temp.next;
        } while (temp != head);
    }

    // Search by priority
    public void searchByPriority(String priority) {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }

        TaskNode temp = head;
        boolean found = false;

        do {
            if (temp.priority.equalsIgnoreCase(priority)) {
                displayTask(temp);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found)
            System.out.println("No tasks found with priority " + priority);
    }

    private void displayTask(TaskNode t) {
        System.out.println("ID: " + t.id +
                ", Name: " + t.name +
                ", Due Date: " + t.dueDate +
                ", Priority: " + t.priority);
    }
}
