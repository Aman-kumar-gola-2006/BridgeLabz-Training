package com.linkedlist.circularlinkedlist.roundrobinschedulingalgorithm;

public class RoundRobinScheduler {


    private ProcessNode last;   // tail of circular list
    private int timeQuantum;
    private int currentTime = 0;
    private int totalProcesses = 0;

    public RoundRobinScheduler(int timeQuantum) {
        this.timeQuantum = timeQuantum;
    }

    /* ---------------- ADD PROCESS ---------------- */

    public void addProcess(int pid, int burst, int priority) {
        ProcessNode newProcess = new ProcessNode(pid, burst, priority);

        if (last == null) {
            last = newProcess;
            last.next = last;
        } else {
            newProcess.next = last.next;
            last.next = newProcess;
            last = newProcess;
        }

        totalProcesses++;
    }

    /* ---------------- REMOVE PROCESS ---------------- */

    private void removeProcess(ProcessNode prev, ProcessNode curr) {

        if (curr == last && curr.next == last) {
            last = null;
        } else {
            prev.next = curr.next;
            if (curr == last) {
                last = prev;
            }
        }
        totalProcesses--;
    }

    /* ---------------- ROUND ROBIN SIMULATION ---------------- */

    public void simulate() {
        if (last == null) {
            System.out.println("No processes to schedule");
            return;
        }

        ProcessNode curr = last.next;
        ProcessNode prev = last;

        System.out.println("\n--- ROUND ROBIN EXECUTION ---");

        while (last != null) {

            if (curr.remainingTime > 0) {

                int execTime = Math.min(timeQuantum, curr.remainingTime);
                curr.remainingTime -= execTime;
                currentTime += execTime;

                System.out.println("Process " + curr.pid +
                        " executed for " + execTime + " units");

                if (curr.remainingTime == 0) {
                    curr.turnaroundTime = currentTime;
                    curr.waitingTime = curr.turnaroundTime - curr.burstTime;

                    System.out.println("Process " + curr.pid + " completed");

                    removeProcess(prev, curr);
                    curr = prev.next;
                    continue;
                }
            }

            prev = curr;
            curr = curr.next;

            displayQueue();
        }

        System.out.println("\nAll processes completed");
    }

    /* ---------------- DISPLAY QUEUE ---------------- */

    public void displayQueue() {
        if (last == null) {
            System.out.println("Queue empty");
            return;
        }

        ProcessNode temp = last.next;
        System.out.print("Queue: ");

        do {
            System.out.print("[P" + temp.pid +
                    " RT=" + temp.remainingTime + "] ");
            temp = temp.next;
        } while (temp != last.next);

        System.out.println();
    }

    /* ---------------- CALCULATE AVERAGES ---------------- */

    public void displayAverages(ProcessNode[] completed) {
        double totalWT = 0, totalTAT = 0;

        for (ProcessNode p : completed) {
            totalWT += p.waitingTime;
            totalTAT += p.turnaroundTime;
        }

        System.out.println("\nAverage Waiting Time: " +
                (totalWT / completed.length));
        System.out.println("Average Turnaround Time: " +
                (totalTAT / completed.length));
    }
}
