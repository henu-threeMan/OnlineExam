<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>解除锁定</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="${pageContext.request.contextPath}/css/teacher/head.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/teacher/unlockStudent.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <link rel="icon"  sizes="32x32" href="${pageContext.request.contextPath}/img/systemIcon.png"/>
    <link rel="apple-touch-icon"  sizes="32x32" href="${pageContext.request.contextPath}/img/systemIcon.png"/>
</head>
<body style="background:url('${pageContext.request.contextPath}/img/background.jpg') no-repeat;background-size:100% 100%;">

<jsp:include page="head.jsp" />

<div class="container2">
    <div class="display_findStudent" style="border: 1px solid white;">
        <div class="div_findStudent">
            <label>按照学生查找已登录信息</label>
            <form class="form-inline" action="${pageContext.request.contextPath}/findStudentServlet" method="post">
                <div class="form-group">
                    <label class="sr-only" for="searchSno">学号</label>
                    <input type="text" class="form-control" id="searchSno" name="sno" placeholder="学号">
                </div>
                <div class="form-group">
                    <label class="sr-only" for="searchName">姓名</label>
                    <input type="text" class="form-control" id="searchName" name="studentName" placeholder="姓名">
                </div>
                <div class="form-group">
                    <label class="sr-only" for="searchClass">班级</label>
                    <input type="text" class="form-control" id="searchClass" name="className" placeholder="班级">
                </div>
                <button type="submit" class="btn btn-default">查找</button>
            </form>
        </div>
    </div>

    <div class="display_findStudentByIp" style="border: 1px solid white;">
        <div class="div_findStudentByIp">
            <label>按照IP地址查找已登录信息</label>
            <form class="form-inline" action="${pageContext.request.contextPath}/findStudentByIpServlet" method="post">
                <div class="form-group">
                    <label class="sr-only" for="searchIP">IP</label>
                    <input type="text" class="form-control" id="searchIP" name="ip" placeholder="IP地址">
                </div>
                <button type="submit" class="btn btn-default">查找</button>
            </form>
        </div>
    </div>

    <div class="display_foundStudent" style="border: 1px solid white;">
        <div class="div_foundStudent">
            <label>查询结果</label>
            <table class="table table-bordered table-hover" style="color: white">
                <tr class="tableHead">
                    <td>学号</td>
                    <td>姓名</td>
                    <td>班级</td>
                    <td>IP</td>
                    <td>操作</td>
                </tr>
                <c:if test="${foundStudent != null}">
                    <tr>
                        <td>${foundStudent.sno}</td>
                        <td>${foundStudent.studentName}</td>
                        <td>${foundStudent.className}</td>
                        <td>${foundStudent.ip}</td>
                        <td>
                            <c:if test="${foundStudent.ip != null}">
                                <a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/unlockStudentByIpServlet?sno=${foundStudent.sno}">解除锁定</a>
                            </c:if>
                        </td>
                    </tr>
                </c:if>
            </table>
        </div>
    </div>
</div>


</body>

</body>
</html>
