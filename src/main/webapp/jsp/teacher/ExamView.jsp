<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>考试概况</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="${pageContext.request.contextPath}/css/teacher/head.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <link rel="icon"  sizes="32x32" href="${pageContext.request.contextPath}/img/systemIcon.png"/>
    <link rel="apple-touch-icon"  sizes="32x32" href="${pageContext.request.contextPath}/img/systemIcon.png"/>

    <link rel="icon"  sizes="32x32" href="${pageContext.request.contextPath}/img/systemIcon.png"/>
    <link rel="apple-touch-icon"  sizes="32x32" href="${pageContext.request.contextPath}/img/systemIcon.png"/>
    <style>
        #div1{
            margin-top:60px;
            margin-left: 100px;
            margin-right:150px;

        }
    </style>
</head>
<body style="background:url('${pageContext.request.contextPath}/img/background.jpg') no-repeat;background-size: 100%;">
<jsp:include page="head.jsp" />
<div  id="div1" class="panel panel-default">
    <div class="panel-heading">
        <h3 class="panel-title">{考试名}进行情况</h3>
    </div>
    <div class="panel-body">
        <p>参加考试总人数：{人数}</p>
        <p>已登录学生数量：{人数}，未登录学生数量：{人数}</p>
        <p>已登录学生中，提交文件学生数量：{人数}，未提交文件学生数量：{人数}</p>
    </div>
</div>
</body>
</html>
