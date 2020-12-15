<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>head</title>
</head>
<body>
<div class="container1">
    <div class="logo">
        <img src="${pageContext.request.contextPath}/img/computer.png" class="img-circle">
        <p>上机考试系统</p>
    </div>
    <div class="nav1">
        <nav class="navbar navbar-default">
            <div class="container-fluid">
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li role="presentation"><a href="${pageContext.request.contextPath}/jsp/teacher/home.jsp">首页</a></li>
                        <li role="presentation"><a href="${pageContext.request.contextPath}/teacherBeforeExamManagerServlet?username=${teacher.username}&currentPage=1&rows=5">考前管理</a></li>
                        <li role="presentation" class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">考中管理<span class="caret"></span></a>
                            <ul class="dropdown-menu">
<<<<<<< HEAD
                                <li><a href="#">考试概况</a></li>
                                <li><a href="${pageContext.request.contextPath}/jsp/teacher/studentManager.jsp">学生信息</a></li>
                                <li><a href="${pageContext.request.contextPath}/jsp/teacher/unlockStudent.jsp">解除锁定</a></li>
                                <li><a href="#">通知管理</a></li>
=======
                                <li><a href="${pageContext.request.contextPath}/jsp/teacher/ExamView.jsp">考试概况</a></li>
                                <li><a href="${pageContext.request.contextPath}/jsp/teacher/studentManager.jsp">学生信息</a></li>
                                <li><a href="${pageContext.request.contextPath}/jsp/teacher/unlockStudent.jsp">解除锁定</a></li>
                                <li><a href="${pageContext.request.contextPath}/jsp/teacher/NotificationManager.jsp">通知管理</a></li>
>>>>>>> origin/master
                            </ul>
                        </li>
                        <li role="presentation"><a href="${pageContext.request.contextPath}/teacherAfterExamManagerServlet?currentPage=1&rows=5">考后管理</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a>欢迎,${teacher.username}</a></li>
                        <li><a>修改信息</a></li>
                        <li><a href="${pageContext.request.contextPath}/logoutServlet">退出</a></li>
                    </ul>
                </div>
            </div>
        </nav>
    </div>
</div>
</body>
</html>
