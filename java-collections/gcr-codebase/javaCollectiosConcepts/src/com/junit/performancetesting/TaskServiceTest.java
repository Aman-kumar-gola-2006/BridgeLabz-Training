package com.junit.performancetesting;

import org.junit.Test;

//JUnit 4 timeout test
public class TaskServiceTest {

@Test(timeout = 3000) // Fails if execution exceeds 2 seconds
public void testTimeout() throws InterruptedException {
   TaskService service = new TaskService();
   service.longRunningTask();
}
}
