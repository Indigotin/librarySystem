<%--
  Created by IntelliJ IDEA.
  User: Len
  Date: 2017/9/24
  Time: 14:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>结果</title>
</head>
<body>
<table border="1">
    <tr>
        <td></td>
        <td>书 名:</td>
        <td>作 者:</td>
        <td>出版社:</td>
        <td>价 格:</td>
        <td>简 介:</td>
        <td>余 量:</td>
        <td>操 作:</td>
    </tr>
    <c:forEach items="${booksList}" var="book">

        <tr>
            <td><img src="${book.photo}" width="500" height="600"></td>
            <td>${book.bookname}</td>
            <td>${book.author}</td>
            <td>${book.press}</td>
            <td>${book.price}</td>
            <td>${book.introduce}</td>
            <td>${book.num}</td>
            <td><a href="/borrowBook?id=${book.id}">借书</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
