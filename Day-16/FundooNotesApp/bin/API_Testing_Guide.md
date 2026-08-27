# Fundoo Notes App - User Management Module (Day 13)

This project implements the **User Management Module** for **Fundoo Notes App** using **Spring Boot 3.2.5**, **Spring Security**, and **JWT (JSON Web Token) Authentication**.

---

## 🚀 Key Features

1. **User Registration** (`POST /api/users/register`): Registers new users with BCrypt password hashing & validation.
2. **User Login & JWT Generation** (`POST /api/users/login`): Authenticates users and returns signed JWT token.
3. **Protected APIs** (`GET /api/users/profile`, `GET /api/users/me`): Protected using custom `JwtAuthenticationFilter`.
4. **Password Recovery Flow**:
   - `POST /api/users/forgot-password`: Generates a signed password reset JWT token.
   - `POST /api/users/reset-password`: Validates reset token and updates password.
5. **Swagger UI**: Interactive OpenAPI documentation at `http://localhost:8083/swagger-ui.html`.
6. **H2 Console**: In-memory database console at `http://localhost:8083/h2-console`.

---

## 🛠 Tech Stack

- **Framework**: Spring Boot 3.2.5 (Java 17)
- **Security**: Spring Security 6 & JJWT (`io.jsonwebtoken 0.11.5`)
- **Database**: H2 In-Memory DB (`jdbc:h2:mem:fundoodb`)
- **Documentation**: Springdoc OpenAPI (Swagger 3)

---

## 📌 API Endpoints Summary

| Method | Endpoint | Description | Auth Required |
| :--- | :--- | :--- | :--- |
| `POST` | `/api/users/register` | Register a new user | ❌ No |
| `POST` | `/api/users/login` | Authenticate user & get JWT token | ❌ No |
| `POST` | `/api/users/forgot-password` | Request password reset token | ❌ No |
| `POST` | `/api/users/reset-password` | Reset password using reset token | ❌ No |
| `GET` | `/api/users/profile` | Get logged-in user profile | ✅ Yes (`Bearer <token>`) |
| `GET` | `/api/users/me` | Get logged-in user email | ✅ Yes (`Bearer <token>`) |

---

## 💻 Sample cURL Commands

### 1. User Registration
```bash
curl -X POST http://localhost:8083/api/users/register \
  -H "Content-Type: application/json" \
  -d '{
    "firstName": "Aman",
    "lastName": "Gola",
    "email": "aman.gola@example.com",
    "password": "Password@123"
  }'
```

### 2. User Login
```bash
curl -X POST http://localhost:8083/api/users/login \
  -H "Content-Type: application/json" \
  -d '{
    "email": "aman.gola@example.com",
    "password": "Password@123"
  }'
```

### 3. Get User Profile (Protected)
```bash
curl -X GET http://localhost:8083/api/users/profile \
  -H "Authorization: Bearer <YOUR_JWT_TOKEN>"
```

### 4. Forgot Password
```bash
curl -X POST http://localhost:8083/api/users/forgot-password \
  -H "Content-Type: application/json" \
  -d '{
    "email": "aman.gola@example.com"
  }'
```

### 5. Reset Password
```bash
curl -X POST http://localhost:8083/api/users/reset-password \
  -H "Content-Type: application/json" \
  -d '{
    "resetToken": "<YOUR_RESET_TOKEN>",
    "newPassword": "NewPassword@456"
  }'
```
