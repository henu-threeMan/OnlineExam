<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>编辑考试</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="${pageContext.request.contextPath}/css/teacher/head.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/teacher/updateExam.css" rel="stylesheet">

    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link href="${pageContext.request.contextPath}/css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">

    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/teacher/updateExam1.css">
    <link rel="icon"  sizes="32x32" href="${pageContext.request.contextPath}/img/systemIcon.png"/>
    <link rel="apple-touch-icon"  sizes="32x32" href="${pageContext.request.contextPath}/img/systemIcon.png"/>

    <link rel="icon"  sizes="32x32" href="${pageContext.request.contextPath}/img/systemIcon.png"/>
    <link rel="apple-touch-icon"  sizes="32x32" href="${pageContext.request.contextPath}/img/systemIcon.png"/>
</head>
<body style="background:url('${pageContext.request.contextPath}/img/background.jpg') no-repeat;background-size: 100%;">

<jsp:include page="head.jsp" />

<div class="container2">
    <div class="display">
        <div class="updateExam">
            <form class="form-horizontal" action="${pageContext.request.contextPath}/teacherUpdateExamServlet" method="post">
                <div class="firstLine"><h3>编辑考试信息</h3></div>
                <input type="hidden" name="username" value="${username}">
                <input type="hidden" name="id" value="${exam.id}">

                <div class="form-group">
                    <label for="examName" class="col-sm-2 control-label">考试名称:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="examName" name="examName" value="${exam.examName}">
                    </div>
                </div>

                <div class="form-group">
                    <label for="examStartTime" class="col-sm-2 control-label">考试时间:</label>
                    <div class="input-group date form_datetime col-sm-10" data-link-field="examStartTime">
                        <input class="form-control" size="50" id="startTime" type="text" value="${exam.startTime}" style="font-size: 16px" readonly>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                    </div>
                    <input type="hidden" id="examStartTime" name="examStartTime" value="" />
                </div>

                <div class="form-group">
                    <div class="checkboxDiv">
                        <c:if test="${exam.isAutoStart == 1}">
                            <input type="checkbox" name="isAutoStart" checked> 是否自动开始
                        </c:if>
                        <c:if test="${exam.isAutoStart == 0}">
                            <input type="checkbox" name="isAutoStart"> 是否自动开始
                        </c:if>
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
            <div class="firstLine" ><h3>上传试卷</h3></div>
            <form action="${pageContext.request.contextPath}/TestUploadServlet" enctype="multipart/form-data" method="post">
                <input id="uploadBtn" class="btn btn-default" name="button"  type="button" value="点击上传"><span id="upload_msg">请选择文件</span>
                <input id="fileSelection" name="choseFile"  type="file">
            </form>
        </div>
        <hr>

        <div class="addStudents">
            <div class="firstLine"><h3>添加学生名单</h3></div>
            <div>
                <label class="textLabel2">目前设定参加考试的人数是？？人</label> <br>
                <a class="btn btn-default" type="button" href="${pageContext.request.contextPath}/studentManagerServlet?username=${username}&exam=${exam.id}&currentPage=1&rows=5">继续导入</a>
            </div>
        </div>
        <hr>

        <div class="option">
            <div class="btn-group" role="group" aria-label="...">
                <a href="${pageContext.request.contextPath}/teacherStartExamServlet?username=${username}&id=${exam.id}" class="btn btn-default btn-lg">开始考试</a>
                <button type="button" class="btn btn-default btn-lg btn_back">返回</button>
            </div>
        </div>

        <c:if test="${startExam_msg != null}">
            <div class="alert alert-warning alert-dismissible" role="alert">
                <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <strong>${startExam_msg}</strong>
            </div>
        </c:if>
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

    $('.btn_back').on("click", function () {
        ${startExam_msg = null}
        window.location.href = "${pageContext.request.contextPath}/teacherBeforeExamManagerServlet?username=${username}&currentPage=1&rows=5";
    });

</script>

</body>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script>
    $("#fileSelection").change(function () {
        $("#upload_msg").html("上传成功！");
        $("#upload_msg").css("color","green")
    })
</script>
</html>
