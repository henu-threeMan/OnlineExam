<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>考前操作</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="${pageContext.request.contextPath}/css/teacher/head.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/teacher/beforeExam.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <link rel="icon"  sizes="32x32" href="${pageContext.request.contextPath}/img/systemIcon.png"/>
    <link rel="apple-touch-icon"  sizes="32x32" href="${pageContext.request.contextPath}/img/systemIcon.png"/>

    <link rel="icon"  sizes="32x32" href="${pageContext.request.contextPath}/img/systemIcon.png"/>
    <link rel="apple-touch-icon"  sizes="32x32" href="${pageContext.request.contextPath}/img/systemIcon.png"/>

    <script>
        function deleteExam(id) {
            if (confirm("是否确定删除？")) {
                location.href = "${pageContext.request.contextPath}/teacherDeleteExamServlet?id=" + id;
            }
        }
    </script>
</head>
<body style="background:url('${pageContext.request.contextPath}/img/background.jpg') no-repeat;background-size: 100%;">

<jsp:include page="head.jsp" />

<div class="container2">
    <form class="form-inline" action="${pageContext.request.contextPath}/teacherAddExamServlet" method="post">
<%--        <input type="hidden" name="owner" value="教师名称">--%>
        <div class="form-group">
            <label for="examName">考试名称:</label>
            <input type="text" class="form-control" id="examName" name="examName" placeholder="请输入考试名称">
        </div>
        &ensp;
        <div class="form-group">
            <label for="examStartTime">考试时间:</label>
            <input type="datetime-local" class="form-control" id="examStartTime" name="examStartTime" placeholder="格式：2000-12-12T00:00">
        </div>
        &ensp;
        <div class="checkbox">
            <label>
                <input type="checkbox" name="isAutoStart"> 是否自动开始
            </label>
        </div>
        &ensp;
        <button type="submit" class="btn btn-default">创建</button>
    </form>

    <hr>

    <table class="table table-bordered table-hover" style="color: white">
        <tr class="tableHead">
            <td>考试名称</td>
            <td>考试时间</td>
            <td>创建人</td>
            <td>上传试卷</td>
            <td>自动开始</td>
            <td>进行中</td>
            <td>已结束</td>
            <td>已归档</td>
            <td>已清理</td>
            <td>操作</td>
        </tr>

        <c:forEach items="${pb.list}" var="exam" varStatus="s">
            <tr>
                <td>${exam.examName}</td>
                <td>${exam.startTime}</td>
                <td>${exam.owner}</td>
                <td>
                    <c:if test="${exam.isPageExist == 1}">是</c:if>
                    <c:if test="${exam.isPageExist == 0}">否</c:if>
                </td>
                <td>
                    <c:if test="${exam.isAutoStart == 1}">是</c:if>
                    <c:if test="${exam.isAutoStart == 0}">否</c:if>
                </td>
                <td>
                    <c:if test="${exam.isStarting == 1}">是</c:if>
                    <c:if test="${exam.isStarting == 0}">否</c:if>
                </td>
                <td>
                    <c:if test="${exam.isFinished == 1}">是</c:if>
                    <c:if test="${exam.isFinished == 0}">否</c:if>
                </td>
                <td>
                    <c:if test="${exam.isFiled == 1}">是</c:if>
                    <c:if test="${exam.isFiled == 0}">否</c:if>
                </td>
                <td>
                    <c:if test="${exam.isCleaned == 1}">是</c:if>
                    <c:if test="${exam.isCleaned == 0}">否</c:if>
                </td>
                <td>
                    <a class="btn btn-default btn-sm" href="#">编辑</a>
                    <c:if test="${exam.isCleaned == 1}">
                        <a class="btn btn-default btn-sm" href="javascript:deleteExam(${exam.id})">删除</a>
                    </c:if>
                </td>
            </tr>
        </c:forEach>
    </table>
    <%--分页工具条    --%>
    <%--    <div style="margin-left: 33%;">--%>
    <div>
        <nav aria-label="Page navigation">
            <ul class="pagination">
                <li>
                    <c:if test="${pb.currentPage == 1}">
                        <a href="${pageContext.request.contextPath}/teacherExamManagerServlet?currentPage=1&rows=5" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </c:if>
                    <c:if test="${pb.currentPage != 1}">
                        <a href="${pageContext.request.contextPath}/teacherExamManagerServlet?currentPage=${pb.currentPage - 1}&rows=5" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </c:if>
                </li>
                <c:forEach begin="1" end="${pb.totalPage}" var="i">
                    <li><a href="${pageContext.request.contextPath}/teacherExamManagerServlet?currentPage=${i}&rows=5">${i}</a></li>
                </c:forEach>
                <li>
                    <c:if test="${pb.currentPage == pb.totalPage}">
                        <a href="${pageContext.request.contextPath}/teacherExamManagerServlet?currentPage=${pb.currentPage}&rows=5" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </c:if>
                    <c:if test="${pb.currentPage != pb.totalPage}">
                        <a href="${pageContext.request.contextPath}/teacherExamManagerServlet?currentPage=${pb.currentPage + 1}&rows=5" aria-label="Next">
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

</body>
</html>
