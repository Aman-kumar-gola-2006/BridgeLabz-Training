package com.healthclinic.dao;

import com.healthclinic.db.DBConnection;
import com.healthclinic.model.Department;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDAO {
    
    // CREATE - Insert new department
    public boolean insertDepartment(Department department) {
        String sql = "INSERT INTO department (department_name) VALUES (?)";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, department.getDepartmentName());
            
            int rowsAffected = pstmt.executeUpdate();
            
            if (rowsAffected > 0) {
                System.out.println("Department inserted successfully!");
                return true;
            }
            
        } catch (SQLException e) {
            System.out.println("Error inserting department: " + e.getMessage());
        }
        
        return false;
    }
    
    // READ - Get all departments
    public List<Department> getAllDepartments() {
        List<Department> departments = new ArrayList<>();
        String sql = "SELECT * FROM department ORDER BY department_id";
        
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                Department department = new Department();
                department.setDepartmentId(rs.getInt("department_id"));
                department.setDepartmentName(rs.getString("department_name"));
                departments.add(department);
            }
            
            System.out.println("Fetched " + departments.size() + " departments.");
            
        } catch (SQLException e) {
            System.out.println("Error fetching departments: " + e.getMessage());
        }
        
        return departments;
    }
    
    // READ - Get department by ID
    public Department getDepartmentById(int departmentId) {
        String sql = "SELECT * FROM department WHERE department_id = ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, departmentId);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                Department department = new Department();
                department.setDepartmentId(rs.getInt("department_id"));
                department.setDepartmentName(rs.getString("department_name"));
                return department;
            }
            
        } catch (SQLException e) {
            System.out.println("Error fetching department: " + e.getMessage());
        }
        
        return null;
    }
    
    // DELETE - Delete department
    public boolean deleteDepartment(int departmentId) {
        String sql = "DELETE FROM department WHERE department_id = ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, departmentId);
            int rowsAffected = pstmt.executeUpdate();
            
            if (rowsAffected > 0) {
                System.out.println("Department deleted successfully!");
                return true;
            } else {
                System.out.println("Department with ID " + departmentId + " not found.");
            }
            
        } catch (SQLException e) {
            System.out.println("Error deleting department: " + e.getMessage());
        }
        
        return false;
    }
}