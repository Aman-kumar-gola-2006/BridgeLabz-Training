package com.javastreams.serialization;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

/**
 * Deserializes employee data from a file
 */
class EmployeeDeserializer {

    @SuppressWarnings("unchecked")
    public static void deserializeEmployees(String fileName) {

        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream(fileName))) {

            List<Employee> employees = (List<Employee>) ois.readObject();

            System.out.println("\nRetrieved Employee Data:");
            for (Employee emp : employees) {
                System.out.println(emp);
            }

        } catch (IOException e) {
            System.out.println("Error during deserialization.");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Employee class not found.");
            e.printStackTrace();
        }
    }
}