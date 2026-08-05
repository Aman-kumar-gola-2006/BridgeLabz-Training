package com.healthclinic;

import com.healthclinic.dao.*;
import com.healthclinic.db.DBConnection;
import com.healthclinic.model.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Scanner;

public class Main {
    
    private static Scanner scanner = new Scanner(System.in);
    
    // DAO Objects
    private static PatientDAO patientDAO = new PatientDAO();
    private static DoctorDAO doctorDAO = new DoctorDAO();
    private static DepartmentDAO departmentDAO = new DepartmentDAO();
    private static AppointmentDAO appointmentDAO = new AppointmentDAO();
    
    public static void main(String[] args) {
        
        System.out.println("=========================================");
        System.out.println("     HEALTH CLINIC MANAGEMENT SYSTEM     ");
        System.out.println("=========================================");
        System.out.println();
        
        // Test database connection
        Connection conn = DBConnection.getConnection();
        
        if (conn == null) {
            System.out.println("Cannot connect to database. Please check MySQL.");
            return;
        }
        
        System.out.println("Connected to database: health_clinic_db");
        System.out.println();
        
        while (true) {
            showMainMenu();
            int choice = getIntegerInput("Enter your choice: ");
            
            switch (choice) {
                case 1:
                    patientMenu();
                    break;
                case 2:
                    doctorMenu();
                    break;
                case 3:
                    departmentMenu();
                    break;
                case 4:
                    appointmentMenu();
                    break;
                case 5:
                    System.out.println("\nThank you for using Health Clinic App!");
                    System.out.println("Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice! Please select 1-5.");
            }
        }
    }
    
    // ============================================================
    // MAIN MENU
    // ============================================================
    private static void showMainMenu() {
        System.out.println("\n===== MAIN MENU =====");
        System.out.println("1. Patient Management");
        System.out.println("2. Doctor Management");
        System.out.println("3. Department Management");
        System.out.println("4. Appointment Management");
        System.out.println("5. Exit");
        System.out.println("====================");
    }
    
    // ============================================================
    // PATIENT MENU
    // ============================================================
    private static void patientMenu() {
        while (true) {
            System.out.println("\n--- Patient Management ---");
            System.out.println("1. Add New Patient");
            System.out.println("2. View All Patients");
            System.out.println("3. Search Patient by Name");
            System.out.println("4. Update Patient Phone");
            System.out.println("5. Delete Patient");
            System.out.println("6. Back to Main Menu");
            System.out.println("-------------------------");
            
            int choice = getIntegerInput("Enter your choice: ");
            
            switch (choice) {
                case 1:
                    addNewPatient();
                    break;
                case 2:
                    viewAllPatients();
                    break;
                case 3:
                    searchPatientByName();
                    break;
                case 4:
                    updatePatientPhone();
                    break;
                case 5:
                    deletePatient();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid choice! Please select 1-6.");
            }
        }
    }
    
    // ============================================================
    // DOCTOR MENU
    // ============================================================
    private static void doctorMenu() {
        while (true) {
            System.out.println("\n--- Doctor Management ---");
            System.out.println("1. Add New Doctor");
            System.out.println("2. View All Doctors");
            System.out.println("3. View Doctors by Department");
            System.out.println("4. Delete Doctor");
            System.out.println("5. Back to Main Menu");
            System.out.println("-------------------------");
            
            int choice = getIntegerInput("Enter your choice: ");
            
            switch (choice) {
                case 1:
                    addNewDoctor();
                    break;
                case 2:
                    viewAllDoctors();
                    break;
                case 3:
                    viewDoctorsByDepartment();
                    break;
                case 4:
                    deleteDoctor();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice! Please select 1-5.");
            }
        }
    }
    
    // ============================================================
    // DEPARTMENT MENU
    // ============================================================
    private static void departmentMenu() {
        while (true) {
            System.out.println("\n--- Department Management ---");
            System.out.println("1. Add New Department");
            System.out.println("2. View All Departments");
            System.out.println("3. Delete Department");
            System.out.println("4. Back to Main Menu");
            System.out.println("------------------------------");
            
            int choice = getIntegerInput("Enter your choice: ");
            
            switch (choice) {
                case 1:
                    addNewDepartment();
                    break;
                case 2:
                    viewAllDepartments();
                    break;
                case 3:
                    deleteDepartment();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice! Please select 1-4.");
            }
        }
    }
    
