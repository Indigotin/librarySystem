<%--
  Created by IntelliJ IDEA.
  User: Len
  Date: 2017/9/30
  Time: 18:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改读者信息</title>
</head>
<body>
<form action="/ChangeReaderInfo" method="post" enctype="multipart/form-data">
    <table border="1">
        <tr>
            <td>头 像:</td>
            <td>邮 箱:</td>
            <td>姓 名:</td>
            <td>年 龄:</td>
            <td>电 话:</td>
            <td>余 额:</td>
        </tr>
        <tr>
            <input type="hidden" name="id" value="${readerInfo.id}">
            <input name="photo" value="${readerInfo.photo}" type="hidden"/>
            <input name="password" value="${readerInfo.password}" type="hidden"/>
            <td><input type="file" name="photoFile"></td>
            <td><input name="email" value="${readerInfo.email}"></td>
            <td><input name="name" value="${readerInfo.name}"></td>
            <td><input name="age" value="${readerInfo.age}"></td>
            <td><input name="phone" value="${readerInfo.phone}"></td>
            <td><input name="balance" value="${readerInfo.balance}"></td>
        </tr>
    </table>
    <input type="submit" value="提交"/>
</form>
</body>
</html>
