package com.healthclinic.HealthClinicApp;

import java.sql.*;
import java.util.Scanner;

public class ClinicApp {
    
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        System.out.println("=================================");
        System.out.println("  WELCOME TO HEALTH CLINIC APP  ");
        System.out.println("=================================");
        System.out.println();
        
        // Test database connection
        Connection testConn = DatabaseConnection.getConnection();
        if (testConn == null) {
            System.out.println("Cannot connect to database. Please check your MySQL.");
            return;
        }
        
        while (true) {
            showMenu();
            int choice = getIntegerInput("Enter your choice: ");
            
            switch (choice) {
                case 1:
                    addNewPatient();
                    break;
                case 2:
                    viewAllPatients();
                    break;
                case 3:
                    updatePatientPhone();
                    break;
                case 4:
                    deletePatient();
                    break;
                case 5:
                    searchPatientByName();
                    break;
                case 6:
                    viewAllAppointments();
                    break;
                case 7:
                    System.out.println("\nThank you for using Health Clinic App!");
                    System.out.println("Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("\nInvalid choice! Please select 1-7.\n");
            }
        }
    }
    
    private static void showMenu() {
        System.out.println("\n===== MAIN MENU =====");
        System.out.println("1. Add New Patient");
        System.out.println("2. View All Patients");
        System.out.println("3. Update Patient Phone Number");
        System.out.println("4. Delete Patient");
        System.out.println("5. Search Patient by Name");
        System.out.println("6. View All Appointments");
        System.out.println("7. Exit");
        System.out.println("====================");
    }
    
    private static int getIntegerInput(String message) {
        while (true) {
            try {
                System.out.print(message);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number!");
            }
        }
    }
    
 
    // CRUD OPERATION 1: INSERT - Add New Patient
  
    private static void addNewPatient() {
        System.out.println("\n--- Add New Patient ---");
        
        System.out.print("Enter patient name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter phone number: ");
        String phone = scanner.nextLine();
        
        System.out.print("Enter date of birth (YYYY-MM-DD): ");
        String dob = scanner.nextLine();
        
        System.out.print("Enter gender (Male/Female/Other): ");
        String gender = scanner.nextLine();
        
        String sql = "INSERT INTO patient (name, phone, dob, gender) VALUES (?, ?, ?, ?)";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, name);
            pstmt.setString(2, phone);
            pstmt.setDate(3, Date.valueOf(dob));
            pstmt.setString(4, gender);
            
            int rowsInserted = pstmt.executeUpdate();
            
