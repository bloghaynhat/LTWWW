<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html>
<head>
    <title>Document</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/">Quay ve list</a>

<%--@elvariable id="employee" type="java"--%>
<form:form modelAttribute="employee" action="/save" method="post">
    <table>
        <tr>
            <form:hidden path="id"/>
            <td>First Name:</td>
            <td><form:input path="firstName"/>
                <form:errors path="firstName" cssStyle="color: red"/>
            </td>
        </tr>
        <tr>
            <td>Last Name:</td>
            <td><form:input path="lastName"/><form:errors path="lastName" cssStyle="color: red"/></td>
        </tr>
        <tr>
            <td>Email:</td>
            <td><form:input path="email"/><form:errors path="email" cssStyle="color: red"/></td>
        </tr>
        <tr>
            <td>Date of birth:</td>
            <td><form:input path="dob"/><form:errors path="dob" cssStyle="color: red"/></td>
        </tr>
        <tr>
            <td>Phone:</td>
            <td><form:input path="phone"/><form:errors path="phone" cssStyle="color: red"/></td>
        </tr>
        <tr>
            <td>Gender:</td>
            <td><form:radiobutton path="gender" value="true"/> Male
                <form:radiobutton path="gender" value="false"/> Female</td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Save Changes"/>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>