package com.csvhandling.advancedlevel.databasetocsv;

import java.sql.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class DatabaseToCSV {

    // Database connection details
    private static final String DB_URL = "jdbc:mysql://localhost:3306/practice";
    private static final String USER = "root";
    private static final String PASSWORD = "05092006";

    public static void main(String[] args) {

        String csvFile = "/Users/macbookair/Desktop/Al/JAVA WORKSPACE/java-iostreams/gcr-codebase/JavaIOStreamsPractice/src/com/csvhandling/advancedlevel/databasetocsv/database_export.csv";

        // SQL query to fetch employee data
        String query = "SELECT id, name, department, salary FROM employees";

        try (
                // Step 1: Create DB connection
                Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);

                // Step 2: Create statement
                Statement statement = connection.createStatement();

                // Step 3: Execute query
                ResultSet resultSet = statement.executeQuery(query);

                // Step 4: Create CSV writer
                BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile))
        ) {
            // Write CSV header
            writer.write("Employee ID,Name,Department,Salary");
            writer.newLine();

            // Write data rows
            while (resultSet.next()) {
                writer.write(
                        resultSet.getInt("id") + "," +
                        resultSet.getString("name") + "," +
                        resultSet.getString("department") + "," +
                        resultSet.getDouble("salary")
                );
                writer.newLine();
            }

            System.out.println("CSV report generated successfully: " + csvFile);

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}