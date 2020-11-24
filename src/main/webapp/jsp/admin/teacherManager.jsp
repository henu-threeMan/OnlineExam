<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>教室管理</title>
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

<div class="container2">
    <%--添加联系人、删除选中--%>
    <div style="float:right">
        <button class="btn btn-default" type="submit">添加教师</button>
        <button class="btn btn-default" type="submit">删除选中</button>
        <button class="btn btn-default" type="submit">批量导入</button>
    </div>
    <%--用户信息表--%>
    <form>
        <table class="table table-bordered table-hover">
            <tr class="tableHead">
                <td><input type="checkbox"></td>
                <td>编号</td><td>用户名</td><td>密码</td><td>真实名字</td><td>操作</td>
            </tr>

            <c:forEach items="${teacherList}" var="str" varStatus="s">
                <tr>
                    <td><input type="checkbox"></td>
                    <td>${s.count}</td>
                    <td>${str.username}</td>
                    <td>${str.password}</td>
                    <td>${str.trueName}</td>
                    <td><button>修改</button><button>删除</button></td>
                </tr>
            </c:forEach>
        </table>
    </form>
        <%--分页工具条    --%>
    <div style="margin-left: 33%;">
        <nav aria-label="Page navigation">
            <ul class="pagination">
                <li>
                    <a href="#" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
                <li><a href="#">1</a></li>
                <li><a href="#">2</a></li>
                <li><a href="#">3</a></li>
                <li><a href="#">4</a></li>
                <li><a href="#">5</a></li>
                <li>
                    <a href="#" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
                <span style="font-size: 15px;margin-left:10px;">共520条记录,共5页</span>
            </ul>
        </nav>
    </div>
</div>
<div class="container2">

</div>
</body>
</html>
