<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>教师管理</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/admin/head.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/admin/teacherManage.css">
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

        window.onload = function () {
            document.getElementById("delSelect").onclick = function () {
                if (confirm("是否确定删除选中？")) {
                    var flag = false;
                    var checkboxes = document.getElementsByName("tid");
                    for (let i = 0; i < checkboxes.length; i++) {
                        if (checkboxes[i].checked) {
                            flag = true;
                            break;
                        }
                    }
                    if (flag) {
                        document.getElementById("form").submit();
                    }
                }
            }

            document.getElementById("firstCheckbox").onclick = function () {
                var checkboxes = document.getElementsByName("tid");
                for (var i = 0; i < checkboxes.length; i++) {
                    checkboxes[i].checked = this.checked;
                }
            }
        }
    </script>
</head>
<body style="background:url('${pageContext.request.contextPath}/img/background.jpg') no-repeat;background-size: 100%;">

<jsp:include page="head.jsp" />

<div class="container2">
    <%--添加联系人、删除选中--%>
        <div style="float:left; margin-bottom: 10px;">
            <form action="${pageContext.request.contextPath}/TeacherlistUploadServlet" enctype="multipart/form-data" method="post">
                <div class="form-group" style="float: left;">
                    <input class="btn btn-default" name="choseFile" type="file">
                </div> &ensp;
                <input class="btn btn-default" name="submit" type="submit" value="批量导入">
            </form>
        </div>

    <div style="float:right; margin-bottom: 10px">
        <a class="btn btn-default" href="${pageContext.request.contextPath}/jsp/admin/addTeacher.jsp">添加教师</a>
        <a class="btn btn-default" href="javascript:void(0);" id="delSelect">删除选中</a>
    </div>
    <%--用户信息表--%>
    <form id="form" action="${pageContext.request.contextPath}/delSelectedTeacherServlet" method="post">
        <table class="table table-bordered table-hover" style="color: white">
            <tr class="tableHead">
                <td><input type="checkbox" id="firstCheckbox"></td>
                <td>编号</td>
                <td>用户名</td>
                <td>真实名字</td>
                <td>是否为管理员</td>
                <td>操作</td>
            </tr>

            <c:forEach items="${pb.list}" var="teacher" varStatus="s">
                <tr>
                    <td><input type="checkbox" name="tid" value="${teacher.id}"></td>
                    <td>${s.count}</td>
                    <td>${teacher.username}</td>
                    <td>${teacher.teacherName}</td>
                    <td>
                        <c:if test="${teacher.isAdmin == 1}">
                            <img src="${pageContext.request.contextPath}/img/yes.png" style="width: 25px; height: 25px;">
                        </c:if>
                    </td>
                    <td>
                        <a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/getTeacherServlet?id=${teacher.id}">修改</a>&nbsp;
                        <a class="btn btn-danger btn-sm" href="javascript:deleteTeacher(${teacher.id})">删除</a>
                    </td>
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
                    <c:if test="${pb.currentPage == 1}">
                        <a href="${pageContext.request.contextPath}/teacherManagerServlet?currentPage=1" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </c:if>
                    <c:if test="${pb.currentPage != 1}">
                        <a href="${pageContext.request.contextPath}/teacherManagerServlet?currentPage=${pb.currentPage - 1}" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </c:if>
                </li>
                <c:forEach begin="1" end="${pb.totalPage}" var="i">
                    <li><a href="${pageContext.request.contextPath}/teacherManagerServlet?currentPage=${i}">${i}</a></li>
                </c:forEach>
                <li>
                    <c:if test="${pb.currentPage == pb.totalPage}">
                        <a href="${pageContext.request.contextPath}/teacherManagerServlet?currentPage=${pb.currentPage}" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </c:if>
                    <c:if test="${pb.currentPage != pb.totalPage}">
                        <a href="${pageContext.request.contextPath}/teacherManagerServlet?currentPage=${pb.currentPage + 1}" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </c:if>
                </li>
                <span style="font-size: 30px; margin-left: 8px;">
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

