<%--
  Created by IntelliJ IDEA.
  User: Len
  Date: 2017/9/25
  Time: 11:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>读者资料管理</title>
</head>
<body>
<table border="1">
    <tr>
        <td>头 像:</td>
        <td>邮 箱:</td>
        <td>姓 名:</td>
        <td>年 龄:</td>
        <td>电 话:</td>
        <td>余 额:</td>
        <td>操 作:</td>
    </tr>
    <c:forEach items="${readerList}" var="reader">

        <tr>
            <td><img src="${reader.photo}" width="100" height="100"></td>
            <td>${reader.email}</td>
            <td>${reader.name}</td>
            <td>${reader.age}</td>
            <td>${reader.phone}</td>
            <td>${reader.balance}</td>
            <td>
                <a href="/DelReader?id=${reader.id}">删除</a>
                <a href="/turnReaderChangeView?id=${reader.id}">修改</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
