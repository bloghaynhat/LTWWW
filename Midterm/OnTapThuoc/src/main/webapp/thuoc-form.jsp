<%--
  Created by IntelliJ IDEA.
  User: Duc
  Date: 9/30/2025
  Time: 10:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Add</title>
</head>
<body>
<a href="loaithuoc">Danh sách loại thuốc</a> |
<a href="thuoc">Danh sách thuốc</a>  |
<a href="thuoc?action=ADD">Thêm thuốc mới</a>

<h1>Danh sách thuốc</h1>

<c:if test="${not empty errors}">
    <ul style="color:red;">
        <c:forEach var="err" items="${errors}">
            <li>${err.propertyPath}: ${err.message}</li>
        </c:forEach>
    </ul>
</c:if>

<form method="post" action="thuoc" enctype="multipart/form-data">
    <div>
        <label>Tên thuốc: </label>
        <input name="tenThuoc" value="${thuoc.tenThuoc != null ? thuoc.tenThuoc : ''}">
    </div>

    <div>
        <label>Giá: </label>
        <input name="gia" value="${thuoc.gia != null ? thuoc.gia : ''}">
    </div>

    <div>
        <label>Năm sản xuất: </label>
        <input name="namSX" value="${thuoc.namSX != null ? thuoc.namSX : ''}">
    </div>

    <div>
        <label>Loại thuốc: </label>
        <select name="loaiThuocID">
            <c:forEach var="l" items="${loaithuoclist}">
                <option value="${l.maLoai}"
                        <c:if test="${thuoc.loaiThuoc != null && l.maLoai == thuoc.loaiThuoc.maLoai}">selected</c:if>>
                        ${l.tenLoai}
                </option>
            </c:forEach>
        </select>
    </div>

    <div>
        <label>Hình ảnh: </label>
        <input type="file" name="hinhAnh" accept="image/*">
    </div>

    <button type="submit">Lưu</button>
</form>
</form>
</body>
</html>
