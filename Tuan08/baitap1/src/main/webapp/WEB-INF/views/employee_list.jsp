<%@ page language="java" contentType="text/html; UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!doctype html>
<html >
<head>
    <title>Document</title>
</head>
<body>
<table border="1">
    <tr>
        <td>Id</td>
        <td>First Name</td>
        <td>Last Name</td>
        <td>Email</td>
        <td>Date of birth</td>
        <td>Phone</td>
        <td>Gender</td>
        <td>Action</td>
    </tr>
    <c:forEach var="employee" items="${employees}">
        <tr>
            <td>${employee.id}</td>
            <td>${employee.firstName}</td>
            <td>${employee.lastName}</td>
            <td>${employee.email}</td>
            <td>${employee.dob}</td>
            <td>${employee.phone}</td>
            <td>${employee.gender}</td>
            <td><a href="${pageContext.request.contextPath}/update?employeeId=${employee.id}">Edit</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>