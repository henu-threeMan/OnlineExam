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
        <nav class="navbar navbar-default" role="navigation">
            <div class="container-fluid">
                <div>
                    <!--向左对齐-->
                    <ul class="nav navbar-nav navbar-left">
                        <li role="presentation" ><a href="${pageContext.request.contextPath}/jsp/admin/home.jsp">首页</a></li>
                        <li role="presentation" ><a href="${pageContext.request.contextPath}/teacherManagerServlet?currentPage=1" >教师管理</a></li>
                        <li role="presentation" ><a href="${pageContext.request.contextPath}/examManagerServlet?currentPage=1">考试清理</a></li>
                        <li role="presentation" ><a href="${pageContext.request.contextPath}/configServlet">系统配置</a></li>
                    </ul>
                    <!--向右对齐-->
                    <ul class="nav navbar-nav navbar-right">
                        <li><a>欢迎,${admin.username}</a></li>
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
                    <form class="exam-form" action="${pageContext.request.contextPath}/admin_updateMessageServlet" method="post">
                        <p>
                            <input type="password" name="oldpass" placeholder="原口令" style="width:100%"/>
                            <br><br>
                            <input type="password" name="newpass1" placeholder="新口令" style="width:100%"/>
                            <br><br>
                            <input type="password" name="newpass2" placeholder="重输新口令" style="width:100%"/>
                            <br><br>
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
