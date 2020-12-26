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

    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link href="${pageContext.request.contextPath}/css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">

    <link rel="icon"  sizes="32x32" href="${pageContext.request.contextPath}/img/systemIcon.png"/>
    <link rel="apple-touch-icon"  sizes="32x32" href="${pageContext.request.contextPath}/img/systemIcon.png"/>
</head>
<body style="background:url('${pageContext.request.contextPath}/img/background.jpg') no-repeat;background-size: 100%;">

<jsp:include page="head.jsp" />
<div class="panel panel-default"  style="margin:60px 78px 50px 85px;background: border-box;"> <%-- 修改面板背景颜色--%>
    <div class="panel-body" style="margin-bottom: 30px;">

<div class="container2" style="margin-top: 60px;">
    <form class="form-inline" action="${pageContext.request.contextPath}/teacherAddExamServlet" method="post">
        <input type="hidden" name="username" value="${sessionScope.teacher.username}">
        <div class="form-group">
            <label for="examName">考试名称:</label>
            <input type="text" class="form-control" id="examName" name="examName" placeholder="请输入考试名称">
        </div>
        &ensp;
        <div class="form-group">
            <label for="examStartTime" >考试时间:</label>
            <div class="input-group date form_datetime col-md-5" data-link-field="examStartTime">
                <input class="form-control" size="50" type="text" value="" style="font-size: 16px" readonly>
                <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
            </div>
            <input type="hidden" id="examStartTime" name="examStartTime" value="" />
            &ensp;&ensp;
            <div class="checkbox" >
                <label>
                    <input type="checkbox" name="isAutoStart"> 是否自动开始
                </label>
            </div>
            &ensp;&ensp;
            <button type="submit" class="btn btn-default">创建</button>
        </div>
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
                <td>${sessionScope.teacher.teacherName}</td>
                <td>
                    <c:if test="${exam.isPageExist == 1}">
                        <img src="${pageContext.request.contextPath}/img/yes.png" style="width: 25px; height: 25px;">
                    </c:if>
                </td>
                <td>
                    <c:if test="${exam.isAutoStart == 1}">
                        <img src="${pageContext.request.contextPath}/img/yes.png" style="width: 25px; height: 25px;">
                    </c:if>
                </td>
                <td>
                    <c:if test="${exam.isStarting == 1}">
                        <img src="${pageContext.request.contextPath}/img/yes.png" style="width: 25px; height: 25px;">
                    </c:if>
                </td>
                <td>
                    <c:if test="${exam.isFinished == 1}">
                        <img src="${pageContext.request.contextPath}/img/yes.png" style="width: 25px; height: 25px;">
                    </c:if>
                </td>
                <td>
                    <c:if test="${exam.isFiled == 1}">
                        <img src="${pageContext.request.contextPath}/img/yes.png" style="width: 25px; height: 25px;">
                    </c:if>
                </td>
                <td>
                    <c:if test="${exam.isCleaned == 1}">
                        <img src="${pageContext.request.contextPath}/img/yes.png" style="width: 25px; height: 25px;">
                    </c:if>
                </td>
                <td>
                    <c:if test="${exam.isStarting == 0}">
                        <a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/teacherGetExamServlet?id=${exam.id}">编辑</a>
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
                        <a href="${pageContext.request.contextPath}/teacherBeforeExamManagerServlet?currentPage=1" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </c:if>
                    <c:if test="${pb.currentPage != 1}">
                        <a href="${pageContext.request.contextPath}/teacherBeforeExamManagerServlet?currentPage=${pb.currentPage - 1}" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </c:if>
                </li>
                <c:forEach begin="1" end="${pb.totalPage}" var="i">
                    <li><a href="${pageContext.request.contextPath}/teacherBeforeExamManagerServlet?currentPage=${i}">${i}</a></li>
                </c:forEach>
                <li>
                    <c:if test="${pb.currentPage == pb.totalPage}">
                        <a href="${pageContext.request.contextPath}/teacherBeforeExamManagerServlet?currentPage=${pb.currentPage}" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </c:if>
                    <c:if test="${pb.currentPage != pb.totalPage}">
                        <a href="${pageContext.request.contextPath}/teacherBeforeExamManagerServlet?currentPage=${pb.currentPage + 1}" aria-label="Next">
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

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js" charset="UTF-8"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap-datetimepicker.js" charset="UTF-8"></script>
<script type="text/javascript">
    $('.form_datetime').datetimepicker({
        format: "yyyy-MM-dd hh:ii",
        autoclose: true,
        todayBtn: true,
        minuteStep: 10,
        minView:0,
        pickerPosition:'bottom-left',
        language:'zh-CN',
        startDate: new Date()
    });
</script>
    </div>
</div>
</body>
</html>
