<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
</head>
<body style="background:url('${pageContext.request.contextPath}/img/background.jpg') no-repeat;background-size: 100%;">

<jsp:include page="head.jsp" />

<div class="display panel panel-default" style="background-color: rgba(112,128,144,0.5); width: 70%; margin-left: 15%;">
    <div class="panel-body" style="width: 84%; margin-left: 8%; color: white">
        <h3 style="text-align: center">修改系统配置</h3><br>
        <form class="form-horizontal" action="${pageContext.request.contextPath}/updateConfigServlet" method="post">
            <div class="form-group">
                <label for="aPeriod" class="col-sm-2 control-label">后台任务间隔时间</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="aPeriod" name="period" value="${applicationScope.config.period}"> <br>
                    <label>（指定扫描考试信息的间隔时间，单位为分钟）</label>
                </div>
            </div>
            <br>
            <div class="form-group">
                <label for="aRows" class="col-sm-2 control-label">分页查询记录条数</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="aRows" name="rows" value="${applicationScope.config.rows}"> <br>
                    <label>（指定分页查询时分页显示记录数的默认值）</label>
                </div>
            </div>
            <br>
            <div class="form-group">
                <label for="aInterval" class="col-sm-2 control-label">手动开启考试时间阈值</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="aInterval" name="interval" value="${applicationScope.config.interval}"> <br>
                    <label>（指定手工开启考试时允许的最大提前量，单位为分钟）</label>
                </div>
            </div>
            <br>
            <div class="form-group">
                <label for="lowerLimit" class="col-sm-2 control-label">上传文件字节数下限</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="lowerLimit" name="lowerLimit" value="${applicationScope.config.lowerLimit}" > <br>
                    <label>（指定上传文件的长度下限（字节），低于此值时发出警告）</label>
                </div>
            </div>
            <br>
            <div class="form-group">
                <label for="upperLimit" class="col-sm-2 control-label">上传文件字节数上限</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="upperLimit" name="upperLimit" value="${applicationScope.config.upperLimit}" > <br>
                    <label>（指定上传文件的长度上限（字节），高于此值时发出警告）</label>
                </div>
            </div>
            <br>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <div class="checkbox">
                        <label>
                            <c:if test="${applicationScope.config.teacherAuthority == 1}">
                                <input type="checkbox" name="teacherAuthority" checked> 教师可以清理和删除考试
                            </c:if>
                            <c:if test="${applicationScope.config.teacherAuthority == 0}">
                                <input type="checkbox" name="teacherAuthority"> 教师可以清理和删除考试
                            </c:if>
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
