package com.javastreams.serialization;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Serializes a list of employees to a file
 */
class EmployeeSerializer {

    public static void serializeEmployees(List<Employee> employees, String fileName) {

        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream(fileName))) {

            oos.writeObject(employees);
            System.out.println("Employees serialized successfully.");

        } catch (IOException e) {
            System.out.println("Error during serialization.");
            e.printStackTrace();
        }
    }
}