    // ============================================================
    // APPOINTMENT MENU
    // ============================================================
    private static void appointmentMenu() {
        while (true) {
            System.out.println("\n--- Appointment Management ---");
            System.out.println("1. Add New Appointment");
            System.out.println("2. View All Appointments");
            System.out.println("3. View Appointments by Patient");
            System.out.println("4. Update Appointment Status");
            System.out.println("5. Delete Appointment");
            System.out.println("6. Back to Main Menu");
            System.out.println("-------------------------------");
            
            int choice = getIntegerInput("Enter your choice: ");
            
            switch (choice) {
                case 1:
                    addNewAppointment();
                    break;
                case 2:
                    viewAllAppointments();
                    break;
                case 3:
                    viewAppointmentsByPatient();
                    break;
                case 4:
                    updateAppointmentStatus();
                    break;
                case 5:
                    deleteAppointment();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid choice! Please select 1-6.");
            }
        }
    }
    
    // ============================================================
    // HELPER METHODS
    // ============================================================
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
    
    private static void displayPatients(List<Patient> patients) {
        if (patients.isEmpty()) {
            System.out.println("No patients found.");
            return;
        }
        
        System.out.println("+------------+----------------------+-------------+------------+----------+");
        System.out.println("| Patient ID | Name                 | Phone       | DOB        | Gender   |");
        System.out.println("+------------+----------------------+-------------+------------+----------+");
        
        for (Patient p : patients) {
            String name = p.getName();
            if (name.length() > 20) {
                name = name.substring(0, 17) + "...";
            }
            System.out.printf("| %-10d | %-20s | %-11s | %-10s | %-8s |\n", 
                             p.getPatientId(), name, p.getPhone(), p.getDob(), p.getGender());
        }
        System.out.println("+------------+----------------------+-------------+------------+----------+");
    }
    
    private static void displayDoctors(List<Doctor> doctors) {
        if (doctors.isEmpty()) {
            System.out.println("No doctors found.");
            return;
        }
        
        System.out.println("+------------+----------------------+------------------+--------------+");
        System.out.println("| Doctor ID  | Name                 | Specialty        | Department ID |");
        System.out.println("+------------+----------------------+------------------+--------------+");
        
        for (Doctor d : doctors) {
            String name = d.getName();
            if (name.length() > 20) {
                name = name.substring(0, 17) + "...";
            }
            System.out.printf("| %-10d | %-20s | %-16s | %-12d |\n", 
                             d.getDoctorId(), name, d.getSpecialty(), d.getDepartmentId());
        }
        System.out.println("+------------+----------------------+------------------+--------------+");
    }
    
    private static void displayDepartments(List<Department> departments) {
        if (departments.isEmpty()) {
            System.out.println("No departments found.");
            return;
        }
        
        System.out.println("+----------------+----------------------------------+");
        System.out.println("| Department ID  | Department Name                  |");
        System.out.println("+----------------+----------------------------------+");
        
        for (Department d : departments) {
            System.out.printf("| %-14d | %-32s |\n", 
                             d.getDepartmentId(), d.getDepartmentName());
        }
        System.out.println("+----------------+----------------------------------+");
    }
    
    // ============================================================
    // PATIENT CRUD OPERATIONS
    // ============================================================
    
    private static void addNewPatient() {
        System.out.println("\n--- Add New Patient ---");
        
        System.out.print("Enter patient name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter phone number: ");
        String phone = scanner.nextLine();
        
        System.out.print("Enter date of birth (YYYY-MM-DD): ");
        String dobStr = scanner.nextLine();
        
        System.out.print("Enter gender (Male/Female/Other): ");
        String gender = scanner.nextLine();
        
        try {
            Date dob = Date.valueOf(dobStr);
            Patient patient = new Patient(name, phone, dob, gender);
            
            boolean success = patientDAO.insertPatient(patient);
            
            if (success) {
                System.out.println("\nPatient added successfully!");
            }
            
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid date format! Please use YYYY-MM-DD");
        }
    }
    
