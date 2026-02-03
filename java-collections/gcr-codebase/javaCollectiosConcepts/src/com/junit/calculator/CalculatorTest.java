package com.junit.calculator;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {

    CalculatorApp calculator = new CalculatorApp();

    @Test
    public void testAdd() {
        Assert.assertEquals(15, calculator.add(5, 10));
    }

    @Test
    public void testSubtract() {
        Assert.assertEquals(20, calculator.subtract(30, 10));
    }

    @Test
    public void testMultiply() {
        Assert.assertEquals(0, calculator.multiply(10, 0));
    }

    @Test
    public void testDivide() {
        Assert.assertEquals(5, calculator.divide(10, 2));
    }

    @Test
    public void testDivideByZero() {
        try {
            calculator.divide(10, 0);
            Assert.fail("Expected ArithmeticException");
        } catch (ArithmeticException e) {
            Assert.assertEquals("Cannot divide by Zero", e.getMessage());
        }
    }
}
