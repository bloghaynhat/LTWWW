<%--
  Created by IntelliJ IDEA.
  User: Duc
  Date: 9/30/2025
  Time: 9:21 PM
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
    <a href="thuoc">Danh sách thuốc</a>  |
    <a href="thuoc?action=ADD">Thêm thuốc mới</a>

    <h1>Danh sách thuốc</h1>

    <form method="get" action="thuoc">
        <select name="loaiThuocID">
            <option value="ALL">Tất cả</option>
            <c:forEach var="t" items="${loaithuoclist}">
                <option value="${t.maLoai}"
                        <c:if test="${selectedLoaiThuocID == t.maLoai}">selected</c:if>
                >${t.tenLoai}</option>
            </c:forEach>
        </select>

        <button type="submit">Tìm</button>
    </form>

    <table border="1">
        <tr>
            <th>MA THUOC</th>
            <th>TEN THUOC</th>
            <th>GIA</th>
            <th>NAM SX</th>
            <th>MA LOAI</th>
            <th>Function</th>
        </tr>
        <c:forEach var="t" items="${thuoclist}">
            <tr>
                <td>${t.maThuoc}</td>
                <td>${t.tenThuoc}</td>
                <td>${t.gia}</td>
                <td>${t.namSX}</td>
                <td>${t.loaiThuoc.tenLoai}</td>
                <td>
                    <c:if test="${not empty t.hinhAnh}">
                        <img src="${pageContext.request.contextPath}/${t.hinhAnh}" width="100" alt="">
                    </c:if>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