    private static void viewAllPatients() {
        System.out.println("\n--- All Patients ---");
        List<Patient> patients = patientDAO.getAllPatients();
        displayPatients(patients);
        System.out.println("Total patients: " + patientDAO.getPatientCount());
    }
    
    private static void searchPatientByName() {
        System.out.println("\n--- Search Patient ---");
        
        System.out.print("Enter patient name to search: ");
        String name = scanner.nextLine();
        
        List<Patient> patients = patientDAO.searchPatientsByName(name);
        
        if (patients.isEmpty()) {
            System.out.println("No patients found with name containing '" + name + "'");
            return;
        }
        
        System.out.println("\nFound " + patients.size() + " patient(s):");
        displayPatients(patients);
    }
    
    private static void updatePatientPhone() {
        System.out.println("\n--- Update Patient Phone ---");
        
        viewAllPatients();
        System.out.println();
        
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
        
        boolean success = patientDAO.updatePatientPhone(patientId, newPhone);
        
        if (success) {
            System.out.println("Phone number updated to: " + newPhone);
        }
    }
    
    private static void deletePatient() {
        System.out.println("\n--- Delete Patient ---");
        
        viewAllPatients();
        System.out.println();
        
        System.out.print("Enter patient ID to delete: ");
        int patientId = getIntegerInput("");
        
        System.out.print("Are you sure you want to delete this patient? (y/n): ");
        String confirm = scanner.nextLine();
        
        if (!confirm.equalsIgnoreCase("y")) {
            System.out.println("Deletion cancelled.");
            return;
        }
        
        patientDAO.deletePatient(patientId);
    }
    
    // ============================================================
    // DOCTOR CRUD OPERATIONS
    // ============================================================
    
    private static void addNewDoctor() {
        System.out.println("\n--- Add New Doctor ---");
        
        // Show departments first
        viewAllDepartments();
        System.out.println();
        
        System.out.print("Enter doctor name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter specialty: ");
        String specialty = scanner.nextLine();
        
        System.out.print("Enter department ID: ");
        int departmentId = getIntegerInput("");
        
        Doctor doctor = new Doctor(name, specialty, departmentId);
        doctorDAO.insertDoctor(doctor);
    }
    
    private static void viewAllDoctors() {
        System.out.println("\n--- All Doctors ---");
        List<Doctor> doctors = doctorDAO.getAllDoctors();
        displayDoctors(doctors);
    }
    
    private static void viewDoctorsByDepartment() {
        System.out.println("\n--- Doctors by Department ---");
        
        viewAllDepartments();
        System.out.println();
        
        System.out.print("Enter department ID: ");
        int departmentId = getIntegerInput("");
        
        List<Doctor> doctors = doctorDAO.getDoctorsByDepartment(departmentId);
        displayDoctors(doctors);
    }
    
    private static void deleteDoctor() {
        System.out.println("\n--- Delete Doctor ---");
        
        viewAllDoctors();
        System.out.println();
        
        System.out.print("Enter doctor ID to delete: ");
        int doctorId = getIntegerInput("");
        
        System.out.print("Are you sure you want to delete this doctor? (y/n): ");
        String confirm = scanner.nextLine();
        
        if (!confirm.equalsIgnoreCase("y")) {
            System.out.println("Deletion cancelled.");
            return;
        }
        
        doctorDAO.deleteDoctor(doctorId);
    }
    
    // ============================================================
    // DEPARTMENT CRUD OPERATIONS
    // ============================================================
    
    private static void addNewDepartment() {
        System.out.println("\n--- Add New Department ---");
        
        System.out.print("Enter department name: ");
        String name = scanner.nextLine();
        
        Department department = new Department(name);
        departmentDAO.insertDepartment(department);
    }
    
    private static void viewAllDepartments() {
        System.out.println("\n--- All Departments ---");
        List<Department> departments = departmentDAO.getAllDepartments();
        displayDepartments(departments);
    }
    
    private static void deleteDepartment() {
        System.out.println("\n--- Delete Department ---");
        
        viewAllDepartments();
        System.out.println();
        
        System.out.print("Enter department ID to delete: ");
        int departmentId = getIntegerInput("");
        
        System.out.print("Are you sure you want to delete this department? (y/n): ");
        String confirm = scanner.nextLine();
        
        if (!confirm.equalsIgnoreCase("y")) {
            System.out.println("Deletion cancelled.");
            return;
        }
        
        departmentDAO.deleteDepartment(departmentId);
    }
    
