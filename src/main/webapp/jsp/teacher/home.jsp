<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>教师首页</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="${pageContext.request.contextPath}/css/teacher/head.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/teacher/home.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <link rel="icon"  sizes="32x32" href="${pageContext.request.contextPath}/img/systemIcon.png"/>
    <link rel="apple-touch-icon"  sizes="32x32" href="${pageContext.request.contextPath}/img/systemIcon.png"/>

    <link rel="icon"  sizes="32x32" href="${pageContext.request.contextPath}/img/systemIcon.png"/>
    <link rel="apple-touch-icon"  sizes="32x32" href="${pageContext.request.contextPath}/img/systemIcon.png"/>
</head>
<body style="background:url('${pageContext.request.contextPath}/img/background.jpg') no-repeat;background-size:100% 100%;">

<jsp:include page="head.jsp" />

<div class="container2">
    <div>
        <strong>考前操作</strong>
        <br/>
        <br/>
        <ul>
            <li>可以新建考试：指定考试名称、开始时间等</li>
            <li>可以编辑自己创建的、未开始的考试，除了修改考试信息还可以:</li>
            <ul>
                &ensp;<li>上传试卷</li>
                &ensp;<li>学生名单导入</li>
                &ensp;<li>开启考试</li>
            </ul>
        </ul>
    </div>
    <div class = "container2_center">
        <strong>考中管理</strong>
        <br/>
        <br/>
        <ul>
            <li>可以查看考试情况</li>
            <li>可以管理学生信息，手工添加个别学生信息</li>
            <li>可以解除学生登录锁定</li>
            <li>可以添加或删除通知消息</li>
        </ul>
    </div>
    <div>
        <strong>考后操作</strong>
        <br/>
        <br/>
        <ul>
            <li>主考教师(考试创建者)可以结束考试</li>
            <li>主考教师可以打包下载学生提交文件</li>
            <li>主考教师可以导出提交信息</li>
            <li>如果管理员设置，主考教师可以清理和删除考试</li>
        </ul>
    </div>
</div>
</body>
</html>
