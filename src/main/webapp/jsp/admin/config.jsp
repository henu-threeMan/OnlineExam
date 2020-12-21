<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>系统配置</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="${pageContext.request.contextPath}/css/admin/head.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/admin/config.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <link rel="icon"  sizes="32x32" href="${pageContext.request.contextPath}/img/systemIcon.png"/>
    <link rel="apple-touch-icon"  sizes="32x32" href="${pageContext.request.contextPath}/img/systemIcon.png"/>

    <link rel="icon"  sizes="32x32" href="${pageContext.request.contextPath}/img/systemIcon.png"/>
    <link rel="apple-touch-icon"  sizes="32x32" href="${pageContext.request.contextPath}/img/systemIcon.png"/>
<style>
    .form-control{
        width: 85%;
    }
</style>
</head>
<body style="background:url('${pageContext.request.contextPath}/img/background.jpg') no-repeat;background-size: 100%;">

<jsp:include page="head.jsp" />



<div id="display" class="panel panel-default"  style="width: 1100px; margin-left: 16%;">
    <div class="panel-body" style="margin-left: 70px;">
        <h3 style="text-align: center">修改系统配置</h3><br>
        <form class="form-horizontal">
            <div class="form-group">
                <label for="period" class="col-sm-2 control-label">后台任务间隔时间</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="period" name="period" value="" >
                </div>
            </div>
            <br>
            <div class="form-group">
                <label for="rows" class="col-sm-2 control-label">分页查询记录条数</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="rows" name="rows" value="">
                </div>
            </div>
            <br>
            <div class="form-group">
                <label for="interval" class="col-sm-2 control-label">手动开启考试时间阈值</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="interval" name="interval" value="">
                </div>
            </div>
            <br>
            <div class="form-group">
                <label for="lowerLimit" class="col-sm-2 control-label">上传文件字节数下限</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="lowerLimit" name="lowerLimit" value="" >
                </div>
            </div>
            <br>
            <div class="form-group">
                <label for="upperLimit" class="col-sm-2 control-label">上传文件字节数上限</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="upperLimit" name="upperLimit" value="" >
                </div>
            </div>
            <br>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <div class="checkbox">
                        <label>
                            <input type="checkbox" cheeck> 教师可以清理和删除考试
                        </label>
                    </div>
                </div>
            </div>
            <br>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-default" style="margin-left: 38%;">修改</button>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>
