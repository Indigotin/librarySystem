<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <link href="resources/css/jquery-ui-themes.css" type="text/css" rel="stylesheet"/>
    <link href="resources/css/axure_rp_page.css" type="text/css" rel="stylesheet"/>
    <link href="resources/css/styles1.css" type="text/css" rel="stylesheet"/>
    <link href="resources/css/styles.css" type="text/css" rel="stylesheet"/>
    <script src="resources/js/jquery-1.7.1.min.js"></script>
    <script src="resources/js/jquery-ui-1.8.10.custom.min.js"></script>
    <script src="resources/js/prototypePre.js"></script>
    <script src="resources/js/document.js"></script>
    <script src="resources/js/prototypePost.js"></script>
    <script src="resources/js/data.js"></script>
</head>
<body background="resources/img/background.jpg">
<div id="base" class="">

    <form action="/login" method="post">
        <!-- Unnamed (Image) -->
        <div id="u0" class="ax_default image">
            <img id="u0_img" class="img " src="resources/img/u0.png"/>
        </div>

        <!-- Unnamed (Image) -->
        <div id="u1" class="ax_default image">
            <img id="u1_img" class="img " src="resources/img/u1.png"/>
        </div>

        <!-- Unnamed (Text Field) -->
        <div id="u2" class="ax_default text_field">
            <input id="u2_input" type="text" name="email" placeholder="E-mail"/>
        </div>

        <!-- Unnamed (HTML Button) -->
        <div id="u3" class="ax_default html_button">
            <input id="u3_input" type="submit" value="登录"/>
        </div>

        <!-- Unnamed (Text Field) -->
        <div id="u4" class="ax_default text_field">
            <input id="u4_input" type="password" name="password" placeholder="Password"/>
        </div>
    </form>
    <form action="/turnEnrollView" method="post">
        <!-- Unnamed (HTML Button) -->
        <div id="u5" class="ax_default html_button">
            <input id="u5_input" type="submit" value="注册"/>
        </div>
    </form>
</div>
</body>
</html>
