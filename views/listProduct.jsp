<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Danh sách sản phẩm </h2>
<%--Form tìm kiếm--%>
<form action="product" method="get">
    <input type="text" name="searchProductName" placeholder="Nhập tên sản phẩm" value="${searchProductName}">
    <button type="submit">Tìm kiếm</button>
</form>
<table border="1" cellpadding="5" cellspacing="0">
    <tr>
        <th>ID</th>
        <th>Tên sản phẩm</th>
        <th>Giá</th>
        <th>Số lượng</th>
        <th>Mô tả</th>
    </tr>
    <c:forEach var="p" items="${products}">
        <tr>
            <td>${p.id}</td>
            <td>${p.productName}</td>
            <td>${p.price}</td>
            <td>${p.stock}</td>
            <td>${p.description}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
