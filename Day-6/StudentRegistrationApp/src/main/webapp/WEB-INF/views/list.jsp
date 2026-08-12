<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registered Users - My Greetings App</title>
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
        <h2>Registered Users List</h2>

        <c:if test="${not empty successMessage}">
            <div class="alert alert-success">${successMessage}</div>
        </c:if>
        <c:if test="${not empty errorMessage}">
            <div class="alert alert-danger">${errorMessage}</div>
        </c:if>

        <c:choose>
            <c:when test="${not empty students}">
                <table class="table">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Email</th>
                            <th>Gender</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="s" items="${students}">
                            <tr>
                                <td>${s.id}</td>
                                <td>${s.firstName} ${s.lastName}</td>
                                <td>${s.email}</td>
                                <td>${s.gender}</td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/student/${s.id}" class="btn btn-sm">View</a>
                                    <a href="${pageContext.request.contextPath}/student/edit/${s.id}" class="btn btn-secondary btn-sm">Edit</a>
                                    <a href="${pageContext.request.contextPath}/student/delete/${s.id}" class="btn btn-danger btn-sm" onclick="return confirm('Are you sure you want to delete this user?');">Delete</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:when>
            <c:otherwise>
                <p>No user records found in the database.</p>
                <br>
                <a href="${pageContext.request.contextPath}/register" class="btn">Register First User</a>
            </c:otherwise>
        </c:choose>
    </div>

</body>
</html>
