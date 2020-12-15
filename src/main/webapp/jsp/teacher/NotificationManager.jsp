<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>通知管理</title>
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
        #div2{
            margin-top: 30px;
            width: 1000px;
            text-align: center;
            margin-left: 18%;
        }
        #div3{
            margin-top: 30px;
            width: 1000px;
            margin-left: 18%;
        }
        .th1{
            width: 120px;
        }
    </style>
</head>
<body style="background:url('${pageContext.request.contextPath}/img/background.jpg') no-repeat;background-size: 100%;">
<jsp:include page="head.jsp" />
<div  id="div2" class="panel panel-default">
    <div class="panel-body">
        <h3>新增通知消息</h3>
        <form role="form">
            <div class="form-group" style="padding-left:15%;width: 850px;">
                <textarea class="form-control" rows="1"></textarea>
            </div>
            <button type="submit" class="btn btn-default">添加</button>
        </form>
    </div>
</div>
<div id = "div3" class="panel panel-default">
    <h3 style="margin-left: 15px">已有通知</h3>
    <table class="table table-bordered" style="width: 970px;margin-left: 15px;margin-right:10px;border:1px solid #5e5e5e;margin-bottom: 20px;">
        <thead>
        <tr>
            <th>通知内容</th>
            <th class="th1">操作</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>hello</td>
            <td>删除</td>
        </tr>
        <tr>
            <td>Mumbai</td>
            <td>删除</td>
        </tr>
    </table>

</div>
</body>
</html>
