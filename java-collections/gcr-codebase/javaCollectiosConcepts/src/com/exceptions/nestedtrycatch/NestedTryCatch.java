package com.exceptions.nestedtrycatch;

public class NestedTryCatch {
    public static void main(String[] args) {

        int[] arr = {10, 20, 30};
        int index = 2;
        int divisor = 10;

        try {
            try {
                int result = arr[index] / divisor;
                System.out.println("Result: " + result);
            } catch (ArithmeticException e) {
                System.out.println("Cannot divide by zero!");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid array index!");
        }
    }
}