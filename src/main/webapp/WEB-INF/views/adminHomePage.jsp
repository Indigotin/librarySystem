<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>管理员-首页</title>
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
    <div class="col-md-2 col-sm-2">
      <!-- collapsible list group -->
      <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
        <div class="panel panel-default">
          <div class="panel-heading" role="tab" id="headingOne">
            <h4 class="panel-title">
              <a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                图书管理
              </a>
            </h4>
          </div>
          <div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
            <div class="list-group">
              <li class="list-group-item my-sidebar-indent">
                <a href="/turnAddView">增加图书</a>
              </li>

              <li class="list-group-item my-sidebar-indent">
                <a href="/BookInfoManage">图书资料管理</a>
              </li>

              <li class="list-group-item my-sidebar-indent">
                <a href="/ReaderInfoManage">读者资料管理</a>
              </li>

              <li class="list-group-item my-sidebar-indent">
                <a href="/">用户密码重置</a>
              </li>
              <li class="list-group-item my-sidebar-indent">
                <a href="/">个人信息管理</a>
              </li>
              <li class="list-group-item my-sidebar-indent">
                <a href="/">可借数量管理</a>
              </li>
              <li class="list-group-item my-sidebar-indent">
                <a href="/">校对超时时间更改</a>
              </li>
            </div>
          </div>
        </div>

      </div>
    </div>

    <div id="myContainer" class="col-md-10 col-sm-10">
      <h1 class="welcome">欢迎使用图书管理系统</h1>
      <table>
        <c:forEach items="${booksList}" var="book">
          <tr>
            <td><img src="${book.photo}" width="150" height="200"></td>
            <td>${book.bookname}</td>
            <td>${book.author}</td>
            <td>${book.press}</td>
            <td>${book.price}</td>
            <td>${book.introduce}</td>
          </tr>
        </c:forEach>
      </table>

    </div>
  </div>
</div>
</body>
</html>
