CREATE DATABASE HealthClinicDB;

USE HealthClinicDB;

CREATE TABLE Department (
    DepartmentID INT AUTO_INCREMENT PRIMARY KEY,
    DepartmentName VARCHAR(80) NOT NULL
);

INSERT INTO Department (DepartmentName)
VALUES
('Cardiology'),
('Orthopedic'),
('Neurology'),
('Pediatrics');

SELECT * FROM Department;

CREATE TABLE Doctor (
    DoctorID INT AUTO_INCREMENT PRIMARY KEY,
    FirstName VARCHAR(50) NOT NULL,
    LastName VARCHAR(50) NOT NULL,
    Specialization VARCHAR(100) NOT NULL,
    Phone VARCHAR(15) UNIQUE,
    DepartmentID INT NOT NULL,
    FOREIGN KEY (DepartmentID)
        REFERENCES Department(DepartmentID)
);

INSERT INTO Doctor
(FirstName, LastName, Specialization, Phone, DepartmentID)
VALUES
('Anita', 'Sharma', 'Cardiology', '9876543210', 1),
('Suresh', 'Kumar', 'Orthopedic', '9876543211', 2),
('Rohit', 'Singh', 'Neurology', '9876543212', 3);

SELECT * FROM Doctor;
CREATE TABLE Patient (
    PatientID INT AUTO_INCREMENT PRIMARY KEY,
    FirstName VARCHAR(50) NOT NULL,
    LastName VARCHAR(50) NOT NULL,
    DateOfBirth DATE NOT NULL,
    Gender ENUM('M','F','O') NOT NULL,
    Phone VARCHAR(15) UNIQUE,
    Address VARCHAR(200)
);


INSERT INTO Patient
(FirstName, LastName, DateOfBirth, Gender, Phone, Address)
VALUES
('Ravi', 'Kumar', '1990-01-01', 'M', '9999999999', 'Delhi'),
('Meena', 'Singh', '1988-05-05', 'F', '8888888888', 'Noida'),
('Aman', 'Verma', '1995-10-20', 'M', '7777777777', 'Agra');

SELECT * FROM Patient;



CREATE TABLE Appointment (
    AppointmentID INT AUTO_INCREMENT PRIMARY KEY,
    PatientID INT NOT NULL,
    DoctorID INT NOT NULL,
    AppointmentDate DATE NOT NULL,
    TimeSlot TIME NOT NULL,
    Status VARCHAR(20) DEFAULT 'Scheduled',

    FOREIGN KEY (PatientID)
        REFERENCES Patient(PatientID),

    FOREIGN KEY (DoctorID)
        REFERENCES Doctor(DoctorID)
);

INSERT INTO Appointment
(PatientID, DoctorID, AppointmentDate, TimeSlot, Status)
VALUES
(1, 1, '2026-08-05', '10:00:00', 'Scheduled'),
(1, 2, '2026-08-06', '11:30:00', 'Scheduled'),
(2, 1, '2026-08-07', '09:00:00', 'Completed'),
(3, 3, '2026-08-08', '02:30:00', 'Scheduled');


SELECT * FROM Appointment;

CREATE INDEX IX_Appointment_DoctorDate
ON Appointment(DoctorID, AppointmentDate);

SELECT * FROM Department;
SELECT * FROM Doctor;
SELECT * FROM Patient;

SELECT * FROM Appointment;

SELECT
    a.AppointmentID,
    p.FirstName AS Patient,
    d.FirstName AS Doctor,
    dep.DepartmentName,
    a.AppointmentDate,
    a.TimeSlot,
    a.Status
FROM Appointment a
JOIN Patient p
ON a.PatientID = p.PatientID

JOIN Doctor d
ON a.DoctorID = d.DoctorID

JOIN Department dep
ON d.DepartmentID = dep.DepartmentID;





