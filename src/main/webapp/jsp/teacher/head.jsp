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
                        <li role="presentation"><a href="${pageContext.request.contextPath}/teacherBeforeExamManagerServlet?currentPage=1">考前管理</a></li>
                        <li role="presentation" class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">考中管理<span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="${pageContext.request.contextPath}/examViewServlet">考试概况</a></li>
                                <li><a href="${pageContext.request.contextPath}/jsp/teacher/studentManager.jsp">学生信息</a></li>
                                <li><a href="${pageContext.request.contextPath}/jsp/teacher/unlockStudent.jsp">解除锁定</a></li>
                                <li><a href="${pageContext.request.contextPath}/jsp/teacher/notificationManager.jsp">通知管理</a></li>
                            </ul>
                        </li>
                        <li role="presentation"><a href="${pageContext.request.contextPath}/teacherAfterExamManagerServlet?currentPage=1">考后管理</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a>欢迎,${teacher.username}</a></li>
                        <li><a href="#" data-toggle="modal"
                               data-target=".bs-example-modal-sm"><i
                                class="icon-pencil icon-white"></i>修改口令</a></li>
                        <li><a href="${pageContext.request.contextPath}/logoutServlet">退出</a></li>
                    </ul>
                </div>
            </div>
        </nav>
    </div>
    <div class="modal fade bs-example-modal-sm span3" tabindex="-1" role="dialog"
         aria-labelledby="mySmallModalLabel">
        <div class="modal-dialog modal-sm">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"
                            aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                    <h4 class="modal-title">修改口令</h4>
                </div>
                <div class="modal-body">
                    <form class="exam-form" action="${pageContext.request.contextPath}/teacher_updateMessageServlet" method="post">
                        <p>
                            <input type="password" name="oldpass" placeholder="原口令" style="width:100%"/>
                            <br/>
                            <input type="password" name="newpass1" placeholder="新口令" style="width:100%"/>
                            <br/>
                            <input type="password" name="newpass2" placeholder="重输新口令" style="width:100%"/>
                            <br/>
                            <input type="submit" class="btn btn-primary" value="修改" style="width:100%"/>
                        </p>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
