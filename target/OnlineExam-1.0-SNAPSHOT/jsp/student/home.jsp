<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>student_home</title>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="css/home.css">
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <link rel="icon"  sizes="32x32" href="${pageContext.request.contextPath}/img/systemIcon.jpg"/>
    <link rel="apple-touch-icon"  sizes="32x32" href="${pageContext.request.contextPath}/img/systemIcon.jpg"/>

</head>
<body style="background:url('${pageContext.request.contextPath}/img/background.jpg') no-repeat;background-size: 100%;">
<div class="container1">
    <div class="nav1">
        <nav class="navbar navbar-default" role="navigation">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">上机考试系统</a>
                </div>
                <div>
                    <!--向左对齐-->
                    <ul class="nav navbar-nav navbar-left">
                        <li role="presentation" ><a href="#"><span class="glyphicon glyphicon-home">首页</span></a></li>
                        <li role="presentation" ><a href="#"><span class="glyphicon glyphicon-eye-open">查看提交</span></a></li>

                    </ul>
                    <!--向右对齐-->
                    <ul class="nav navbar-nav navbar-right">
                        <li><a>欢迎,${username}</a></li>
                        <li><a href="${pageContext.request.contextPath}/logoutServlet">退出</a></li>
                    </ul>
                </div>
            </div>
        </nav>
    </div>
</div>


<div style="margin-left: 60px; margin-right: 100px; color: white">
<div class="row">
    <h2><img src="${pageContext.request.contextPath}/img/examing1.png" class="img-circle">&nbsp;&nbsp;考试编号 上机考试进行中...</h2>
</div>



<div class="container" style="color: white">
    <div class="row">
        <div class="col-sm-6">
            <h3>试卷下载</h3><br>
            <div>
                <a class="btn btn-default" type="button" href="${pageContext.request.contextPath}/downloadTestServlet">下载试卷</a>
            </div>

            <div style="margin-top: 100px;">
                <form  class="form-inline" action="${pageContext.request.contextPath}/answerUploadServlet" enctype="multipart/form-data" method="post">
                    <h3>答案上传</h3><br>
                    <p >请按照考试要求将答案打包，再次进行上传。同名文件多次上传将会覆盖。</p>
                    <div class="form-group">
                        <input name="chosefile" type="file" id="inputfile">
                    </div>
                    <input name="submit" type="submit" class="btn btn-default"></input>
                </form>
            </div>
        </div>

        <div class="clearfix visible-xs"></div>
        <div class="col-sm-6">
            <div>
                <table class="table table-bordered" style="color: white">
                    <caption style="color: white">已上传文件列表</caption>
                    <thead>
                    <tr>
                        <th>文件名</th>
                        <th>文件大小</th>
                        <th>上传时间</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>答案1</td>
                        <td>600Byte</td>
                        <td>2020-11-25 15:00:20</td>
                    </tr>
                    <tr>
                        <td>答案2</td>
                        <td>4MB</td>
                        <td>202011-25 15:00:10</td>
                    </tr>
                    <tr>
                        <td>答案2</td>
                        <td>4MB</td>
                        <td>202011-25 15:00:10</td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
        </div>
    </div>
</div>

</body>
</html>
