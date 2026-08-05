package com.healthclinic.HealthClinicApp;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

    static String url = "jdbc:mysql://localhost:3306/health_clinic_db";
    static String username = "root";
    static String password = "";

    public static Connection getConnection() {

        Connection con = null;

        try {

            con = DriverManager.getConnection(url, username, password);
            System.out.println("Database Connected Successfully");

        } catch (Exception e) {

            System.out.println(e);

        }

        return con;
    }

    public static void main(String[] args) {

        getConnection();

    }

}