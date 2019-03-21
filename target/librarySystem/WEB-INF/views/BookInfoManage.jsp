<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>图书管理</title>
    <link rel="stylesheet" href="../../resources/css/normalize.css">
    <link rel="stylesheet" href="../../resources/css/bootstrap.css">
    <link rel="stylesheet" href="../../resources/css/index.css"><!--?ver=date()-->
  </head>
<body>
<div class="row">
  <div class="col-md-12 col-sm-12">
    <!-- navbar -->
    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">图书管理系统控制台</a>
        </div>
      </div><!-- /.container-fluid -->
    </nav>
  </div>
</div>
<div class="row my-body-padding">
  <div class="container-fluid">
    <div id="myContainer" class="col-md-10 col-sm-10">
      <h1 class="welcome">欢迎使用图书管理系统</h1>
      <table border="1">
        <tr>
          <td></td>
          <td>书 名:</td>
          <td>作 者:</td>
          <td>出版社:</td>
          <td>价 格:</td>
          <td>简 介:</td>
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
            <td>
              <a href="/DelBook?id=${book.id}">删除</a>
              <a href="/turnChangeView?id=${book.id}">修改</a>
            </td>
          </tr>
        </c:forEach>
      </table>
    </div>
  </div>
</div>
</body>
</html>
