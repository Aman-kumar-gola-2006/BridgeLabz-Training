package com.healthclinic.dao;

import com.healthclinic.db.DBConnection;
import com.healthclinic.model.Appointment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AppointmentDAO {
    
    // CREATE - Insert new appointment
    public boolean insertAppointment(Appointment appointment) {
        String sql = "INSERT INTO appointment (patient_id, doctor_id, appointment_date, status) VALUES (?, ?, ?, ?)";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, appointment.getPatientId());
            pstmt.setInt(2, appointment.getDoctorId());
            pstmt.setTimestamp(3, appointment.getAppointmentDate());
            pstmt.setString(4, appointment.getStatus());
            
            int rowsAffected = pstmt.executeUpdate();
            
            if (rowsAffected > 0) {
                System.out.println("Appointment inserted successfully!");
                return true;
            }
            
        } catch (SQLException e) {
            System.out.println("Error inserting appointment: " + e.getMessage());
        }
        
        return false;
    }
    
    // READ - Get all appointments
    public List<Appointment> getAllAppointments() {
        List<Appointment> appointments = new ArrayList<>();
        String sql = "SELECT * FROM appointment ORDER BY appointment_date";
        
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                Appointment appointment = new Appointment();
                appointment.setAppointmentId(rs.getInt("appointment_id"));
                appointment.setPatientId(rs.getInt("patient_id"));
                appointment.setDoctorId(rs.getInt("doctor_id"));
                appointment.setAppointmentDate(rs.getTimestamp("appointment_date"));
                appointment.setStatus(rs.getString("status"));
                appointments.add(appointment);
            }
            
            System.out.println("Fetched " + appointments.size() + " appointments.");
            
        } catch (SQLException e) {
            System.out.println("Error fetching appointments: " + e.getMessage());
        }
        
        return appointments;
    }
    
    // READ - Get appointments with patient and doctor names (JOIN)
    public List<String[]> getAppointmentsWithDetails() {
        List<String[]> appointments = new ArrayList<>();
        String sql = "SELECT a.appointment_id, p.name as patient_name, d.name as doctor_name, " +
                     "a.appointment_date, a.status " +
                     "FROM appointment a " +
                     "JOIN patient p ON a.patient_id = p.patient_id " +
                     "JOIN doctor d ON a.doctor_id = d.doctor_id " +
                     "ORDER BY a.appointment_date";
        
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                String[] row = new String[5];
                row[0] = String.valueOf(rs.getInt("appointment_id"));
                row[1] = rs.getString("patient_name");
                row[2] = rs.getString("doctor_name");
                row[3] = String.valueOf(rs.getTimestamp("appointment_date"));
                row[4] = rs.getString("status");
                appointments.add(row);
            }
            
        } catch (SQLException e) {
            System.out.println("Error fetching appointment details: " + e.getMessage());
        }
        
        return appointments;
    }
    
    // READ - Get appointments by patient ID
    public List<Appointment> getAppointmentsByPatient(int patientId) {
        List<Appointment> appointments = new ArrayList<>();
        String sql = "SELECT * FROM appointment WHERE patient_id = ? ORDER BY appointment_date";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, patientId);
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                Appointment appointment = new Appointment();
                appointment.setAppointmentId(rs.getInt("appointment_id"));
                appointment.setPatientId(rs.getInt("patient_id"));
                appointment.setDoctorId(rs.getInt("doctor_id"));
                appointment.setAppointmentDate(rs.getTimestamp("appointment_date"));
                appointment.setStatus(rs.getString("status"));
                appointments.add(appointment);
            }
            
        } catch (SQLException e) {
            System.out.println("Error fetching appointments by patient: " + e.getMessage());
        }
        
        return appointments;
    }
    
    // UPDATE - Update appointment status
    public boolean updateAppointmentStatus(int appointmentId, String status) {
        String sql = "UPDATE appointment SET status = ? WHERE appointment_id = ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, status);
            pstmt.setInt(2, appointmentId);
            
            int rowsAffected = pstmt.executeUpdate();
            
            if (rowsAffected > 0) {
                System.out.println("Appointment status updated successfully!");
                return true;
            } else {
                System.out.println("Appointment with ID " + appointmentId + " not found.");
            }
            
        } catch (SQLException e) {
            System.out.println("Error updating appointment status: " + e.getMessage());
        }
        
        return false;
    }
    
    // DELETE - Delete appointment
    public boolean deleteAppointment(int appointmentId) {
        String sql = "DELETE FROM appointment WHERE appointment_id = ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, appointmentId);
            int rowsAffected = pstmt.executeUpdate();
            
            if (rowsAffected > 0) {
                System.out.println("Appointment deleted successfully!");
                return true;
            } else {
                System.out.println("Appointment with ID " + appointmentId + " not found.");
            }
            
        } catch (SQLException e) {
            System.out.println("Error deleting appointment: " + e.getMessage());
        }
        
        return false;
    }
}