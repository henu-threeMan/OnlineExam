<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>系统配置</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="css/home.css">
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <link rel="icon"  sizes="32x32" href="${pageContext.request.contextPath}/img/systemIcon.jpg"/>
    <link rel="apple-touch-icon"  sizes="32x32" href="${pageContext.request.contextPath}/img/systemIcon.jpg"/>

    <link rel="icon"  sizes="32x32" href="${pageContext.request.contextPath}/img/systemIcon.jpg"/>
    <link rel="apple-touch-icon"  sizes="32x32" href="${pageContext.request.contextPath}/img/systemIcon.jpg"/>
    <style>
        body{
            background:url("${pageContext.request.contextPath}/img/background.jpg") no-repeat;
            background-size: 100%;
        }
        div{
            border:0px black solid;
        }
        .container1{
            height: 15%;
            margin:1%;
        }
        .container2{
            height: 85%;
            margin:1%;
        }
        .container2{
            margin-top: 7%;
            color:white;
            font-size: 170%;
        }
        .container2 > div{
            margin-left: 3%;
            width:30%;
        }
        .container2 li{
            margin-bottom: 12%;
        }
        .nav1{
            float:right;
            width: 80%;
            height:12%;
            font-family: SimHei;
            font-size: 18px;
        }
        .nav1 > li > a{
            border-radius: 4px;
        }
        .nav1 > nav{
            margin-top:4%;
        }
        .logo{
            float:left;
            width: 20%;
            height:100%;
            color:white;
            font-family: SimHei;
        }
        .logo > img{
            width: 60%;
            height:80%;
        }
        .logo > p{
            margin-left: 10%;
        }
    </style>
</head>
<body>
<div class="container1">
    <div class="logo">
        <img src="${pageContext.request.contextPath}/img/systemIcon.jpg" class="img-circle">
        <p>上机考试系统</p>
    </div>
    <div class="nav1">
        <nav class="navbar navbar-default" role="navigation">
            <div class="container-fluid">
                <div>
                    <!--向左对齐-->
                    <ul class="nav navbar-nav navbar-left">
                        <li role="presentation" ><a href="${pageContext.request.contextPath}/returnHomeServlet"  >首页</a></li>
                        <li role="presentation" ><a href="${pageContext.request.contextPath}/teacherManagerServlet"  >教师管理</a></li>
                        <li role="presentation" ><a href="${pageContext.request.contextPath}/clearExamServlet" >考试清理</a></li>
                        <li role="presentation" ><a href="${pageContext.request.contextPath}/configServlet" >系统配置</a></li>
                    </ul>
                    <!--向右对齐-->
                    <ul class="nav navbar-nav navbar-right">
                        <li><a>欢迎,${username}</a></li>
                        <li><a>修改信息</a></li>
                        <li><a href="${pageContext.request.contextPath}/logoutServlet">退出</a></li>
                    </ul>
                </div>
            </div>
        </nav>
    </div>
</div>

<div>

</div>
<div class="container2">

</div>
</body>
</html>
