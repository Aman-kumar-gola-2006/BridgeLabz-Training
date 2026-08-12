<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login - My Greetings App</title>
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
        <h2>User Login Form</h2>

        <c:if test="${not empty successMessage}">
            <div class="alert alert-success">${successMessage}</div>
        </c:if>

        <c:if test="${not empty errorMessage}">
            <div class="alert alert-danger">${errorMessage}</div>
        </c:if>

        <form action="${pageContext.request.contextPath}/login" method="post">

            <div class="form-group">
                <label>Email Address:</label>
                <input type="email" name="email" class="form-control" placeholder="Enter your email" required>
            </div>

            <div class="form-group">
                <label>Password:</label>
                <input type="password" name="password" class="form-control" placeholder="Enter your password" required>
            </div>

            <button type="submit" class="btn">Login</button>

        </form>

        <br>
        <p>New User? <a href="${pageContext.request.contextPath}/register">Register Here</a></p>
    </div>

</body>
</html>
