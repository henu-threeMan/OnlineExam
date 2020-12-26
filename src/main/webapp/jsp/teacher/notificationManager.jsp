<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>通知管理</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="${pageContext.request.contextPath}/css/teacher/head.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/teacher/notificationManager.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <link rel="icon"  sizes="32x32" href="${pageContext.request.contextPath}/img/systemIcon.png"/>
    <link rel="apple-touch-icon"  sizes="32x32" href="${pageContext.request.contextPath}/img/systemIcon.png"/>

    <script>
        function deleteNotification(index) {
            if (confirm("是否确定删除？")) {
                location.href = "${pageContext.request.contextPath}/deleteNotificationServlet?index=" + index;
            }
        }
    </script>
</head>
<body style="background:url('${pageContext.request.contextPath}/img/background.jpg') no-repeat;background-size: 100%;">
<jsp:include page="head.jsp" />
<div id="div2" class="panel panel-default">
    <div class="panel-body">
        <h3>新增通知消息</h3>
        <form role="form" action="${pageContext.request.contextPath}/addNotificationServlet" method="post">
            <div class="form-group" style="padding-left:15%;width: 850px;">
                <textarea class="form-control" name="newNotification" rows="1"></textarea>
            </div>
            <button type="submit" class="btn btn-default">添加</button>
        </form>
    </div>
</div>
<div id="div3" class="panel panel-default">
    <h3 style="margin-left: 15px">已有通知</h3>
    <table class="table table-bordered" style="color: white; width:970px; margin-left:15px; margin-right:10px; border:1px solid white; margin-bottom: 20px;">
        <thead>
        <tr>
            <th>通知内容</th>
            <th class="th1">操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${applicationScope.notificationList}" var="notification" varStatus="s">
            <tr>
                <td>${notification}</td>
                <td>
                    <a class="btn btn-default btn-sm" href="javascript:deleteNotification(${s.index})">删除</a>
                </td>
            </tr>
        </c:forEach>
    </table>

</div>
</body>
</html>
