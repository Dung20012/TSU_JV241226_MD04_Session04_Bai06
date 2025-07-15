
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Danh sách sách</h2>

<h3>Tìm kiếm sách</h3>
<form action="books" method="get">
    Tiêu đề: <input type="text" name="title" value="${title}">
    <button type="submit">Tìm kiếm</button>
</form>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Tiêu đề</th>
        <th>Tác giả</th>
        <th>Giá</th>
        <th>Mô tả</th>
    </tr>
    <c:forEach var="b" items="${books}">
        <tr>
            <td>${b.id}</td>
            <td>${b.title}</td>
            <td>${b.author}</td>
            <td>${b.price}</td>
            <td>${b.description}</td>
        </tr>
    </c:forEach>
</table>

<h3>Thêm mới sách</h3>
<form action="books" method="post">
    Tiêu đề: <input type="text" name="title"><br>
    Tác giả: <input type="text" name="author"><br>
    Giá: <input type="text" name="price"><br>
    Mô tả: <textarea name="description"></textarea><br>
    <button type="submit">Thêm sách</button>
</form>

<c:if test="${totalPages > 1}">
    <div>
        Trang:
        <c:forEach var="i" begin="1" end="${totalPages}">
            <a href="books?title=${title}&page=${i}">${i}</a>
        </c:forEach>
    </div>
</c:if>
</body>
</html>
