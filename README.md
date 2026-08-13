# 🚀 BridgeLabz Refresher Training

<p align="center">
  <img src="https://img.shields.io/badge/Java-21-orange?style=for-the-badge&logo=openjdk" />
  <img src="https://img.shields.io/badge/Spring-Framework-green?style=for-the-badge&logo=spring" />
  <img src="https://img.shields.io/badge/Spring%20MVC-Web%20Development-brightgreen?style=for-the-badge" />
  <img src="https://img.shields.io/badge/Spring%20Boot-REST%20API-success?style=for-the-badge&logo=springboot" />
  <img src="https://img.shields.io/badge/MySQL-Database-blue?style=for-the-badge&logo=mysql" />
  <img src="https://img.shields.io/badge/Postman-API%20Testing-orange?style=for-the-badge&logo=postman" />
  <img src="https://img.shields.io/badge/Git-GitHub-black?style=for-the-badge&logo=github" />
</p>

---

## 📖 About This Repository

Welcome to my **BridgeLabz Refresher Training** repository.

This repository contains my day-wise learning journey during the
**BridgeLabz Java Full Stack Refresher Training Program**.

It includes practical assignments, Java programs, SQL exercises,
Spring Framework concepts, Spring MVC applications, REST APIs,
API testing, and backend development projects.

The main objective of this training is to strengthen my existing
development skills and gain hands-on experience with industry-oriented
Java Full Stack technologies.

---

# 🎯 Learning Objectives

- Strengthen Core Java concepts
- Practice SQL and database operations
- Understand Java Web Development
- Learn Servlet and Tomcat fundamentals
- Understand Spring Framework and IoC
- Implement Dependency Injection
- Learn Spring MVC architecture
- Develop REST APIs
- Understand request handling
- Learn API testing
- Work with Postman and REST Assured
- Understand SDLC and backend development workflow
- Build a Contact Management backend application

---

# 🛠 Technologies & Tools

- ☕ Java 21
- 🌱 Spring Framework
- 🌱 Spring MVC
- 🚀 Spring Boot
- 🌐 Servlets
- 🐱 Apache Tomcat
- 🗄️ MySQL
- 🔗 JDBC
- 📦 Maven
- 🧪 Postman
- 🧪 REST Assured
- 💻 Eclipse / STS
- 🌿 Git & GitHub

---

# 📅 Training Progress

| Day | Topics Covered | Status |
|---|---|---|
| Day 1 | SQL Practice – DDL & DML | ✅ Completed |
| Day 2 | Database Practice & ER Diagram | ✅ Completed |
| Day 3 | Java Programming Practice | ✅ Completed |
| Day 4 | Health Clinic Management System – JDBC | ✅ Completed |
| Day 5 | Tomcat, Servlets & Spring Introduction | ✅ Completed |
| Day 6 | Spring MVC – My Greeting Application | ✅ Completed |
| Day 7 | REST API, Request Handling & Contact App Backend | ✅ Completed |
| Day 8 | Backend API Testing, SDLC & Contact App | ✅ Completed |
| Day 9 | Contact App Backend – Continued Development | 🔄 In Progress |

---

# 📂 Repository Structure

```text
BridgeLabz-Training
│
├── Day-1
│   └── SQL-PRACTICE
│       ├── DDL
│       └── DML
│
├── Day-2
│   └── practice
│       ├── HealthClinic.sql
│       ├── ER DIAGRAM.png
│       └── SQL Practice
│
├── Day-3
│   └── Java Practice
│
├── Day-4
│   └── HealthClinicApp
│
├── Day-5
│   └── Tomcat-Servlet-Spring
│
├── Day-6
│   └── Spring-MVC
│       └── My-Greeting-App
│
├── Day-7
│   └── Contact-App
│       └── Backend
│
├── Day-8
│   └── Contact-App
│       └── Backend
│
├── Day-9
│   └── Contact-App
│       └── Backend
│
└── README.md
```

---

# 📚 Day 1 – SQL Fundamentals

## Topics Covered

- Introduction to SQL
- Database Creation
- Tables
- DDL Commands
- DML Commands
- Primary Key
- Foreign Key
- Unique Key
- NOT NULL
- CHECK Constraint
- DEFAULT Constraint

