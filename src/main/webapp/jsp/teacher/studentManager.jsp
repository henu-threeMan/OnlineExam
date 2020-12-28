<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>学生管理</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="${pageContext.request.contextPath}/css/teacher/head.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/teacher/studentManager.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <link rel="icon"  sizes="32x32" href="${pageContext.request.contextPath}/img/systemIcon.png"/>
    <link rel="apple-touch-icon"  sizes="32x32" href="${pageContext.request.contextPath}/img/systemIcon.png"/>
</head>
<body style="background:url('${pageContext.request.contextPath}/img/background.jpg') no-repeat;background-size:100% 100%;">

<jsp:include page="head.jsp" />

<div class="container2">
    <div class="display_addStudent" style="border: 1px solid white;">
        <div class="div_addStudent">
            <label>添加单个学生</label>
            <form class="form-inline" action="${pageContext.request.contextPath}/addStudentServlet" method="post">
                <div class="form-group">
                    <label class="sr-only" for="sno">学号</label>
                    <input type="text" class="form-control" id="sno" name="sno" placeholder="学号">
                </div>
                <div class="form-group">
                    <label class="sr-only" for="name">姓名</label>
                    <input type="text" class="form-control" id="name" name="studentName" placeholder="姓名">
                </div>
                <div class="form-group">
                    <label class="sr-only" for="class">班级</label>
                    <input type="text" class="form-control" id="class" name="className" placeholder="班级">
                </div>
                <button type="submit" class="btn btn-default">添加</button>
            </form>
        </div>
    </div>

    <div class="display_findStudent" style="border: 1px solid white;">
        <div class="div_findStudent">
            <label>查找学生信息</label>
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

    <c:if test="${foundStudent != null}">
        <div class="display_foundStudent" style="border: 1px solid white;">
            <div class="div_foundStudent">
                <table class="table table-bordered table-hover" style="color: white">
                    <tr class="tableHead">
                        <td>学号</td>
                        <td>姓名</td>
                        <td>班级</td>
                    </tr>
                    <tr>
                        <td>${foundStudent.sno}</td>
                        <td>${foundStudent.studentName}</td>
                        <td>${foundStudent.className}</td>
                    </tr>
                </table>
            </div>
        </div>
    </c:if>
</div>

</body>
</html>
