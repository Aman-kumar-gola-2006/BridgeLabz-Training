package com.healthclinic.dao;

import com.healthclinic.db.DBConnection;
import com.healthclinic.model.Doctor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DoctorDAO {
    
    // CREATE - Insert new doctor
    public boolean insertDoctor(Doctor doctor) {
        String sql = "INSERT INTO doctor (name, specialty, department_id) VALUES (?, ?, ?)";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, doctor.getName());
            pstmt.setString(2, doctor.getSpecialty());
            pstmt.setInt(3, doctor.getDepartmentId());
            
            int rowsAffected = pstmt.executeUpdate();
            
            if (rowsAffected > 0) {
                System.out.println("Doctor inserted successfully!");
                return true;
            }
            
        } catch (SQLException e) {
            System.out.println("Error inserting doctor: " + e.getMessage());
        }
        
        return false;
    }
    
    // READ - Get all doctors
    public List<Doctor> getAllDoctors() {
        List<Doctor> doctors = new ArrayList<>();
        String sql = "SELECT * FROM doctor ORDER BY doctor_id";
        
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                Doctor doctor = new Doctor();
                doctor.setDoctorId(rs.getInt("doctor_id"));
                doctor.setName(rs.getString("name"));
                doctor.setSpecialty(rs.getString("specialty"));
                doctor.setDepartmentId(rs.getInt("department_id"));
                doctors.add(doctor);
            }
            
            System.out.println("Fetched " + doctors.size() + " doctors.");
            
        } catch (SQLException e) {
            System.out.println("Error fetching doctors: " + e.getMessage());
        }
        
        return doctors;
    }
    
    // READ - Get doctor by ID
    public Doctor getDoctorById(int doctorId) {
        String sql = "SELECT * FROM doctor WHERE doctor_id = ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, doctorId);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                Doctor doctor = new Doctor();
                doctor.setDoctorId(rs.getInt("doctor_id"));
                doctor.setName(rs.getString("name"));
                doctor.setSpecialty(rs.getString("specialty"));
                doctor.setDepartmentId(rs.getInt("department_id"));
                return doctor;
            }
            
        } catch (SQLException e) {
            System.out.println("Error fetching doctor: " + e.getMessage());
        }
        
        return null;
    }
    
    // READ - Get doctors by department
    public List<Doctor> getDoctorsByDepartment(int departmentId) {
        List<Doctor> doctors = new ArrayList<>();
        String sql = "SELECT * FROM doctor WHERE department_id = ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, departmentId);
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                Doctor doctor = new Doctor();
                doctor.setDoctorId(rs.getInt("doctor_id"));
                doctor.setName(rs.getString("name"));
                doctor.setSpecialty(rs.getString("specialty"));
                doctor.setDepartmentId(rs.getInt("department_id"));
                doctors.add(doctor);
            }
            
        } catch (SQLException e) {
            System.out.println("Error fetching doctors by department: " + e.getMessage());
        }
        
        return doctors;
    }
    
    // DELETE - Delete doctor
    public boolean deleteDoctor(int doctorId) {
        String sql = "DELETE FROM doctor WHERE doctor_id = ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, doctorId);
            int rowsAffected = pstmt.executeUpdate();
            
            if (rowsAffected > 0) {
                System.out.println("Doctor deleted successfully!");
                return true;
            } else {
                System.out.println("Doctor with ID " + doctorId + " not found.");
            }
            
        } catch (SQLException e) {
            System.out.println("Error deleting doctor: " + e.getMessage());
        }
        
        return false;
    }
}