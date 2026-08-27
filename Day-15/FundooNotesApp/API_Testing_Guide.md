# Fundoo Notes App - Simple Beginner Practice Project

This project implements **Notes Management with User Authorization** in **Fundoo Notes App** using **Spring Boot 3.2.5**, **Spring Security 6**, **JPA/Hibernate**, and **H2 In-Memory Database**. It uses **plain-text passwords** and **HTTP Basic Authentication**, making it simple and easy for freshers to practice.

---

## 🚀 Key Concepts Implemented

### 1. In-Memory Database & Plain-Text Auth
- **Plain-Text Passwords**: Passwords are saved and verified directly without BCrypt complexity for easy debugging and practice.
- **HTTP Basic Authentication**: API endpoints accept standard `Basic Auth` (email and password).

### 2. User Authorization & Ownership
- **User Ownership**: In `NoteService`, note ownership is verified before executing operations:
  - Users can **only** view, update, or delete notes that belong to their own account.
  - Attempting to access or delete another user's note throws a `403 Forbidden` (`UnauthorizedAccessException`).

### 3. JPA Entity Relationship
- **`@ManyToOne` Relationship**: Modelled between `Note` and `User` entities in H2 in-memory database.

---

## 📌 API Endpoints Summary

### Authentication Endpoints (`/api/auth`)
| Method | Endpoint | Description | Auth Required |
| :--- | :--- | :--- | :--- |
| `POST` | `/api/auth/register` | Register a new user with plain text password | ❌ No |
| `POST` | `/api/auth/login` | Authenticate user & return status | ❌ No |

### Notes Management Endpoints (`/api/notes`)
| Method | Endpoint | Description | Auth Required |
| :--- | :--- | :--- | :--- |
| `POST` | `/api/notes` | Create a new note for authenticated user | ✅ Yes (Basic Auth) |
| `GET` | `/api/notes` | Get all notes belonging to authenticated user | ✅ Yes (Basic Auth) |
| `GET` | `/api/notes/{id}` | Get specific note by ID (Ownership verified) | ✅ Yes (Basic Auth) |
| `PUT` | `/api/notes/{id}` | Update note by ID (Ownership verified) | ✅ Yes (Basic Auth) |
| `DELETE` | `/api/notes/{id}` | Delete note by ID (Ownership verified) | ✅ Yes (Basic Auth) |

---

## 💻 Sample cURL Commands

### 1. User Registration
```bash
curl -X POST http://localhost:8083/api/auth/register \
  -H "Content-Type: application/json" \
  -d '{
    "firstName": "Aman",
    "lastName": "Gola",
    "email": "aman.gola@example.com",
    "password": "Password123"
  }'
```

### 2. User Login
```bash
curl -X POST http://localhost:8083/api/auth/login \
  -H "Content-Type: application/json" \
  -d '{
    "email": "aman.gola@example.com",
    "password": "Password123"
  }'
```

### 3. Create Note (Using HTTP Basic Auth)
```bash
curl -X POST http://localhost:8083/api/notes \
  -u "aman.gola@example.com:Password123" \
  -H "Content-Type: application/json" \
  -d '{
    "title": "Fresher Practice Note",
    "description": "Implemented plain text authentication and in-memory H2 database in Fundoo Notes App."
  }'
```

### 4. Get User Notes
```bash
curl -X GET http://localhost:8083/api/notes \
  -u "aman.gola@example.com:Password123"
```

### 5. Get Note by ID
```bash
curl -X GET http://localhost:8083/api/notes/1 \
  -u "aman.gola@example.com:Password123"
```

### 6. Delete Note (Authorized Case)
```bash
curl -X DELETE http://localhost:8083/api/notes/1 \
  -u "aman.gola@example.com:Password123"
```

---

## 🌐 Documentation & Console
- **Swagger UI**: `http://localhost:8083/swagger-ui.html`
- **H2 DB Console**: `http://localhost:8083/h2-console` (JDBC URL: `jdbc:h2:mem:fundoodb`, Username: `sa`, Password: `password`)
