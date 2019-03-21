<%--
  Created by IntelliJ IDEA.
  User: Len
  Date: 2017/9/25
  Time: 10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>已借详情</title>
</head>
<body>
<div Float="left">
<table border="1">
    <tr>
        <td></td>
        <td>书 名:</td>
        <td>作 者:</td>
        <td>出版社:</td>
        <td>价 格:</td>
        <td>简 介:</td>
    </tr>
    <c:forEach items="${borrowedBookList}" var="book">
        <tr>
            <td><img src="${book.photo}" width="500" height="600"></td>
            <td>${book.bookname}</td>
            <td>${book.author}</td>
            <td>${book.press}</td>
            <td>${book.price}</td>
            <td>${book.introduce}</td>
        </tr>
    </c:forEach>

</table>
</div>
<div float="right">
    <table border="1">
        <tr>
            <td>状 态:</td>
            <td>操 作:</td>
        </tr>
        <c:forEach items="${recordList}" var="record">
            <tr>
                <td>${record.returned?"已还":"借阅中"}</td>
                <td><a href="/returnBook?id=${record.id}">还书</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>



