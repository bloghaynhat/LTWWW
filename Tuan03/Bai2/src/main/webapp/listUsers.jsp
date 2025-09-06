<%@ page import="fit.se.bai2.models.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Set" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
    <title>List User</title>
</head>
<body>
<h2>Danh sách Users đã đăng ký</h2>

<table border="1" cellpadding="5" cellspacing="0">
    <tr>
        <th>ID</th>
        <th>Họ</th>
        <th>Tên</th>
        <th>Email</th>
        <th>Ngày sinh</th>
        <th>Giới tính</th>
    </tr>

    <c:forEach var="u" items="${listUsers}">
        <tr>
            <td>${u.id}</td>
            <td>${u.firstName}</td>
            <td>${u.lastName}</td>
            <td>${u.email}</td>
            <td>${u.birthday}</td>
            <td>${u.gender}</td>
        </tr>
    </c:forEach>
</table>

<br>
<a href="registration-form.html">Đăng ký thêm User</a>
</body>
</html>
