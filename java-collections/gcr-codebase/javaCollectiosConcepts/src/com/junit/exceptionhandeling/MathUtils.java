package com.junit.exceptionhandeling;

//Utility class for mathematical operations
public class MathUtils {

// Divides two numbers
public int divide(int a, int b) {
   if (b == 0) {
       throw new ArithmeticException("Division by zero");
   }
   return a / b;
}
}
