<%--
  Created by IntelliJ IDEA.
  User: Duc
  Date: 9/30/2025
  Time: 10:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="loaithuoc">Danh sách loại thuốc</a> |
<a href="thuoc">Danh sách thuốc</a> |
<a href="thuoc?action=ADD">Thêm thuốc mới</a>

<h1>Danh sách thuốc</h1>
<table border="1">
    <tr>
        <th>MA LOAI</th>
        <th>TEN LOAI</th>
        <th>Fucntion</th>
    </tr>
    <c:forEach var="t" items="${loaithuoclist}">
        <tr>
            <td>${t.maLoai}</td>
            <td>${t.tenLoai}</td>
            <td>
                <form action="thuoc" method="get">
                <input type="hidden" name="loaiThuocID" value="${t.maLoai}">
                <button type="submit">Xem thuốc</button>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
