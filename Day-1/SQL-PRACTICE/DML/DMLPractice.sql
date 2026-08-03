USE AMAN;
SHOW TABLES;
DESC Employee;
SELECT * FROM Employee;
SELECT emp_id, emp_name
FROM Employee;

INSERT INTO Employee
VALUES (111,'Ravi',45000,'IT','ravi@gmail.com');

INSERT INTO Employee
VALUES (112,'Priya',52000,'HR','priya@gmail.com');


INSERT INTO Employee
VALUES
(113,'Aman',60000,'Sales','aman@gmail.com'),
(114,'Neha',55000,'Finance','neha@gmail.com');

SELECT *
FROM Employee
WHERE department='IT';

SELECT *
FROM Employee
WHERE salary < 45000;

DELETE FROM Employee
WHERE emp_id=111;

