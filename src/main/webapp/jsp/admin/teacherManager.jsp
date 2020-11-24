<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>教室管理</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/admin/teacherManager.css">
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <link rel="icon"  sizes="32x32" href="${pageContext.request.contextPath}/img/systemIcon.png"/>
    <link rel="apple-touch-icon"  sizes="32x32" href="${pageContext.request.contextPath}/img/systemIcon.png"/>

    <script>
        function deleteTeacher(id) {
            if (confirm("是否确定删除？")) {
                location.href = "${pageContext.request.contextPath}/deleteTeacherServlet?id=" + id;
            }
        }
    </script>
</head>
<body style="background:url('${pageContext.request.contextPath}/img/background.jpg') no-repeat;background-size: 100%;">
<div class="container1">
    <div class="logo">
        <img src="${pageContext.request.contextPath}/img/systemIcon.png" class="img-circle">
        <p>上机考试系统</p>
    </div>
    <div class="nav1">
        <nav class="navbar navbar-default" role="navigation">
            <div class="container-fluid">
                <div>
                    <!--向左对齐-->
                    <ul class="nav navbar-nav navbar-left">
                        <li role="presentation" ><a href="${pageContext.request.contextPath}/returnHomeServlet" >首页</a></li>
                        <li role="presentation" ><a href="${pageContext.request.contextPath}/teacherManagerServlet" >教师管理</a></li>
                        <li role="presentation" ><a href="${pageContext.request.contextPath}/clearExamServlet" >考试清理</a></li>
                        <li role="presentation" ><a href="${pageContext.request.contextPath}/configServlet" >系统配置</a></li>
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

<div class="container2">
    <%--添加联系人、删除选中--%>
    <div style="float:right; margin-bottom: 10px">
        <a href="${pageContext.request.contextPath}/jsp/admin/addTeacher.jsp">
            <button class="btn btn-default" type="submit">添加教师</button>
        </a>
        <button class="btn btn-default" type="submit">删除选中</button>
        <button class="btn btn-default" type="submit">批量导入</button>
    </div>
    <%--用户信息表--%>
    <form>
        <table class="table table-bordered table-hover">
            <tr class="tableHead">
                <td><input type="checkbox"></td>
                <td>编号</td>
                <td>用户名</td>
                <td>密码</td>
                <td>真实名字</td>
                <td>是否为管理员</td>
                <td>操作</td>
            </tr>

            <c:forEach items="${pb.list}" var="teacher" varStatus="s">
                <tr>
                    <td><input type="checkbox"></td>
                    <td>${s.count}</td>
                    <td>${teacher.username}</td>
                    <td>${teacher.password}</td>
                    <td>${teacher.teacherName}</td>
                    <td>
                        <c:if test="${teacher.isAdmin == 1}">是</c:if>
                        <c:if test="${teacher.isAdmin == 0}">否</c:if>
                    </td>
                    <td><a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/getTeacherServlet?id=${teacher.id}">修改</a>&nbsp;
                        <a class="btn btn-default btn-sm" href="javascript:deleteTeacher(${teacher.id})">删除</a></td>
                </tr>
            </c:forEach>
        </table>
    </form>
        <%--分页工具条    --%>
<%--    <div style="margin-left: 33%;">--%>
    <div>
        <nav aria-label="Page navigation">
            <ul class="pagination">
                <li>
                    <a href="${pageContext.request.contextPath}/teacherManagerServlet?currentPage=${pb.currentPage - 1}&rows=5" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
                <c:forEach begin="1" end="${pb.totalPage}" var="i">
                    <li><a href="${pageContext.request.contextPath}/teacherManagerServlet?currentPage=${i}&rows=5">${i}</a></li>
                </c:forEach>
                <li>
                    <a href="${pageContext.request.contextPath}/teacherManagerServlet?currentPage=${pb.currentPage + 1}&rows=5" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
                <span style="font-size: 20px; margin-left: 8px;">
                    共${pb.totalCount}条记录，共${pb.totalPage}页
                </span>
            </ul>
        </nav>
    </div>
</div>
<div class="container2">

</div>
</body>
</html>
