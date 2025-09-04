<%@ page import="fit.se.bai1.models.Student" %>
<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: Student
  Date: 9/4/2025
  Time: 7:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result submit</title>
</head>
<body>
    <%
        Student student = new Student();
        student = (Student) request.getAttribute("student");
        out.println(
                "First Name: " + student.getFirstName()
                + "<br/> Last Name: " + student.getLastName()
                + "<br/> Email: " + student.getEmail()
                + "<br/> Gender: " + student.getGender()
                + "<br/> Birthday: " + student.getBirthday()
        );
    %>
</body>
</html>
