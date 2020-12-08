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
            margin-left: 100px;
            margin-right: 100px;
        }
    </style>
</head>
<body style="background:url('${pageContext.request.contextPath}/img/background.jpg') no-repeat;background-size: 100%;">
<jsp:include page="head.jsp" />
<div  id="div2" class="panel panel-default">
    <div class="panel-body">
        <h3>新增通知消息</h3>
        <form role="form">
            <div class="form-group">
                <textarea class="form-control" rows="1"></textarea>
                <button type="submit" class="btn btn-default">添加</button>
            </div>
        </form>
    </div>
</div>
<div>
    <h3>已有通知</h3>
    <table>
        <tr>
           <th>已有通知消息</th>
            <th>备注</th>
        </tr>
        <tr>
        </tr>
    </table>

</div>
</body>
</html>
