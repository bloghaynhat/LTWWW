<%--
  Created by IntelliJ IDEA.
  User: Duc
  Date: 9/16/2025
  Time: 9:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Edit User</title>
    <style>
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
            background: #f4f4f4;
        }
        form {
            background: #fff;
            padding: 20px 30px;
            border-radius: 10px;
            box-shadow: 0 2px 8px rgba(0,0,0,0.2);
            max-width: 350px;
            width: 100%;
        }
        table {
            width: 100%;
        }
        th {
            text-align: left;
            padding: 5px;
        }
        td {
            padding: 5px;
        }
        h2 {
            text-align: center;
            margin-bottom: 15px;
        }
    </style>
</head>
<body>

<form action="${pageContext.request.contextPath}/users?action=update" method="post">
    <h2>
        Edit User Form
    </h2>

    <%--  Hiển thị lỗi nếu có  --%>
    <c:if test="${not empty errors}">
        <p style="text-align: left; color:red;">
                ${errors}
        </p>
    </c:if>

    <table>
        <%-- Hidden field để giữ ID user  --%>
        <input type="hidden" name="id" value="${user.id}" />

        <tr>
            <th>Name:</th>
            <td>
                <input type="text" name="name" maxlength="50" value="${user.name}" />
            </td>
        </tr>
        <tr>
            <th>Email:</th>
            <td>
                <input type="email" name="email" maxlength="50" value="${user.email}" />
            </td>
        </tr>
        <tr>
            <th>Password:</th>
            <td>
                <input type="password" name="password" maxlength="50" value="${user.password}" />
            </td>
        </tr>
        <tr>
            <th>Birthday:</th>
            <td>
                <input type="date" name="birthday" value="${user.birthday}" />
            </td>
        </tr>
        <tr>
            <th>Gender:</th>
            <td>
                <input type="radio" name="gender" value="Male"
                       <c:if test="${user.gender == 'Male'}">checked</c:if> /> Male &nbsp;
                <input type="radio" name="gender" value="Female"
                       <c:if test="${user.gender == 'Female'}">checked</c:if> /> Female
            </td>
        </tr>
        <tr>
            <td colspan="2" style="text-align:center;">
                <input type="submit" value="Update"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>