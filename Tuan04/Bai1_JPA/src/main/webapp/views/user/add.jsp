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
    <title>Add User</title>
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

<form action="${pageContext.request.contextPath}/users?action=add" method="post">
    <h2>
        User Registration Form
    </h2>

    <%--  Hiển thị lỗi tại đây  --%>
    <c:if test="${not empty errors}">
        <p style="text-align: left; color:red;">
                ${errors}
        </p>
    </c:if>

    <table>
        <tr>
            <th>Name:</th>
            <td>
                <input type="text" name="name" maxlength="50"
                />
            </td>
        </tr>
        <tr>
            <th>Email:</th>
            <td>
                <input type="email" name="email" maxlength="50"
                />
            </td>
        </tr>
        <tr>
            <th>Password:</th>
            <td>
                <input type="password" name="password" maxlength="50"
                />
            </td>
        </tr>
        <tr>
            <th>Birthday:</th>
            <td>
                <input type="date" name="birthday"
                />
            </td>
        </tr>
        <tr>
            <th>Gender:</th>
            <td>
                <input type="radio" name="gender" value="Male" /> Male &nbsp;
                <input type="radio" name="gender" value="Female" /> Female
            </td>
        </tr>
        <tr>
            <td colspan="2" style="text-align:center;">
                <input type="submit" value="Save"/>
            </td>
        </tr>
    </table>
    <input type="hidden" name="action" value="add" />
</form>
</body>
</html>