    // ============================================================
    // APPOINTMENT CRUD OPERATIONS
    // ============================================================
    
    private static void addNewAppointment() {
        System.out.println("\n--- Add New Appointment ---");
        
        // Show patients
        System.out.println("\nAvailable Patients:");
        viewAllPatients();
        
        // Show doctors
        System.out.println("\nAvailable Doctors:");
        viewAllDoctors();
        System.out.println();
        
        System.out.print("Enter patient ID: ");
        int patientId = getIntegerInput("");
        
        System.out.print("Enter doctor ID: ");
        int doctorId = getIntegerInput("");
        
        System.out.print("Enter appointment date and time (YYYY-MM-DD HH:MM:SS): ");
        String dateTimeStr = scanner.nextLine();
        
        System.out.print("Enter status (Scheduled/Completed/Cancelled): ");
        String status = scanner.nextLine();
        
        try {
            Timestamp dateTime = Timestamp.valueOf(dateTimeStr);
            Appointment appointment = new Appointment(patientId, doctorId, dateTime, status);
            appointmentDAO.insertAppointment(appointment);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid date/time format! Please use YYYY-MM-DD HH:MM:SS");
        }
    }
    
    private static void viewAllAppointments() {
        System.out.println("\n--- All Appointments ---");
        
        List<String[]> appointments = appointmentDAO.getAppointmentsWithDetails();
        
        if (appointments.isEmpty()) {
            System.out.println("No appointments found.");
            return;
        }
        
        System.out.println("+---------------+------------------+------------------+---------------------+-------------+");
        System.out.println("| Appointment ID | Patient          | Doctor           | Date & Time         | Status      |");
        System.out.println("+---------------+------------------+------------------+---------------------+-------------+");
        
        for (String[] row : appointments) {
            String patient = row[1];
            String doctor = row[2];
            if (patient.length() > 16) patient = patient.substring(0, 13) + "...";
            if (doctor.length() > 16) doctor = doctor.substring(0, 13) + "...";
            
            System.out.printf("| %-13s | %-16s | %-16s | %-19s | %-11s |\n", 
                             row[0], patient, doctor, row[3], row[4]);
        }
        System.out.println("+---------------+------------------+------------------+---------------------+-------------+");
    }
    
    private static void viewAppointmentsByPatient() {
        System.out.println("\n--- Appointments by Patient ---");
        
        viewAllPatients();
        System.out.println();
        
        System.out.print("Enter patient ID: ");
        int patientId = getIntegerInput("");
        
        List<Appointment> appointments = appointmentDAO.getAppointmentsByPatient(patientId);
        
        if (appointments.isEmpty()) {
            System.out.println("No appointments found for this patient.");
            return;
        }
        
        System.out.println("\nAppointments for Patient ID " + patientId + ":");
        for (Appointment a : appointments) {
            System.out.println("  ID: " + a.getAppointmentId() + 
                             " | Doctor ID: " + a.getDoctorId() +
                             " | Date: " + a.getAppointmentDate() +
                             " | Status: " + a.getStatus());
        }
    }
    
    private static void updateAppointmentStatus() {
        System.out.println("\n--- Update Appointment Status ---");
        
        viewAllAppointments();
        System.out.println();
        
        System.out.print("Enter appointment ID to update: ");
        int appointmentId = getIntegerInput("");
        
        System.out.print("Enter new status (Scheduled/Completed/Cancelled): ");
        String status = scanner.nextLine();
        
        appointmentDAO.updateAppointmentStatus(appointmentId, status);
    }
    
    private static void deleteAppointment() {
        System.out.println("\n--- Delete Appointment ---");
        
        viewAllAppointments();
        System.out.println();
        
        System.out.print("Enter appointment ID to delete: ");
        int appointmentId = getIntegerInput("");
        
        System.out.print("Are you sure you want to delete this appointment? (y/n): ");
        String confirm = scanner.nextLine();
        
        if (!confirm.equalsIgnoreCase("y")) {
            System.out.println("Deletion cancelled.");
            return;
        }
        
        appointmentDAO.deleteAppointment(appointmentId);
    }
}