<%--
  Created by IntelliJ IDEA.
  User: Duc
  Date: 9/16/2025
  Time: 10:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Error</title>
</head>
<body>
<c:choose>
    <c:when test="${pageContext.response.status == 500}">
        <p style="color:red;">Error: ${errors}</p>
        <jsp:include page="/views/user/add.jsp"/>
    </c:when>
    <c:otherwise>
        Hi There, error code is ${pageContext.response.status}<br>
        Please go to <a href="${pageContext.request.contextPath}/users">home page</a>
    </c:otherwise>
</c:choose>
</body>
</html>
