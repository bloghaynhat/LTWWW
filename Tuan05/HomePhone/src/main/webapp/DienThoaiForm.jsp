<%--
  Created by IntelliJ IDEA.
  User: Duc
  Date: 9/24/2025
  Time: 10:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            display: flex;
            flex-direction: column;
            align-items: center;
            min-height: 100vh;
        }

        main {
            flex: 1;
            padding: 30px;
        }

        footer {
            text-align: center;
            width: 100vw;
            border-top: 2px solid;
            padding: 10px;
        }
    </style>
</head>
<body>
<img src="img/logo.png">
<div style="display: flex; justify-content: center; align-items: center; gap: 10px">
    <a href="${pageContext.request.contextPath}/dienthoai">Danh sách sản phẩm</a>
    |
    <a href="${pageContext.request.contextPath}/dienthoaiform">Thêm mới sản phẩm</a>
    |
    <a href="">Chức năng quản lí</a>
</div>
<main>
    <form action="dienthoaiform" method="post" enctype="multipart/form-data">
        <input type="hidden" name="action" value="SAVE">

        <div>
            <label>Ma Dien Thoai</label>
            <input name="maDT">
        </div>

        <div>
            <label>Ten Dien Thoai</label>
            <input name="tenDT">
        </div>

        <div>
            <label>Nam San Xuat</label>
            <input name="namSanXuat">
        </div>

        <div>
            <label>Cau hinh</label>
            <input name="cauHinh">
        </div>

        <div>
            <label>Hinh Anh</label>
            <input name="hinhAnh" type="file">
        </div>

        <div>
            <label>Nha Cung Cap</label>
            <select name="nhaCungCapId">
                <c:forEach var="ncc" items="${nhaCungCaps}">
                    <option value="${ncc.maNCC}">${ncc.tenNCC}</option>
                </c:forEach>
            </select>
        </div>

        <button type="submit">Luu</button>
    </form>
</main>
<footer>
    Footer
</footer>
</body>
</html>
