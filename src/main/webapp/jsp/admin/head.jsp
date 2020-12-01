<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>homeHead</title>
</head>
<body>
<div class="container1">
    <div class="logo">
        <img src="${pageContext.request.contextPath}/img/computer.png" class="img-circle">
        <p>上机考试系统</p>
    </div>
    <div class="nav1">
        <nav class="navbar navbar-default" role="navigation">
            <div class="container-fluid">
                <div>
                    <!--向左对齐-->
                    <ul class="nav navbar-nav navbar-left">
                        <li role="presentation" ><a href="${pageContext.request.contextPath}/jsp/admin/home.jsp">首页</a></li>
                        <li role="presentation" ><a href="${pageContext.request.contextPath}/teacherManagerServlet?currentPage=1&rows=5" >教师管理</a></li>
                        <li role="presentation" ><a href="${pageContext.request.contextPath}/clearExamServlet">考试清理</a></li>
                        <li role="presentation" ><a href="${pageContext.request.contextPath}/configServlet">系统配置</a></li>
                    </ul>
                    <!--向右对齐-->
                    <ul class="nav navbar-nav navbar-right">
                        <li><a>欢迎,${admin.username}</a></li>
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
