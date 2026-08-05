package com.healthclinic.dao;

import com.healthclinic.db.DBConnection;
import com.healthclinic.model.Patient;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PatientDAO {
    
    // 1. CREATE - Insert new patient
    public boolean insertPatient(Patient patient) {
        String sql = "INSERT INTO patient (name, phone, dob, gender) VALUES (?, ?, ?, ?)";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, patient.getName());
            pstmt.setString(2, patient.getPhone());
            pstmt.setDate(3, patient.getDob());
            pstmt.setString(4, patient.getGender());
            
            int rowsAffected = pstmt.executeUpdate();
            
            if (rowsAffected > 0) {
                System.out.println("Patient inserted successfully!");
                return true;
            }
            
        } catch (SQLException e) {
            System.out.println("Error inserting patient: " + e.getMessage());
        }
        
        return false;
    }
    
    // 2. READ - Get all patients
    public List<Patient> getAllPatients() {
        List<Patient> patients = new ArrayList<>();
        String sql = "SELECT * FROM patient ORDER BY patient_id";
        
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                Patient patient = new Patient();
                patient.setPatientId(rs.getInt("patient_id"));
                patient.setName(rs.getString("name"));
                patient.setPhone(rs.getString("phone"));
                patient.setDob(rs.getDate("dob"));
                patient.setGender(rs.getString("gender"));
                patients.add(patient);
            }
            
            System.out.println("Fetched " + patients.size() + " patients.");
            
        } catch (SQLException e) {
            System.out.println("Error fetching patients: " + e.getMessage());
        }
        
        return patients;
    }
    
    // 3. READ - Get patient by ID
    public Patient getPatientById(int patientId) {
        String sql = "SELECT * FROM patient WHERE patient_id = ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, patientId);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                Patient patient = new Patient();
                patient.setPatientId(rs.getInt("patient_id"));
                patient.setName(rs.getString("name"));
                patient.setPhone(rs.getString("phone"));
                patient.setDob(rs.getDate("dob"));
                patient.setGender(rs.getString("gender"));
                return patient;
            }
            
        } catch (SQLException e) {
            System.out.println("Error fetching patient: " + e.getMessage());
        }
        
        return null;
    }
    
    // 4. READ - Search patients by name
    public List<Patient> searchPatientsByName(String name) {
        List<Patient> patients = new ArrayList<>();
        String sql = "SELECT * FROM patient WHERE name LIKE ? ORDER BY name";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, "%" + name + "%");
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                Patient patient = new Patient();
                patient.setPatientId(rs.getInt("patient_id"));
                patient.setName(rs.getString("name"));
                patient.setPhone(rs.getString("phone"));
                patient.setDob(rs.getDate("dob"));
                patient.setGender(rs.getString("gender"));
                patients.add(patient);
            }
            
            System.out.println("Found " + patients.size() + " patient(s) matching '" + name + "'");
            
        } catch (SQLException e) {
            System.out.println("Error searching patients: " + e.getMessage());
        }
        
        return patients;
    }
    
    // 5. UPDATE - Update patient phone
    public boolean updatePatientPhone(int patientId, String newPhone) {
        String sql = "UPDATE patient SET phone = ? WHERE patient_id = ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, newPhone);
            pstmt.setInt(2, patientId);
            
            int rowsAffected = pstmt.executeUpdate();
            
            if (rowsAffected > 0) {
                System.out.println("Patient phone updated successfully!");
                return true;
            } else {
                System.out.println("Patient with ID " + patientId + " not found.");
            }
            
        } catch (SQLException e) {
            System.out.println("Error updating patient: " + e.getMessage());
        }
        
        return false;
    }
    
    // 6. DELETE - Delete patient
    public boolean deletePatient(int patientId) {
        // First check if patient has appointments
        String checkSql = "SELECT COUNT(*) FROM appointment WHERE patient_id = ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement checkStmt = conn.prepareStatement(checkSql)) {
            
            checkStmt.setInt(1, patientId);
            ResultSet rs = checkStmt.executeQuery();
            
            if (rs.next() && rs.getInt(1) > 0) {
                System.out.println("Cannot delete patient. They have " + rs.getInt(1) + " appointment(s).");
                return false;
            }
            
        } catch (SQLException e) {
            System.out.println("Error checking appointments: " + e.getMessage());
            return false;
        }
        
        // If no appointments, proceed with deletion
        String deleteSql = "DELETE FROM patient WHERE patient_id = ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(deleteSql)) {
            
            pstmt.setInt(1, patientId);
            int rowsAffected = pstmt.executeUpdate();
            
            if (rowsAffected > 0) {
                System.out.println("Patient deleted successfully!");
                return true;
            } else {
                System.out.println("Patient with ID " + patientId + " not found.");
            }
            
        } catch (SQLException e) {
            System.out.println("Error deleting patient: " + e.getMessage());
        }
        
        return false;
    }
    
    // 7. Count total patients
    public int getPatientCount() {
        String sql = "SELECT COUNT(*) FROM patient";
        
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            if (rs.next()) {
                return rs.getInt(1);
            }
            
        } catch (SQLException e) {
            System.out.println("Error counting patients: " + e.getMessage());
        }
        
        return 0;
    }
}