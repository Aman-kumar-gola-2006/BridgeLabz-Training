<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome - My Greetings App</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>

    <div class="navbar">
        <a href="${pageContext.request.contextPath}/home">My Greetings App</a>
        <a href="${pageContext.request.contextPath}/register">Register</a>
        <a href="${pageContext.request.contextPath}/students">User List</a>
        <div class="nav-right">
            <a href="${pageContext.request.contextPath}/logout">Logout</a>
        </div>
    </div>

    <div class="container">
        <h2>Welcome ${student.firstName} ${student.lastName}!</h2>
        <p>Welcome to <b>My Greetings App</b>!</p>
        <br>
        
        <div class="details-card">
            <h3>Registered User Details</h3>
            <hr><br>
            <p><b>User ID:</b> ${student.id}</p>
            <p><b>First Name:</b> ${student.firstName}</p>
            <p><b>Last Name:</b> ${student.lastName}</p>
            <p><b>Email:</b> ${student.email}</p>
            <p><b>Gender:</b> ${student.gender}</p>

            <br>
            <a href="${pageContext.request.contextPath}/student/edit/${student.id}" class="btn">Edit Profile</a>
            &nbsp;
            <a href="${pageContext.request.contextPath}/student/delete/${student.id}" class="btn btn-danger" onclick="return confirm('Are you sure you want to delete this profile?');">Delete Profile</a>
            &nbsp;
            <a href="${pageContext.request.contextPath}/students" class="btn btn-secondary">View All Users</a>
            &nbsp;
            <a href="${pageContext.request.contextPath}/logout" class="btn btn-secondary">Logout</a>
        </div>
    </div>

</body>
</html>
