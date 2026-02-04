package com.annotations.repeatableannotation;

import java.lang.reflect.Method;

public class BugReportReader {

    public static void main(String[] args) throws Exception {

        Method method = PaymentService.class.getMethod("processPayment");

        BugReport[] bugReports = method.getAnnotationsByType(BugReport.class);

        for (BugReport bug : bugReports) {
            System.out.println("Bug: " + bug.description());
        }
    }
}
