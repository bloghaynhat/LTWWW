<%--
  Created by IntelliJ IDEA.
  User: Duc
  Date: 9/16/2025
  Time: 9:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<html>
<head>
    <title>List User</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f9f9f9;
            margin: 0;
            padding: 20px;
            display: flex;
            flex-direction: column;
            align-items: center;
        }

        h2 {
            margin-bottom: 15px;
        }

        table {
            border-collapse: collapse;
            width: 80%;
            background: #fff;
            border: 1px solid #ccc;
        }

        th, td {
            padding: 8px 12px;
            text-align: center;
            border-bottom: 1px solid #eee;
        }

        th {
            background: #eee;
        }

        tr:hover {
            background: #f5f5f5;
        }

        a {
            text-decoration: none;
            padding: 4px 8px;
            margin: 0 2px;
            font-size: 13px;
            color: #007bff;
            border: 1px solid #007bff;
            border-radius: 3px;
        }

        a:hover {
            background: #007bff;
            color: #fff;
        }

        a[href*="new"] {
            margin-bottom: 10px;
            padding: 6px 10px;
            border: none;
            background: #28a745;
            color: white;
            border-radius: 3px;
        }
    </style>
</head>
<body>
<h2><a href="${pageContext.request.contextPath}/users?action=new">Add New User</a></h2>
<h2>Danh sách User</h2>
<table>
    <tr>
        <th>ID</th><th>Name</th><th>Email</th><th>Birthday</th><th>Gender</th><th>Actions</th>
    </tr>
    <c:forEach var="u" items="${users}">
        <tr>
            <td>${u.id}</td>
            <td>${u.name}</td>
            <td>${u.email}</td>
            <td>${u.birthday}</td>
            <td>${u.gender}</td>
            <td>
                <a href="${pageContext.request.contextPath}/users?action=edit&id=${u.id}">Edit</a>
                <a href="${pageContext.request.contextPath}/users?action=delete&id=${u.id}"
                   onclick="return confirm('Are you sure you want to delete this user?');">
                    Delete
                </a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

