<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>编辑考试</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="${pageContext.request.contextPath}/css/teacher/head.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/teacher/updateExam.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <link rel="icon"  sizes="32x32" href="${pageContext.request.contextPath}/img/systemIcon.png"/>
    <link rel="apple-touch-icon"  sizes="32x32" href="${pageContext.request.contextPath}/img/systemIcon.png"/>

    <link rel="icon"  sizes="32x32" href="${pageContext.request.contextPath}/img/systemIcon.png"/>
    <link rel="apple-touch-icon"  sizes="32x32" href="${pageContext.request.contextPath}/img/systemIcon.png"/>
</head>
<body style="background:url('${pageContext.request.contextPath}/img/background.jpg') no-repeat;background-size: 100%;">
<div class="container2">
    <div class="updateExam">
        <form class="form-horizontal">
            <div class="firstLine"><h3>编辑考试信息</h3></div>

            <div class="form-group">
                <label for="examName" class="col-sm-2 control-label">考试名称:</label>
                <div class="col-sm-10">
                    <input type="email" class="form-control" id="examName" placeholder="考试名称">
                </div>
            </div>

            <div class="form-group">
                <label for="examStartTime" class="col-sm-2 control-label">考试时间:</label>
                <div class="col-sm-10">
                    <input type="datetime-local" class="form-control" id="examStartTime" placeholder="考试开始时间">
                </div>
            </div>

            <div class="form-group">
                <div class="checkboxDiv">
                    <input type="checkbox"> 是否自动开始
                </div>
            </div>

            <div class="form-group">
                <div class="buttonDiv">
                    <button type="submit" class="btn btn-default btn-lg">修改</button>
                </div>
            </div>
        </form>
    </div>
    <hr>

    <div class="uploadPage">
        <div class="firstLine"><h3>上传试卷</h3></div>
        <div>
            <input class="btn btn-default" type="button" value="选择文件">
            <label class="textLabel"></label>
            <input class="btn btn-default" type="button" value="上传">
        </div>
    </div>
    <hr>

    <div class="addStudents">
        <div class="firstLine"><h3>添加学生名单</h3></div>
        <div>
            <label class="textLabel">目前设定参加考试的人数是？？人</label> <br>
            <input class="btn btn-default" type="button" value="继续导入">
        </div>
    </div>
    <hr>

    <div class="option">
        <div class="btn-group" role="group" aria-label="...">
            <button type="button" class="btn btn-default btn-lg">开始考试</button>
            <button type="button" class="btn btn-default btn-lg">返回</button>
        </div>
    </div>
</div>
</body>
</html>
