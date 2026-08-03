CREATE TABLE `Department` (
  `DepartmentID` int PRIMARY KEY,
  `DepartmentName` varchar(255)
);

CREATE TABLE `Doctor` (
  `DoctorID` int PRIMARY KEY,
  `FirstName` varchar(255),
  `LastName` varchar(255),
  `Specialization` varchar(255),
  `Phone` varchar(255),
  `DepartmentID` int
);

CREATE TABLE `Patient` (
  `PatientID` int PRIMARY KEY,
  `FirstName` varchar(255),
  `LastName` varchar(255),
  `DateOfBirth` date,
  `Gender` varchar(255),
  `Phone` varchar(255),
  `Address` varchar(255)
);

CREATE TABLE `Appointment` (
  `AppointmentID` int PRIMARY KEY,
  `PatientID` int,
  `DoctorID` int,
  `AppointmentDate` date,
  `TimeSlot` time,
  `Status` varchar(255)
);

ALTER TABLE `Doctor` ADD FOREIGN KEY (`DepartmentID`) REFERENCES `Department` (`DepartmentID`);

ALTER TABLE `Appointment` ADD FOREIGN KEY (`PatientID`) REFERENCES `Patient` (`PatientID`);

ALTER TABLE `Appointment` ADD FOREIGN KEY (`DoctorID`) REFERENCES `Doctor` (`DoctorID`);
