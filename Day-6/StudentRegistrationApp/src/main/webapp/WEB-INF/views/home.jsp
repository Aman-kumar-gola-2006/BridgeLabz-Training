<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home - My Greetings App</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>

    <div class="navbar">
        <a href="${pageContext.request.contextPath}/home">My Greetings App</a>
        <a href="${pageContext.request.contextPath}/register">Register</a>
        <a href="${pageContext.request.contextPath}/students">User List</a>
        <div class="nav-right">
            <a href="${pageContext.request.contextPath}/login">Login</a>
        </div>
    </div>

    <div class="container">
        <h2>Welcome to My Greetings App</h2>
        <hr><br>
        <p>A simple greetings application with user registration, login, and user management.</p>
        <br><br>

        <h3>Quick Options:</h3>
        <br>
        <a href="${pageContext.request.contextPath}/register" class="btn">Register New User</a>
        &nbsp;
        <a href="${pageContext.request.contextPath}/students" class="btn btn-secondary">View All Users</a>
        &nbsp;
        <a href="${pageContext.request.contextPath}/login" class="btn btn-secondary">User Login</a>
    </div>

</body>
</html>
