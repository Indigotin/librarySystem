<%--
  Created by IntelliJ IDEA.
  User: Len
  Date: 2017/9/24
  Time: 14:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>首页</title>
</head>
<body>
<div>
    <form action="${pageContext.request.contextPath}/searchBook" method="get">
        <a href="/showBorrowedBooks">还书</a>
        <a href="/payForfeit">缴纳罚金</a>
        <input type="text" name="search" placeholder="请输入你要查询的图书...">
        <input type="submit" value="搜索">
    </form>
</div>
</body>
</html>
