package com.junit.exceptionhandeling;

import org.junit.Test;

//JUnit 4 test for exception handling
public class MathUtilsTest {

 MathUtils math = new MathUtils();

 // Expecting ArithmeticException when dividing by zero
 @Test(expected = ArithmeticException.class)
 public void testDivideByZero() {
     math.divide(10, 0);
 }
}
