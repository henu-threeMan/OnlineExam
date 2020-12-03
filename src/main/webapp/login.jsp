<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>上机考试系统</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/login.css" rel="stylesheet">
    <link rel="icon"  sizes="32x32" href="${pageContext.request.contextPath}/img/systemIcon.png"/>
    <link rel="apple-touch-icon"  sizes="32x32" href="${pageContext.request.contextPath}/img/systemIcon.png"/>
    <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</head>
<body style="background:url('${pageContext.request.contextPath}/img/background.jpg') no-repeat;background-size: 100%">
<div class="container" style="width: 40%;margin-top: 15%;background-color: rgba(112,128,144,0.5);padding-left: 5%">
    <h1 style="color:white;margin-left: 25%">欢迎登录</h1>
    <div id="user_option" style="margin:5% 20% 3% 0%">
        <ul class="nav nav-tabs">
            <li role="presentation" class="active"><a href="#admin" data-toggle="tab">管理员</a></li>
            <li role="presentation" ><a href="#teacher" data-toggle="tab">教师</a></li>
            <li role="presentation" ><a href="#student" data-toggle="tab">学生</a></li>
        </ul>
    </div>

    <div id="user_message" class="tab-content">
        <div id="admin" class="tab-pane fade in active">
            <form method="post" action="${pageContext.request.contextPath}/loginServlet" class="form-horizontal">
                <input type="hidden" name="role" value="admin">
                <div class="form-group">
<%--                    <label for="adminUsername" class="col-sm-2 control-label">用户名:</label>--%>
                    <div class="col-sm-10">
                        <input name="username" type="text" class="form-control" id="adminUsername" placeholder="请输入用户名">
                    </div>
                </div>
                <div class="form-group">
<%--                    <label for="adminPassword" class="col-sm-2 control-label">密码:</label>--%>
                    <div class="col-sm-10">
                        <input name="password" type="password" class="form-control" id="adminPassword" placeholder="请输入密码">
                    </div>
                </div>
                <div class="form-group" >
                    <div class="col-sm-offset-0 col-sm-10" >
                        <div class="checkbox" >
                            <label>
                                <input type="checkbox">记住我
                            </label>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-4 col-sm-8">
                        <button type="submit" class="btn btn-default">登陆</button>
                    </div>
                </div>
            </form>
            <c:if test="${login_msg != null}">
                <div class="alert alert-warning alert-dismissible" role="alert">
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <strong>${login_msg}</strong>
                </div>
            </c:if>
        </div>
        <div id="teacher" class="tab-pane fade ">
            <form method="post" action="${pageContext.request.contextPath}/loginServlet" class="form-horizontal">
                <input type="hidden" name="role" value="teacher">
                <div class="form-group">
<%--                    <label for="teacherUsername" class="col-sm-2 control-label">用户名:</label>--%>
                    <div class="col-sm-10">
                        <input name="username" type="text" class="form-control" id="teacherUsername" placeholder="请输入用户名">
                    </div>
                </div>
                <div class="form-group">
<%--                    <label for="teacherPassword" class="col-sm-2 control-label">密码:</label>--%>
                    <div class="col-sm-10">
                        <input name="password" type="password" class="form-control" id="teacherPassword" placeholder="请输入密码">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-0 col-sm-10" >
                        <div class="checkbox">
                            <label>
                                <input type="checkbox">记住我
                            </label>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-4 col-sm-8">
                        <button type="submit" class="btn btn-default">登陆 </button>
                    </div>
                </div>
            </form>
            <c:if test="${login_msg != null}">
                <div class="alert alert-warning alert-dismissible" role="alert">
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <strong>${login_msg}</strong>
                </div>
            </c:if>
        </div>
        <div id="student" class="tab-pane fade ">
            <form method="post" action="${pageContext.request.contextPath}/loginServlet" class="form-horizontal">
                <input type="hidden" name="role" value="student">
                <div class="form-group">
<%--                    <label for="studentUsername" class="col-sm-2 control-label">用户名:</label>--%>
                    <div class="col-sm-10">
                        <input name="sno" type="text" class="form-control" id="studentUsername" placeholder="请输入用户名">
                    </div>
                </div>
                <div class="form-group">
<%--                    <label for="studentPassword" class="col-sm-2 control-label">密码:</label>--%>
                    <div class="col-sm-10">
                        <input name="password" type="password" class="form-control" id="studentPassword" placeholder="请输入密码">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-0 col-sm-10">
                        <div class="checkbox">
                            <label>
                                <input type="checkbox">记住我
                            </label>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-4 col-sm-8">
                        <button type="submit" class="btn btn-default">登陆</button>
                    </div>
                </div>
            </form>
            <c:if test="${login_msg != null}">
                <div class="alert alert-warning alert-dismissible" role="alert">
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <strong>${login_msg}</strong>
                </div>
            </c:if>

        </div>
    </div>
</div>
</body>
</html>