## SQL Commands Practiced

```text
CREATE
ALTER
DROP
INSERT
UPDATE
DELETE
SELECT
```

---

# 📚 Day 2 – Database Practice

## Topics Covered

- Health Clinic Database
- Database Schema
- ER Diagram
- Table Relationships
- SQL Queries
- Relational Database Concepts

## Practice Files

```text
HealthClinic.sql
ER DIAGRAM.png
```

---

# 📚 Day 3 – Java Programming

## Topics Covered

- Java Basics
- Variables
- Data Types
- Operators
- Conditional Statements
- Loops
- Methods
- Classes & Objects
- Constructors
- Packages
- Object-Oriented Programming

---

# 📚 Day 4 – Health Clinic Management System

## Project

A console-based **Health Clinic Management System** developed using
Java, JDBC and MySQL.

## Features

- Add Patient
- View Patients
- Update Patient
- Delete Patient
- Search Patient
- Doctor Management
- Department Management

## Concepts Practiced

- JDBC Connectivity
- CRUD Operations
- SQL Queries
- Exception Handling
- Database Connectivity
- DAO Pattern
- Object-Oriented Programming

---

# 📚 Day 5 – Tomcat, Servlets & Spring Introduction

## Topics Covered

### Apache Tomcat

- Introduction to Tomcat
- Web Server vs Application Server
- Deploying Java Web Applications
- Servlet Container
- Understanding Servlet Lifecycle

### Servlets

- Introduction to Servlets
- Servlet Lifecycle
- `init()`
- `service()`
- `doGet()`
- `doPost()`
- `destroy()`
- Request and Response
- Servlet Mapping

### Spring Framework Introduction

- Introduction to Spring
- Why Spring?
- Spring Container
- IoC – Inversion of Control
- Dependency Injection
- Spring Bean
- ApplicationContext
- Bean Configuration

### Basic IoC Container

Practiced creating and managing objects through the
**Spring IoC Container** instead of manually creating objects.

```text
Application
     │
     ▼
Spring IoC Container
     │
     ├── Creates Bean
     ├── Manages Bean
     └── Injects Dependencies
```

---

# 📚 Day 6 – Spring MVC

## Project: My Greeting Application

Developed a basic **Greeting Application** using Spring MVC.

## Spring MVC Architecture

```text
Client
  │
  ▼
DispatcherServlet
  │
  ▼
Controller
  │
  ▼
Service / Business Logic
  │
  ▼
Model
  │
  ▼
View
  │
  ▼
Response
```

## Concepts Covered

- Spring MVC
- DispatcherServlet
- Controller
- Request Mapping
- Model
- View
- View Resolver
- Request Handling
- MVC Architecture

### DispatcherServlet

The `DispatcherServlet` acts as the **front controller** in Spring MVC.

It receives incoming requests and forwards them to the appropriate
controller.

### Controller

The Controller handles the incoming request and prepares the response.

### View

The View is responsible for presenting the response to the user.

---

# 📚 Day 7 – REST API & Request Handling

## Topics Covered

- Introduction to REST API
- HTTP Methods
- GET
- POST
- PUT
- DELETE
- Request Handling
- Request Parameters
- Path Variables
- Request Body
- Response Handling
- HTTP Status Codes

## REST API Flow

```text
Client
  │
  ▼
HTTP Request
  │
  ▼
Controller
  │
  ▼
Business Logic
  │
  ▼
Response
  │
  ▼
Client
```

## Contact App Backend – Initial Development

Started developing the **Contact Management Application Backend**.

### Initial Work

- Created backend project
- Configured application
- Created basic controller
- Created test endpoint
- Tested API request and response
- Started implementing Contact-related functionality

---

# 📚 Day 8 – Backend Basics & API Testing

## Topics Covered

### Backend Development

- REST API fundamentals
- Request Handling
- Response Handling
- API Structure
- Controller Layer
- Basic Backend Architecture
- REST API Testing

### API Testing

Practiced testing APIs using:

- Postman
- REST Assured

## Postman Testing

Tested REST endpoints by sending:

```text
GET
POST
PUT
DELETE
```

