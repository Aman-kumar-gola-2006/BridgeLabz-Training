package com.annotations.repeatableannotation;

public class PaymentService {

    @BugReport(description = "Null pointer when amount is zero")
    @BugReport(description = "Incorrect rounding for decimals")
    public void processPayment() {
        System.out.println("Processing payment...");
    }
}
