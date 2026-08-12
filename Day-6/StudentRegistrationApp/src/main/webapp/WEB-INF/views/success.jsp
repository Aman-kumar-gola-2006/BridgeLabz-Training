<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registration Success - Student Portal</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>

    <div class="navbar">
        <a href="${pageContext.request.contextPath}/home">Home</a>
        <a href="${pageContext.request.contextPath}/register">Register</a>
        <a href="${pageContext.request.contextPath}/students">Student List</a>
        <div class="nav-right">
            <a href="${pageContext.request.contextPath}/login">Login</a>
        </div>
    </div>

    <div class="container">
        <h2>Registration Successful!</h2>
        
        <div class="details-card">
            <h3>Registered Details</h3>
            <hr><br>
            <p><b>Name:</b> ${student.firstName} ${student.lastName}</p>
            <p><b>Email:</b> ${student.email}</p>
            <p><b>Gender:</b> ${student.gender}</p>
            <p><b>Course:</b> ${student.course}</p>
            <p><b>Subjects:</b> ${student.subjects}</p>

            <c:if test="${not empty student.comments}">
                <p><b>Comments:</b> ${student.comments}</p>
            </c:if>

            <br>
            <a href="${pageContext.request.contextPath}/login" class="btn">Proceed to Login</a>
            &nbsp;
            <a href="${pageContext.request.contextPath}/students" class="btn btn-secondary">View All Students</a>
        </div>
    </div>

</body>
</html>