and verified:

- Request
- Response
- Status Code
- Response Body
- Headers

---

## SDLC Exposure

Gained exposure to the **Software Development Life Cycle (SDLC)**.

### Basic SDLC Flow

```text
Requirement
     ↓
Analysis
     ↓
Design
     ↓
Development
     ↓
Testing
     ↓
Deployment
     ↓
Maintenance
```

Understanding SDLC helped connect the training assignments with a
real-world software development workflow.

---

# 📚 Day 8 – Contact App Backend

Continued development of the **Contact Management Application**.

## Work Completed

- Continued backend development
- Applied REST API concepts
- Implemented request handling
- Created and tested Contact APIs
- Tested APIs using Postman
- Started API automation using REST Assured
- Practiced backend development workflow

---

# 📚 Day 9 – Contact App Backend

## 🔄 Continued Development

Day 9 continues the development of the **Contact Management Application Backend**.

The focus is on applying the concepts learned during previous days
to build a more structured backend application.

## Focus Areas

- Continue Contact API development
- Improve request handling
- Implement backend business logic
- Organize application layers
- Test Contact APIs
- Handle API responses
- Validate API behavior
- Continue Postman testing
- Continue REST Assured testing

## Application Flow

```text
Client
   │
   ▼
REST API
   │
   ▼
Controller
   │
   ▼
Service
   │
   ▼
Repository / DAO
   │
   ▼
Database
```

---

# 🧪 API Testing

API testing is performed using:

### Postman

Used for manual API testing and verification.

### REST Assured

Used for automated API testing.

Example testing flow:

```text
Send Request
     ↓
Receive Response
     ↓
Verify Status Code
     ↓
Verify Response Body
     ↓
Validate API Behavior
```

---

# 🧠 Key Concepts Learned So Far

By Day 9, the training has covered:

```text
Java
 │
 ├── OOP
 ├── Exception Handling
 └── Programming Fundamentals
        │
        ▼
SQL / MySQL
        │
        ▼
JDBC
        │
        ▼
Servlets
        │
        ▼
Tomcat
        │
        ▼
Spring IoC
        │
        ▼
Spring MVC
        │
        ▼
REST API
        │
        ▼
Backend Development
        │
        ▼
API Testing
 ├── Postman
 └── REST Assured
```

---

# 🎯 Current Project – Contact Management Application

The **Contact Management Application** is being developed as a
backend-focused application during the refresher training.

## Current Development Areas

- REST APIs
- Contact Management
- Request Handling
- Backend Architecture
- API Testing
- Postman
- REST Assured
- Layered Architecture

The application will continue to evolve as new concepts are introduced
during the upcoming training sessions.

---

# 📈 Training Progress

```text
Day 01  ✅ SQL
Day 02  ✅ Database & ER Diagram
Day 03  ✅ Java
Day 04  ✅ JDBC Health Clinic App
Day 05  ✅ Tomcat, Servlets & Spring IoC
Day 06  ✅ Spring MVC & Greeting App
Day 07  ✅ REST API & Contact App
Day 08  ✅ Backend & API Testing
Day 09  🔄 Contact App Development
```

### Overall Progress

**9 / 20 Days Completed/In Progress**

```text
█████████░░░░░░░░░░░ 45%
```

---

# 🚀 Upcoming Learning

The upcoming training sessions will focus on extending the backend
application and learning additional Java Full Stack technologies.

Expected areas include:

- Advanced Spring
- Spring Boot
- REST API Development
- Database Integration
- Validation
- Exception Handling
- Spring Data JPA
- Hibernate
- Unit Testing
- Microservices
- Security
- Deployment

---

# 👨‍💻 Author

## Aman Kumar Gola

**Java Full Stack Developer**

- 📧 Email: `amanagola9841@gmail.com`
- 💼 LinkedIn: `aman-kumar-gola-08872b25b`
- 🐙 GitHub: `Aman-kumar-gola-2006`
- 🌐 Portfolio: `amankumargola.in`

---

<div align="center">

### 🚀 BridgeLabz Refresher Training

**Learning • Practicing • Building • Improving**

⭐ Thank you for visiting my repository!

</div>
