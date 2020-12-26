<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.io.File" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>student_home</title>

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
<body style="background:url('${pageContext.request.contextPath}/img/background.jpg') no-repeat;background-size: 100%;">

<jsp:include page="head.jsp" />

<div style="margin-left: 90px; margin-right: 100px; color: white">

<div class="row">
    <h2><img src="${pageContext.request.contextPath}/img/examing1.png" class="img-circle">&nbsp;&nbsp;考试编号 上机考试进行中...</h2>
</div>
    <div class="panel panel-default"  style="margin-top: 20px;background: border-box;"> <%-- 修改面板背景颜色--%>
        <div class="panel-body" style="margin-bottom: 30px;">
            <div class="container" style="color: white; margin-left: 40px;">
                <div class="row">
                    <div class="col-sm-6">
                        <h3>试卷下载</h3><br>
                        <div>
                            <a class="btn btn-default" type="button" href="${pageContext.request.contextPath}/downloadTestServlet">下载试卷</a>
                        </div>

                        <div style="margin-top: 80px;">
                            <form  class="form-inline" action="${pageContext.request.contextPath}/answerUploadServlet" enctype="multipart/form-data" method="post">
                                <h3>答案上传</h3><br>
                                <p >请按照考试要求将答案打包，再次进行上传。同名文件多次上传将会覆盖。</p>
                                <div class="form-group">
                                    <input name="chosefile" type="file" id="inputfile">
                                </div>
                                <input name="submit" type="submit" class="btn btn-default">
                            </form>
                        </div>
                    </div>

                    <div class="col-sm-6">
                        <div>
                            <table class="table table-bordered" style="color: white">
                                <tr>
                                    <th>文件名</th>
                                    <th>文件大小</th>
                                    <th>上传时间</th>
                                </tr>
                                <p class="submitList">提交列表</p>
                                <c:forEach items="${sessionScope.answerList}" var="answer" varStatus="s">
                                    <tr>
                                        <td>${answer.name}</td>
                                        <td>${answer.length()}b</td>
                                        <td><%=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(((File)pageContext.getAttribute("answer")).lastModified())%></td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </div>
                    </div>
                    </div>
                </div>
        </div>
    </div>
</div>
</body>
</html>
