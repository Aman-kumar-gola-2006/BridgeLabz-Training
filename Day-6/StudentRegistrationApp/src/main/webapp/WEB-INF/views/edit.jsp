<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit User - My Greetings App</title>
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
        <h2>Update User Details</h2>

        <form:form action="${pageContext.request.contextPath}/student/update" method="post" modelAttribute="student">
            <form:hidden path="id"/>

            <div class="form-group">
                <label>First Name:</label>
                <form:input path="firstName" cssClass="form-control" />
                <form:errors path="firstName" cssClass="field-error" />
            </div>

            <div class="form-group">
                <label>Last Name:</label>
                <form:input path="lastName" cssClass="form-control" />
                <form:errors path="lastName" cssClass="field-error" />
            </div>

            <div class="form-group">
                <label>Email Address:</label>
                <form:input path="email" type="email" cssClass="form-control" />
                <form:errors path="email" cssClass="field-error" />
            </div>

            <div class="form-group">
                <label>Password:</label>
                <form:password path="password" cssClass="form-control" />
                <form:errors path="password" cssClass="field-error" />
            </div>

            <div class="form-group">
                <label>Gender:</label>
                <div class="radio-group">
                    <form:radiobutton path="gender" value="Male" id="gMale" /> <label for="gMale">Male</label>
                    <form:radiobutton path="gender" value="Female" id="gFemale" /> <label for="gFemale">Female</label>
                </div>
                <form:errors path="gender" cssClass="field-error" />
            </div>

            <button type="submit" class="btn">Update User</button>
            <a href="${pageContext.request.contextPath}/students" class="btn btn-secondary">Cancel</a>
        </form:form>
    </div>

</body>
</html>
