package com.linkedlist.circularlinkedlist.roundrobinschedulingalgorithm;

public class ProcessNode {
	int pid;
    int burstTime;
    int remainingTime;
    int priority;

    int waitingTime;
    int turnaroundTime;

    ProcessNode next;

    public ProcessNode(int pid, int burstTime, int priority) {
        this.pid = pid;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
        this.priority = priority;
        this.next = null;
    }
}
