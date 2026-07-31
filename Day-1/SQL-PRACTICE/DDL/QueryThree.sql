CREATE DATABASE CompanyDB;

USE CompanyDB;

CREATE TABLE Employee (
    emp_id INT PRIMARY KEY,
    emp_name VARCHAR(50),
    age INT,
    salary DECIMAL(10,2),
    department VARCHAR(30)
);
DESC Employee;

ALTER TABLE Employee
ADD email VARCHAR(100);

ALTER TABLE Employee
ADD phone VARCHAR(15),
ADD city VARCHAR(30);

ALTER TABLE Employee
RENAME COLUMN emp_name TO employee_name;

ALTER TABLE Employee
DROP COLUMN city;


