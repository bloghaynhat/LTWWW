<%--
  Created by IntelliJ IDEA.
  User: Duc
  Date: 9/23/2025
  Time: 9:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Danh sách sản phẩm</title>
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
    <a href="">Danh sách sản phẩm</a>
    |
    <a href="">Thêm mới sản phẩm</a>
    |
    <a href="">Chức năng quản lí</a>
</div>
<main>
    <c:forEach var="nc" items="${listNCC}">
        <h2>Nhà cung cấp: ${nc.tenNCC}</h2>
        <table border="1">
            <tr>
                <th>MADT</th>
                <th>TENDT</th>
                <th>NAMSANXUAT</th>
                <th>CAUHINH</th>
                <th>HINHANH</th>
            </tr>
            <c:forEach var="dt" items="${nc.dienThoais}">
                <tr>
                    <td>${dt.maDT}</td>
                    <td>${dt.tenDT}</td>
                    <td>${dt.namSanXuat}</td>
                    <td>${dt.cauHinh}</td>
                    <td><img src="anhdienthoai?maDT=${dt.maDT}" width="100"/></td>
                </tr>
            </c:forEach>

        </table>
    </c:forEach>
</main>
<footer>
    Footer
</footer>
</body>
</html>