            if (rowsInserted > 0) {
                System.out.println("\nPatient added successfully!");
                System.out.println("  Name: " + name);
                System.out.println("  Phone: " + phone);
                System.out.println("  DOB: " + dob);
                System.out.println("  Gender: " + gender);
            }
            
        } catch (SQLException e) {
            System.out.println("\nError adding patient: " + e.getMessage());
            if (e.getMessage().contains("Data truncation")) {
                System.out.println("Tip: Check your date format (YYYY-MM-DD)");
            }
        }
    }
    
    // CRUD OPERATION 2: SELECT - View All Patients

    private static void viewAllPatients() {
        System.out.println("\n--- All Patients ---");
        
        String sql = "SELECT patient_id, name, phone, dob, gender FROM patient ORDER BY patient_id";
        
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            if (!rs.isBeforeFirst()) {
                System.out.println("No patients found in the system.");
                System.out.println("Try adding a patient first!\n");
                return;
            }
            
            System.out.println("+------------+----------------------+-------------+------------+----------+");
            System.out.println("| Patient ID | Name                 | Phone       | DOB        | Gender   |");
            System.out.println("+------------+----------------------+-------------+------------+----------+");
            
            while (rs.next()) {
                int id = rs.getInt("patient_id");
                String name = rs.getString("name");
                String phone = rs.getString("phone");
                Date dob = rs.getDate("dob");
                String gender = rs.getString("gender");
                
                System.out.printf("| %-10d | %-20s | %-11s | %-10s | %-8s |\n", 
                                 id, 
                                 name.length() > 20 ? name.substring(0, 17) + "..." : name,
                                 phone, dob, gender);
            }
            
            System.out.println("+------------+----------------------+-------------+------------+----------+");
            System.out.println("Total patients: " + getPatientCount());
            
        } catch (SQLException e) {
            System.out.println("Error fetching patients: " + e.getMessage());
        }
    }
    
    private static int getPatientCount() {
        String sql = "SELECT COUNT(*) FROM patient";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            // Silent fail
        }
        return 0;
    }
    

    // CRUD OPERATION 3: UPDATE - Update Patient Phone

    private static void updatePatientPhone() {
        System.out.println("\n--- Update Patient Phone ---");
        
        viewAllPatients();
        
        System.out.print("Enter patient ID to update: ");
        int patientId = getIntegerInput("");
        
        System.out.print("Enter new phone number: ");
        String newPhone = scanner.nextLine();
        
        System.out.print("Are you sure you want to update? (y/n): ");
        String confirm = scanner.nextLine();
        
        if (!confirm.equalsIgnoreCase("y")) {
            System.out.println("Update cancelled.");
            return;
        }
        
        String sql = "UPDATE patient SET phone = ? WHERE patient_id = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, newPhone);
            pstmt.setInt(2, patientId);
            
            int rowsUpdated = pstmt.executeUpdate();
            
            if (rowsUpdated > 0) {
                System.out.println("\nPhone number updated successfully!");
                System.out.println("  Patient ID: " + patientId);
                System.out.println("  New Phone: " + newPhone);
            } else {
                System.out.println("\nPatient with ID " + patientId + " not found!");
            }
            
        } catch (SQLException e) {
            System.out.println("\nError updating patient: " + e.getMessage());
        }
    }
    
    // CRUD OPERATION 4: DELETE - Delete Patient
    
    
    private static void deletePatient() {
        System.out.println("\n--- Delete Patient ---");
        
        viewAllPatients();
        
        System.out.print("Enter patient ID to delete: ");
        int patientId = getIntegerInput("");
        
        // Check if patient has appointments
        try (Connection conn = DatabaseConnection.getConnection()) {
            String checkSql = "SELECT COUNT(*) FROM appointment WHERE patient_id = ?";
            PreparedStatement checkStmt = conn.prepareStatement(checkSql);
            checkStmt.setInt(1, patientId);
            ResultSet rs = checkStmt.executeQuery();
            
            if (rs.next() && rs.getInt(1) > 0) {
                System.out.println("\nCannot delete this patient!");
                System.out.println("This patient has " + rs.getInt(1) + " appointment(s).");
                System.out.println("Delete the appointments first.");
                return;
            }
        } catch (SQLException e) {
            System.out.println("\nError checking appointments: " + e.getMessage());
            return;
        }
        
        System.out.print("Are you sure you want to delete this patient? (y/n): ");
        String confirm = scanner.nextLine();
        
        if (!confirm.equalsIgnoreCase("y")) {
            System.out.println("Deletion cancelled.");
            return;
        }
        
        String sql = "DELETE FROM patient WHERE patient_id = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, patientId);
            
            int rowsDeleted = pstmt.executeUpdate();
            
            if (rowsDeleted > 0) {
                System.out.println("\nPatient deleted successfully!");
            } else {
                System.out.println("\nPatient with ID " + patientId + " not found!");
            }
            
        } catch (SQLException e) {
            System.out.println("\nError deleting patient: " + e.getMessage());
        }
    }
    
    // CRUD OPERATION 5: SELECT with LIKE - Search Patient
    
    private static void searchPatientByName() {
        System.out.println("\n--- Search Patient ---");
        
        System.out.print("Enter patient name to search: ");
        String searchName = scanner.nextLine();
        
        String sql = "SELECT * FROM patient WHERE name LIKE ? ORDER BY name";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, "%" + searchName + "%");
            ResultSet rs = pstmt.executeQuery();
            
            if (!rs.isBeforeFirst()) {
                System.out.println("\nNo patients found with name containing '" + searchName + "'");
                return;
            }
            
            System.out.println("\n=== Search Results ===");
            int count = 0;
            
            while (rs.next()) {
                count++;
                System.out.println("\nPatient #" + count);
                System.out.println("  ID: " + rs.getInt("patient_id"));
                System.out.println("  Name: " + rs.getString("name"));
                System.out.println("  Phone: " + rs.getString("phone"));
                System.out.println("  DOB: " + rs.getDate("dob"));
                System.out.println("  Gender: " + rs.getString("gender"));
            }
            
            System.out.println("\nFound " + count + " patient(s) matching '" + searchName + "'");
            
        } catch (SQLException e) {
            System.out.println("\nError searching patients: " + e.getMessage());
        }
    }
    
    // EXTRA OPERATION: JOIN - View All Appointments
    
    private static void viewAllAppointments() {
        System.out.println("\n--- All Appointments ---");
        
        String sql = "SELECT a.appointment_id, p.name as patient_name, d.name as doctor_name, " +
                     "a.appointment_date, a.status " +
                     "FROM appointment a " +
                     "JOIN patient p ON a.patient_id = p.patient_id " +
                     "JOIN doctor d ON a.doctor_id = d.doctor_id " +
                     "ORDER BY a.appointment_date";
        
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            if (!rs.isBeforeFirst()) {
                System.out.println("No appointments found.");
                return;
            }
            
            System.out.println("+---------------+------------------+------------------+---------------------+-------------+");
            System.out.println("| Appointment ID | Patient          | Doctor           | Date & Time         | Status      |");
            System.out.println("+---------------+------------------+------------------+---------------------+-------------+");
            
            while (rs.next()) {
                int id = rs.getInt("appointment_id");
                String patient = rs.getString("patient_name");
                String doctor = rs.getString("doctor_name");
                Timestamp date = rs.getTimestamp("appointment_date");
                String status = rs.getString("status");
                
                System.out.printf("| %-13d | %-16s | %-16s | %-19s | %-11s |\n", 
                                 id, 
                                 patient.length() > 16 ? patient.substring(0, 13) + "..." : patient,
                                 doctor.length() > 16 ? doctor.substring(0, 13) + "..." : doctor,
                                 date, status);
            }
            
            System.out.println("+---------------+------------------+------------------+---------------------+-------------+");
            
        } catch (SQLException e) {
            System.out.println("Error fetching appointments: " + e.getMessage());
        }
    }
}