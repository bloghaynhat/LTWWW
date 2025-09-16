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
    <title>Add / Edit User</title>
</head>
<body>
    <h2>
        <c:choose>
            <c:when test="${user != null}">Edit User</c:when>
            <c:otherwise>Add User</c:otherwise>
        </c:choose>
    </h2>
<%--  Hiển thị lỗi tại đây  --%>
    <c:if test="${not empty errors}" >
        <p style="text-align: left; color:red;">
           ${errors}
        </p>
    </c:if>


    <form action="${pageContext.request.contextPath}/users?action=add" method="post">
        <c:if test="${user != null}">
            <input type="hidden" name="action" value="update"/>
            <input type="hidden" name="id" value="${user.id}"/>
        </c:if>
        <c:if test="${user == null}">
            <input type="hidden" name="action" value="add"/>
        </c:if>

        <table>
            <tr>
                <th>Name:</th>
                <td>
                    <input type="text" name="name" maxlength="50" size="50"
                           value="${user != null ? user.name : ''}"/>
                </td>
            </tr>
            <tr>
                <th>Email:</th>
                <td>
                    <input type="email" name="email" maxlength="50" size="50"
                           value="${user != null ? user.email : ''}"/>
                </td>
            </tr>
            <tr>
                <th>Birthday:</th>
                <td>
                    <input type="date" name="birthday"
                           value="${user != null ? user.birthday : ''}"/>
                </td>
            </tr>
            <tr>
                <th>Gender:</th>
                <td>
                    <select name="gender">
                        <option value="MALE"  ${user != null && user.gender == 'MALE' ? 'selected' : ''}>Male</option>
                        <option value="FEMALE" ${user != null && user.gender == 'FEMALE' ? 'selected' : ''}>Female</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td colspan="2" style="text-align:center;">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
