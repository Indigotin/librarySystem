<%--
  Created by IntelliJ IDEA.
  User: Len
  Date: 2017/9/27
  Time: 20:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>增加图书</title>
</head>
<body>
<form action="/AddBook" method="post" enctype="multipart/form-data">
    <table border="1">
        <tr>
            <td>书 名:</td>
            <td>作 者:</td>
            <td>出版社:</td>
            <td>价 格:</td>
            <td>简 介:</td>
            <td>照 片:</td>
            <td>库 存:</td>
        </tr>
        <tr>
            <td><input name="bookname"></td>
            <td><input name="author"></td>
            <td><input name="press"></td>
            <td><input name="price"></td>
            <td><input name="introduce"></td>
            <td><input type="file" name="photoFile"></td>
            <td><input name="num"></td>
        </tr>
    </table>
    <input type="submit" value="提交"/>
</form>
</body>
</html>
